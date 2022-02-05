
public class Review {
	protected String title;
	public Review(String title, String comment) {
		super();
		this.title = title;
		this.comment = comment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	protected String comment;
 
}
