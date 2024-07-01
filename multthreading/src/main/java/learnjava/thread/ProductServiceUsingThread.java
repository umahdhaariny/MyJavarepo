package learnjava.thread;

import learnjava.domain.Product;
import learnjava.domain.ProductInfo;
import learnjava.domain.Review;
import learnjava.service.ProductInfoService;
import learnjava.service.ReviewService;

import static learnjava.util.CommonUtil.stopWatch;
import static learnjava.util.LoggerUtil.log;

public class ProductServiceUsingThread {
    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public ProductServiceUsingThread(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws InterruptedException {
        stopWatch.start();
        ProductinfoRunnable productinfoRunnable  = new ProductinfoRunnable(productId,productInfoService);
        Thread productinfoThread = new Thread(productinfoRunnable);

        Reviewrunnable Reviewrunnable = new Reviewrunnable(productId,reviewService);
        
        Thread reviewthread = new Thread(Reviewrunnable);
        productinfoThread.start();
        reviewthread.start();
        productinfoThread.join();
        reviewthread.join();
        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        ProductInfo productInfo = productinfoRunnable.getProductinfo();
        Review review = Reviewrunnable.getReview();
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) throws InterruptedException {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingThread productService = new ProductServiceUsingThread(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);

    }
}
