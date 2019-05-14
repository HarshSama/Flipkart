package newsfeed;

public class Comment {
	private String commentId;
	private Feed feed;
	private String commentDescription;
	public Comment(String commentId, Feed feed,String commentDescription) {
		super();
		this.commentId = commentId;
		this.feed = feed;
		this.commentDescription=commentDescription;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	

}
