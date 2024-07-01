package learnjava.service;

import static learnjava.util.CommonUtil.delay;

import learnjava.domain.Review;

public class ReviewService {

    public Review retrieveReviews(String productId) {
        delay(1000);
        return new Review(200, 4.5);
    }
}
