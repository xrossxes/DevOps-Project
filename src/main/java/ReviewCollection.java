import java.util.*;

public class ReviewCollection {

	private ArrayList<Review> reviews = new ArrayList<>();
	private int capacity;

	public ReviewCollection() {
		
		this.capacity = 20;
	}

	public ReviewCollection(int capacity) {
		this.capacity = capacity;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		if (reviews.size() != capacity) {
			reviews.add(review);
		}
	}

	public void updateReview(Review review) {
		review.title = "Updated the title.";
	}

	public void deleteReview(Review review) {
		if (reviews.size() != capacity) {
			reviews.remove(review);
		}
	}

}