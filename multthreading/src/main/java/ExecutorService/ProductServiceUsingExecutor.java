package ExecutorService;

import learnjava.domain.Product;
import learnjava.domain.ProductInfo;
import learnjava.domain.Review;
import learnjava.service.ProductInfoService;
import learnjava.service.ReviewService;

import static learnjava.util.CommonUtil.stopWatch;
import static learnjava.util.LoggerUtil.log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ProductServiceUsingExecutor {
	static ExecutorService executorservice  = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public ProductServiceUsingExecutor(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws InterruptedException, ExecutionException, TimeoutException {
        stopWatch.start();

    Future<ProductInfo> productinfoFuture = executorservice.submit(()->productInfoService.retrieveProductInfo(productId));
    Future<Review>  reviewinfofuture = executorservice.submit(()->reviewService.retrieveReviews(productId));
        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
 //  ProductInfo productInfo = productinfoFuture.get();
        ProductInfo productInfo = productinfoFuture.get(1,TimeUnit.SECONDS );
   Review review = reviewinfofuture.get();
        return new Product(productId, productInfo, review);

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingExecutor productService = new ProductServiceUsingExecutor(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);  
        executorservice.shutdown();                                                                                                                      

    }
}
