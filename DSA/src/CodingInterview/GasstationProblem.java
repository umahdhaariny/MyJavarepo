package CodingInterview;

public class GasstationProblem {
	
	public static void main (String args[]) {
		int gas[]= {13,2,3,4,5,8};
		int cost[]= { 8,1,2,1,2,13};
		int gassum =0;
		int costsum=0;
		int diff[] = new int[gas.length];
		int total = 0;
		int startindex=0;
		
		for (int i = 0 ; i < gas.length;i++) {
			diff[i] = gas[i]-cost[i];
			gassum+=gas[i];
			costsum=costsum+cost[i];
			if(diff[i] > 0) {
				total +=diff[i];
				if (startindex==0)
					startindex=i;
			}
			else {
				total +=diff[i];
				
				if(total<0)
				{
					total =0;
					startindex=0;
				}
					
			}
			
			
		}
		if(gassum >= costsum) {
			System.out.println("the start indes " + startindex);
		}
		else {
			System.out.println("we cannot traverse");
		}
	}


}
