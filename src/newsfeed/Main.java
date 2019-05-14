package newsfeed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader=new BufferedReader(new FileReader(new File("D:\\Sample.txt")));
		String line=reader.readLine();
		SignUp signup = new SignUp();
		User currentLogin = null;
		int feedCounter =1;
		int voteCounter =1;
		int commentCounter =1;
		while(line!=null)
		{
			String[] split =line.split("~");
			switch(split[0])
			{
			case "logout":
				currentLogin = null;
				break;
			case "login":
				Set<User> users=signup.getRegisteredUsers();
				currentLogin=loginFunctionality(users,split[1],currentLogin);
				//loginFunctionality(users,split[1]);
				break;
			case "signup":	
				User user = new User(split[1]);
				signup.addUser(user);
				break;
			case "upvote" :
				Set<User> userslistforUp = signup.getRegisteredUsers();
				Feed feedFoundUp=findFeed(userslistforUp,split[1]);
				if(feedFoundUp!=null)
				{
				Vote voteUp = new Vote(Integer.toString(voteCounter), "Up",feedFoundUp );
				feedFoundUp.addVoteToFeed(voteUp);
				currentLogin.addVote(voteUp);
				voteCounter++;
				}
				else
				{
					System.out.println("Vote to wrong Feed");
				}
				break;
			case "downvote" :
				Set<User> userslistforDown = signup.getRegisteredUsers();
				Feed feedFoundDown=findFeed(userslistforDown,split[1]);
				if(feedFoundDown!=null) {
				Vote voteDown = new Vote(Integer.toString(voteCounter), "Down",feedFoundDown );
				feedFoundDown.addVoteToFeed(voteDown);
				currentLogin.addVote(voteDown);
				voteCounter++;
				}
				else
				{
					System.out.println("Vote to wrong Feed");
				}
				break;
			case "post":
				Feed feed = new Feed(Integer.toString(feedCounter),new Date(),currentLogin,split[1]);
				currentLogin.addFeed(feed);
				feedCounter++;
				break;
			case "follow":
				Set<User> userslist = signup.getRegisteredUsers();
				User userfound = findUserfromuserId(userslist,split[1]);
				if(userfound!=null)
				{
					currentLogin.addFollower(userfound);
				}
				else
				{
					System.out.println("Not a valid user");
				}
				break;
			case "shownewsfeed":
				printnewsfeed(currentLogin, signup.getRegisteredUsers());
				break;
			case "reply":
				Set<User> usersforComment = signup.getRegisteredUsers();
				Feed feedFound=findFeed(usersforComment,split[1]);
				if(feedFound!=null)
				{
				Comment comment= new Comment(Integer.toString(commentCounter), feedFound,split[2]);
				feedFound.addCommenttoFeed(comment);
				currentLogin.addComments(comment);
				commentCounter++;
				}
				else
				{
					System.out.println("Comment to wrong Feed");
				}
				break;
				default:
					System.out.println("Not valid command");
					
			}
			line= reader.readLine();
	}	
		reader.close();
		}
		
		
		// TODO Auto-generated method stub
	public static Feed findFeed(Set<User> userslist,String feedId)
	{
		Feed feedFound=null;
		for(User user:userslist)
	{
		for(Feed feed:user.getFeeds())
		{
		if(feed.getFeedId().equals(feedId))
		{
			feedFound =feed;
										
		}
		}
	}
		return feedFound;
	}
	public static User findUserfromuserId(Set<User> userslist,String userId)
	{
		for(User user:userslist)
		{
			if(user.getUserId().equals(userId))
			{
			return user;
			}
		}
		return null;
	}
	public static User loginFunctionality(Set<User> users,String userId,User currentLogin)
	{ 
		int i=0;
		for(User user:users)
		{
			if(user.getUserId().contentEquals(userId))
			{
				i=1;
				currentLogin = user;
			//	currentLogin.setCurrentlogin(user);
				break;
				
			}
		}
		if(i==0)
		{
			System.out.println("User is not SignUp");
		}
		else
		{
			printnewsfeed(currentLogin,users);
		}
		return currentLogin; 
	}
	public static void printnewsfeed(User currentLogin,Set<User> users)
	{
		Set<User> userfollows=currentLogin.getUserFollows();
		List<Feed> userfollowsfeed = new ArrayList<>();
		 for(User user:userfollows)
		 {
		 userfollowsfeed.addAll(user.getFeeds());
		 }
		 Collections.sort((List<Feed>) userfollowsfeed);
		 printFeedsfromList(userfollowsfeed);
		 List<Feed> currentUserFeed = new ArrayList<>(currentLogin.getFeeds());
		 Collections.sort(currentUserFeed);
		 printFeedsfromList(currentUserFeed);
		 List<Feed> remainingUsersFeed=new ArrayList();
		 for(User user:users)
		 {
			 if(user!=currentLogin && !userfollows.contains(user))
			 {
				 remainingUsersFeed.addAll(user.getFeeds());
			 }
		 }
		 Collections.sort(remainingUsersFeed);
		 printFeedsfromList(remainingUsersFeed);
		}
	public  static void printFeedsfromList(List<Feed> feeds)
	{
		for(Feed feed:feeds)
		 {
			 System.out.println(feed.getFeedId());
			 System.out.println(feed.getVotes());
			 System.out.println(feed.getUser().getUserId());
			 System.out.println(feed.getFeedDescription());
			 System.out.println(feed.getDate());
		 }
	}
	

}
