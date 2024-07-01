package CompletableFutureLearning;

import learnjava.domain.Inventory;
import learnjava.domain.Product;
import learnjava.domain.ProductInfo;
import learnjava.domain.ProductOption;
import learnjava.domain.Review;
import learnjava.service.InventoryService;
import learnjava.service.ProductInfoService;
import learnjava.service.ReviewService;

import static learnjava.util.CommonUtil.stopWatch;
import static learnjava.util.LoggerUtil.log;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceusingcf {
    private ProductInfoService productInfoService;
    private ReviewService reviewService;
    private InventoryService inventoryService;

    public ProductServiceusingcf(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    
    public ProductServiceusingcf(ProductInfoService productInfoService, ReviewService reviewService,
			InventoryService inventoryService) {
		super();
		this.productInfoService = productInfoService;
		this.reviewService = reviewService;
		this.inventoryService = inventoryService;
	}


	public Product retrieveProductDetails(String productId) {
        stopWatch.start();
       CompletableFuture<ProductInfo> cfproductinfo= CompletableFuture.supplyAsync(()->productInfoService.retrieveProductInfo(productId));
       CompletableFuture<Review> cfreview= CompletableFuture.supplyAsync(()->reviewService.retrieveReviews(productId));
       
       CompletableFuture<ProductInfo> cfproductinfowithinventory =CompletableFuture.supplyAsync(()->productInfoService.retrieveProductInfo(productId))
    		   .thenApply(productInfo->{
    			   productInfo.setProductOptions(updateInventory(productInfo));
    			   return productInfo;
    		   });
       Product cfproductifo=cfproductinfo.thenCombine(cfreview,(cfp,cfr)->new Product(productId ,cfp,cfr)).join();
        
        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return cfproductifo;
    }
	public Product retrieveProductDetailswithinventory(String productId) {
        stopWatch.start();
      // CompletableFuture<ProductInfo> cfproductinfo= CompletableFuture.supplyAsync(()->productInfoService.retrieveProductInfo(productId));
     
       
       CompletableFuture<ProductInfo> cfproductinfowithinventory =CompletableFuture.supplyAsync(()->productInfoService.retrieveProductInfo(productId))
    		   .thenApply(productInfo->{
    			   productInfo.setProductOptions(updateInventory(productInfo));
    			   return productInfo;
    		   });
       CompletableFuture<Review> cfreview= CompletableFuture.supplyAsync(()->reviewService.retrieveReviews(productId));
       Product cfproductifo=cfproductinfowithinventory.thenCombine(cfreview,(cfp,cfr)->new Product(productId ,cfp,cfr)).join();
        
        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return cfproductifo;
    }

    private List<ProductOption> updateInventory(ProductInfo productInfo) {
		// TODO Auto-generated method stub

    	List<ProductOption> productoptionlist =productInfo.getProductOptions().stream().map( productoption->{
    		//the below addinventory call is adding a delay 
    		Inventory inventory = inventoryService.addInventory(productoption);
    		productoption.setInventory(inventory);
    		
    		
    		return productoption;  
    		
    	}  ).collect(Collectors.toList());
    	
    	return productoptionlist;
    	
	}

    private List<ProductOption> updateInventorywihtoutdelay(ProductInfo productInfo) {
		// TODO Auto-generated method stub
// here we use completableFuture , so we did not see the delay
    
List<CompletableFuture<ProductOption>>productoptionlist=productInfo.getProductOptions().stream().map(productoption ->{
	return CompletableFuture.supplyAsync(()->inventoryService.addInventory(productoption)).
		thenApply(inventory->{
		productoption.setInventory(inventory);
		return productoption;
	});
}).collect(Collectors.toList());
//Here we usejoin -join will make completable future to wait , since completable future work in parallel it will be fast 
    	return productoptionlist.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	public static void main(String[] args) {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceusingcf productService = new ProductServiceusingcf(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);

    }
}
