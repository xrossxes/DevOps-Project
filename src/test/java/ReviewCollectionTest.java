import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List; 
/**
 * 
 */

/**
 * @author darkt
 *
 */
class ReviewCollectionTest {
	
	private ReviewCollection rc;
	private Review r1;
	private Review r2;
	private Review r3;
	private final int REVIEW_COLLECTION_SIZE = 3;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		rc = new ReviewCollection();
		r1 = new Review("title1", "comment1");
		r2 = new Review("title2", "comment2");
		r3 = new Review("title3", "comment3");
		
		rc.addReview(r1);
		rc.addReview(r2);
		rc.addReview(r3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddReview() {
		List<Review> testRc = rc.getReviews();
		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE);
		
		rc.addReview(r1);
		
		assertEquals(rc.getReviews().size(), REVIEW_COLLECTION_SIZE+1);
	}
	
	@Test
	void testGetReview() {
		List<Review> testRc = rc.getReviews();
		assertEquals(testRc.size(), 3);
	}
	
	@Test
	void testUpdateReview() {
		List<Review> testRc = rc.getReviews();
		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE);
		
		rc.updateReview(r1);
		
		assertEquals(r1.title, "Updated the title.");
	}
	
	@Test
	void testDeleteReview() {
		List<Review> testRc = rc.getReviews();
		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE);
		
		rc.deleteReview(r1);
		
		assertEquals(rc.getReviews().size(), REVIEW_COLLECTION_SIZE-1);
	}

}
