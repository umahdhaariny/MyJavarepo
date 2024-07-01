package CodingInterview;

import java.util.ArrayList;

public class Indexofelementinarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1 ,1,2,22, 32, 32,32,32, 33, 34};
		int num = 33;
		ArrayList<Integer>intlist =find(arr , num);
	
		System.out.println("first index" +	intlist.get(0));
		System.out.println("secondindex "+intlist.get(intlist.size()-1));
		
	System.out.println("find_dividetech" +find_dividetech(arr,num));

	}

	private static ArrayList<Integer> find(int[] arr, int num) {
		// TODO Auto-generated method stub
		ArrayList<Integer> intlist = new ArrayList<Integer> ();
		if(arr.length == 0)
			return null;
		
		for (int i = 0;i < arr.length;i++) {
			if(arr[i]==num) 
				intlist.add(i);
			
		}
		if (intlist.size() ==0 ) {
			intlist.add(-1);
			intlist.add(-1);
		}	if(intlist.size()==1) 
			
			intlist.add(-1);
		return intlist;
	}
	//int arr[] = { 1 ,1,2,22, 32, 32,32,32, 33, 34};
	private static int find_dividetech(int[] arr,int num) {
		if(arr[0] == num) 
			return 0;
		int lp = 0; 
		int rp = arr.length-1;
		
		int mid = lp+rp/2;
		while (lp <= rp) {
			mid = (lp+rp)/2;
			if( arr[mid] < num )
				lp=mid+1;
			else if (arr[mid] == num)
				return mid;
			else
				rp=mid-1;
		}
		return -1;
	}

}
