package newsfeed;

public class Vote {
private String voteId;
private String upDown;
private Feed feed;
public String getVoteId() {
	return voteId;
}
public void setVoteId(String voteId) {
	this.voteId = voteId;
}
public String getUpDown() {
	return upDown;
}
public void setUpDown(String upDown) {
	this.upDown = upDown;
}
public Feed getFeed() {
	return feed;
}
public void setFeed(Feed feed) {
	this.feed = feed;
}
public Vote(String voteId, String upDown, Feed feed) {
	super();
	this.voteId = voteId;
	this.upDown = upDown;
	this.feed = feed;
}

}
