package learnjava.thread;

import learnjava.domain.Review;
import learnjava.service.ReviewService;

public class Reviewrunnable implements Runnable {
	 private String productid;
	 private Review review;
	 private ReviewService reviewservice;
	public Reviewrunnable(String productid,ReviewService reviewService) {
		this.productid=productid;
		this.reviewservice = reviewService;
	}
	

	public String getProductid() {
		return productid;
	}


	public void setProductid(String productid) {
		this.productid = productid;
	}


	public Review getReview() {
		return review;
	}


	public void setReview(Review review) {
		this.review = review;
	}


	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		review = reviewservice.retrieveReviews(productid);

	}

}
