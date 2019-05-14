package newsfeed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class User {
public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Set<User> getUserFollows() {
		return userFollows;
	}
	public void setUserFollows(Set<User> userFollows) {
		this.userFollows = userFollows;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<Feed> getFeeds() {
		return feeds;
	}
	public void setFeeds(Set<Feed> feeds) {
		this.feeds = feeds;
	}
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
String userId;
Set<User> userFollows;
Set<Comment> comments;
Set<Feed> feeds;
List<Vote> votes;
public User(String userId)
{
	this.userId=userId;
	userFollows=new HashSet();
	comments=new HashSet();
	feeds=new HashSet<Feed>();
	votes=new ArrayList();
}
public User()
{
	
}
public void addFollower(User user)
{
	userFollows.add(user);
}
public void addComments(Comment comment)
{
	comments.add(comment);
}
public void addFeed(Feed feed)
{
	feeds.add(feed);
}
public void addVote(Vote  vote)
{
	votes.add(vote);
}
public void setCurrentlogin(User user)
{
	setUserId(user.getUserId());
	setFeeds(user.getFeeds());
}
}
