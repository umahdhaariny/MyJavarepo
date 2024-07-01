package Parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import learnjava.domain.checkout.Cart;
import learnjava.domain.checkout.CartItem;
import learnjava.domain.checkout.CheckoutResponse;
import learnjava.domain.checkout.CheckoutStatus;
import learnjava.service.PriceValidatorService;

public class CheckoutService {
	private PriceValidatorService pricevalidatorservice;
	
	public CheckoutService(PriceValidatorService pricevalidatorservice) {
		this.pricevalidatorservice= pricevalidatorservice;
	}

	public CheckoutResponse checkout(Cart cart) {
		List<CartItem> cartitems= cart.getCartItemList();
	List<CartItem> cl=	cartitems.stream().map(cartitem->{
			boolean ispricevalid = pricevalidatorservice.isCartItemInvalid(cartitem);
			cartitem.setExpired(ispricevalid);
			return cartitem;
			
		}).filter(CartItem::isExpired).collect(Collectors.toList());
		cl.stream().forEach(System.out::println);
		if(cl.size() > 0)
			return new CheckoutResponse(CheckoutStatus.FAILURE,cl);
		return new CheckoutResponse(CheckoutStatus.SUCCESS);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckoutService c = new CheckoutService( new PriceValidatorService());
		Cart cart = new Cart();
		ArrayList<CartItem> cartitem = new ArrayList<CartItem>();
		cartitem.add(new CartItem(7,"test",1.0,1,false));
		cart.setCardId(1);
		cart.setCartItemList(cartitem);
		c.checkout(cart);
	}
	public double finalprice(Cart cart) {
		return cart.getCartItemList().stream().map(n->n.getQuantity()*n.getRate()).
				collect(Collectors.summingDouble(Double::doubleValue));
	}
	//output of map goes to reduce ,0.0 is identity , it tells the type of varible
	public double finalprice_reduce(Cart cart) {
		return cart.getCartItemList().stream().map(n->n.getQuantity()*n.getRate()).reduce(0.0,(x,y)->x+y);
				
	}

}
