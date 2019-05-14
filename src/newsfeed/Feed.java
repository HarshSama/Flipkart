package newsfeed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Feed implements Comparable{
	private String feedId;
	private String feedDescription;
	private Date date;
	private Set<Comment> comments=new HashSet<Comment>();
	private Set<Vote> votes=new HashSet<Vote>();
	private User user;
	
	public Feed(String feedId,Date date,User user,String feedDescription)
	{
		this.feedId=feedId;
		this.date=date;
		this.user=user;
		this.feedDescription=feedDescription;
	}
	public String getFeedDescription() {
		return feedDescription;
	}
	public void setFeedDescription(String feedDescription) {
		this.feedDescription = feedDescription;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFeedId() {
		return feedId;
	}
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}
	public void addCommenttoFeed(Comment comment)
	{
		comments.add(comment);
	}
	public void addVoteToFeed(Vote vote)
	{
		votes.add(vote);
	}
	@Override
	public int compareTo(Object o) {
		int upVote=0;
		int downVote=0;
		for(Vote vote:((Feed) o).getVotes()) {
			if(vote.getUpDown().equals("Up"))
				upVote++;
				else
			  downVote++;		
		}
		int scoreOne =upVote-downVote;
		upVote=0;
				downVote=0;
		for(Vote vote:this.getVotes()) {
			if(vote.getUpDown().equals("Up"))
				upVote++;
				else
			  downVote++;		
		}
		int scoreTwo=upVote-downVote;
		if(scoreOne!=scoreTwo)
			return scoreOne-scoreTwo;
		if(this.getComments().size()!=((Feed)o).getComments().size())
			return ((Feed)o).getComments().size()-this.getComments().size();

		// TODO Auto-generated method stub
		return -(this.getDate().compareTo(((Feed)o).getDate()));
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<Vote> getVotes() {
		return votes;
	}
	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}
	

}
