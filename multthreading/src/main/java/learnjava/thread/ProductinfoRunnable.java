package learnjava.thread;

import learnjava.domain.ProductInfo;
import learnjava.service.ProductInfoService;

public class ProductinfoRunnable implements Runnable {
	//private ProductInfo productinfo;
	private String productid ;
    private ProductInfo productInfo;
    
    private ProductInfoService productinfoservice;

	public ProductinfoRunnable(String productid,ProductInfoService p) {
		this.productid = productid;
		this.productinfoservice = p;
	}
	
	
	public ProductInfo getProductinfo() {
		return productInfo;
	}


	public void setProductinfo(ProductInfo productinfo) {
		this.productInfo = productinfo;
	}
	


	public String getProductid() {
		return productid;
	}


	public void setProductid(String productid) {
		this.productid = productid;
	}


	public ProductInfo getProductInfoService() {
		return productInfo;
	}


	/*public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}*/


	@Override
	public void run() {
		// TODO Auto-generated method stub
		productInfo=productinfoservice.retrieveProductInfo(productid);

	}

}
