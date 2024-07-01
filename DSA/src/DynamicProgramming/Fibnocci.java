package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

//https://takeuforward.org/data-structure/dynamic-programming-introduction/
public class Fibnocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] dp = new Integer[] {-1,-1,-1,-1};
		int n=6;
		ArrayList<Integer> intlist = new ArrayList();
		System.out.println("in "+fib(n,intlist));
			
		//intlist.stream().forEach(System.out::println);
		System.out.println("using dp");
		fibusingtabulation(n);
		int dp[] = new int[n+1];
		for(int i =0 ;i<dp.length;i++)
			dp[i]=-1;
		fibusingmemoization(n,dp);
		System.out.println("using memoization");
		Arrays.stream(dp).forEach(System.out::println);

	}
//usage of memoization
	private static int fibusingmemoization(int i, int[] dp) {
		// TODO Auto-generated method stub
		if(i <=1) 			
			return i ;
		
		if(dp[i] != -1)//using a one dimensional array to store
			return dp[i];
		dp[i]= (fibusingmemoization(i-1,dp)+fibusingmemoization(i-2,dp))	;//2,1 ,3,2,1

		return dp[i];
	}
//use of recursion
	private static int  fib(int i,ArrayList<Integer>intlist) {
		// TODO Auto-generated method stub
		if(i <=1) {
			
			return i ;
		}
		int sum= (fib(i-1,intlist)+fib(i-2,intlist))	;//2,1 ,3,2,1
	//	System.out.println(sum);
		intlist.add(sum);
		return sum;
	}
	private static void fibusingtabulation(int i) {
		
		
		Integer dp[] = new Integer[i+1];
		dp[0] =0;//store the base case 
		dp[1] =1;
		//calculate from base case(bottom up)
		for (int index=2;index <=i;index++) {
			dp[index]=dp[index-1]+dp[index-2];
		}
		
		for (int index:dp)
			System.out.println(index);
		
	}

}
