package freecodecamp.codingquestions;

public class Gasstation {
//Traverse from one gas station to other and you should come to the same station without runnign out of gas
	//petrol need to travel from 1 is 1-5 = -4  you are running out of gas cannot move from here
	//at index 2 5-2 = 3 ,you can move to next ,3-2  = 1 (3+1)=4 , move to next 3-8=-5 (-5+4) =-1 run out of gas 
	//likwise move on and come to the same station you should not run out of gases 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gas[] =  {1,5,3,3,5,3,1,3,4,5};
		int price[]= {5,2,2,8,2,4,2,5,1,2};
		findgastation(gas,price);

	}

	private static void findgastation(int[] gas, int[] price) {
		// TODO Auto-generated method stub
		int currentprice =0;
		int sum=0;
		int startstation =0;
		for (int i =0; i<gas.length;i++) {
			currentprice += gas[i]-price[i];
			
			if(currentprice < 0) { 
				startstation=i+1;
				currentprice = 0;
			}	
			
			
		}
		for(int i =0;i <startstation;i++) {
			currentprice += gas[i]-price[i];
			if(currentprice < 0)
				currentprice = -1;
		}
		if(currentprice < 0)
			System.out.println("no cyclic station found ");
		else
			System.out.println("startstation is"+startstation);
		
	}

}
