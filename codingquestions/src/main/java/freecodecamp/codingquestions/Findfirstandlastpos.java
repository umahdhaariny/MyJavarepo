package freecodecamp.codingquestions;

public class Findfirstandlastpos {
	
	public static void main (String args[]) {
		int a[] = {2,4,5,5,5,5,5,5,5,5,5,5,6,6,66,66,66,66,67,86,86,86,86,89,89,89,90};
		//int a[] = {1,2,3,4,4,5,5,6};
		int target = 5;
		findthepositionoftarget(a,target);
		findthepositionoftargetusingbinarysearch(a,target);
	}

	private static void findthepositionoftargetusingbinarysearch(int[] a, int target) {
		// TODO Auto-generated method stub
		int firsttarget=searchtarget(a,target);
		//--firsttarget;
		System.out.println("the firsttarget is "+firsttarget);
		int i=firsttarget;
		int lastindex=0;
		//int a[] = {2,4,5,5,5,6,6,66,66,66,66,67,86,86,86,86,89,89,89,90};
		while(i+1< a.length &&a[i]==target ) {
			
			
			lastindex=i;
			i++;
			
		}
		i=firsttarget;
		while(i>=0 &&a[i]==target ) {
			
			
			firsttarget=i;
			i--;
			
		}
		System.out.println("the firstindex is"+firsttarget);
		System.out.println("the lastindex is"+lastindex);
		
	}

	private static int  searchtarget(int[] a, int target) {
		
		// TODO Auto-generated method stub
		int mid = a.length/2;
		int lp = 0;
		int rp = a.length;
		
		while (lp <= rp) {
			mid=(lp+rp)/2;
			if(target < a[mid]) {
				rp=mid-1;
			}else if(a[mid]==target)
				return mid;
			else 
				lp=mid+1;
			
		}
		return -1;
	}

	private static void findthepositionoftarget(int[] a, int target) {
		// TODO Auto-generated method stub
		int arrlenght=a.length/2;
		int lp=0;
		if(target <= arrlenght) 
			 lp=0;		
		else
			lp=arrlenght+1;
		int count =0;
		int firstindex =0;
		int lastindex=0;
		for (int i = lp ;i <a.length;i++) {
			
			
			while(i+1< a.length &&a[i]==target ) {
				
				count++;
				lastindex=i;
				i++;
			}
		
			
		}
		firstindex=(lastindex-count)+1;
		System.out.println("the first index is"+ firstindex);
		System.out.println("the last index is"+lastindex);
	}

}
