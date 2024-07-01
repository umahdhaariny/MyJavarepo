package DynamicProgramming;

import java.util.Arrays;

public class Climbingstairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int jump[] = {30,10,60,10,60,50};
int minenergy=findminenergywithrecursion(jump,0);
System.out.println("min energy"+minenergy);
int dp[]= new int[jump.length+1];
for(int i =0; i < dp.length-1;i++)
	dp[i]=-1;
System.out.println("usage of memoization");
findminenergywithmemoization(jump,0,dp);
System.out.println("usage of memoization -printing valiues");
Arrays.stream(dp).forEach(System.out::println);
System.out.println("using tabulation");

findminenergywithtabulation(jump);
	}

	private static void findminenergywithtabulation(int[] jump) {
		// TODO Auto-generated method stub
		int sum =0;
	//	int dp[]= new int[jump.length+1];replace this wiht sum
		//calculate from base case(bottom up)
//		for(int i =0; i < dp.length;i++)
//			dp[i]=-1;
		for (int index=0;index <jump.length-2;index++) {
			
			//dp[index]=Math.min(jump[index+1]-jump[index], jump[index+2]-jump[index]);
			sum+=Math.min(jump[index+1]-jump[index], jump[index+2]-jump[index]);
			//System.out.println("tabulation"+dp[index]);
		}
		System.out.println("Energy level is"+sum);
	}
	private static int findminenergywithmemoization(int[] jump, int index,int dp[]) {
		int min=0;
		if(index == jump.length-2)
			return 0;
		if (dp[index] != -1){
			return dp[index];
		}
		if(index < jump.length-2)
		 min = Math.min(jump[index+2]-jump[index],jump[index+1]-jump[index] );
		System.out.println("minimum energy in memo"+min);
		dp[index]= min+findminenergywithmemoization(jump,index+1,dp);
		System.out.println("mem"+dp[index]);
		return dp[index];
	}

	private static int findminenergywithrecursion(int[] jump,int index) {
		// TODO Auto-generated method stub
		int min=0;
		if(index == jump.length-2)
			return 0;
		if(index < jump.length-2)
		 min = Math.min(jump[index+2]-jump[index],jump[index+1]-jump[index] );
		index++;
		System.out.println("minimum energy"+min);
		return min+findminenergywithrecursion(jump,index);
		
	}

}
