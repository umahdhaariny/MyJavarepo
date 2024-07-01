package Parallelstreams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import learnjava.domain.checkout.Cart;
import learnjava.domain.checkout.CheckoutResponse;
import learnjava.domain.checkout.CheckoutStatus;
import learnjava.service.PriceValidatorService;
import learnjava.util.DataSet;

class CheckoutServiceTest {

	PriceValidatorService p = new PriceValidatorService();
	CheckoutService cs = new CheckoutService(p);
	
	@Test
	void checkout_6_items() {
		Cart cart = DataSet.createCart(6);
		 CheckoutResponse r = cs.checkout(cart);
		 assertEquals(CheckoutStatus.SUCCESS,r.getCheckoutStatus());//to check value 
		 assertTrue(cs.finalprice(cart)>0);//when you use condition 
		 assertTrue(cs.finalprice_reduce(cart)>0);//when you use condition 
	}

}
