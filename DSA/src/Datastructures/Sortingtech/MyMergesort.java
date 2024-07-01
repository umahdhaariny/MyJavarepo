package Datastructures.Sortingtech;

import java.util.Arrays;

public class MyMergesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 34,23,12,11};
		applymergesort(a);
		for(int i=0;i < a.length;i++) {
			System.out.println(a[i]);
		}
	}

	private static void applymergesort(int[] a) {
		// TODO Auto-generated method stub
		
		int length = a.length;
		if(length<=1) {
			System.out.println("printing while return");
			Arrays.stream(a).forEach(System.out::println);
			return ;
		}	
		int middle =length/2;
		int leftarray[] = new int[middle];
		int rightarray[] = new int[middle];
		int i =0;
		int l =0;
		int r =0;
		while(l < middle) {
			leftarray[l]=a[i];
			l++;
			i++;
		}
		while(r < middle) {
			rightarray[r]=a[i];
			r++;
			i++;
		}
		System.out.println("before leftarray");
		Arrays.stream(leftarray).forEach(System.out::println);
		applymergesort(leftarray);
		System.out.println("before rightarray");
		Arrays.stream(rightarray).forEach(System.out::println);
		applymergesort(rightarray);
		merge(leftarray,rightarray,a);
		
	}

	private static void merge(int[] leftarray, int[] rightarray, int[] a) {
		// TODO Auto-generated method stub
		int l=0;
		int r=0;
		int leftsize = leftarray.length;
		int rightsize = rightarray.length;
		int orglength=0;
		while ( l <leftsize && r < rightsize) {
			if(leftarray[l]< rightarray[r]) {
				a[orglength]=leftarray[l];
				l++;
				orglength++;
				
			}
			else {
				a[orglength]=rightarray[r];
				r++;
				orglength++;
				
			}
		}
		while( l< leftsize) {
			a[orglength]=leftarray[l];
			l++;
			orglength++;
		}
		while(r < rightsize) {
			a[orglength]=rightarray[r];
			r++;
			orglength++;
		}
	}

}
