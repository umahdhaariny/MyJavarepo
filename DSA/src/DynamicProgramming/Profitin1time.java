package DynamicProgramming;

public class Profitin1time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int price_on_days[] = { 10 ,5, 24,12,1,87,89,90};
			findhighestprofit(price_on_days);
			
	}



	private static void findhighestprofit(int[] price_on_days) {
		// TODO Auto-generated method stub
		int sellprice =0;
		int buyprice=price_on_days[0];
		int currentprofit=0;
		int profit =0;
		for(int i=1;i<price_on_days.length;i++) {
			
			sellprice=Math.max(sellprice, price_on_days[i]);
			currentprofit=sellprice-buyprice;
			profit=Math.max(currentprofit, profit);
			buyprice=Math.min(buyprice, price_on_days[i]);
			
		}
		System.out.println("buyprice"+buyprice +"sellprice" +sellprice+"the max profit is"+profit  );
	}

}
