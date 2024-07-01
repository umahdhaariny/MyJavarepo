package Datastructures.Sortingtech;

import java.util.Arrays;

public class QuicksortTech {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a[] = { 8, 4, 1 ,5, 6,2};
			quicksort(a,0,a.length-1);
			Arrays.stream(a).forEach(System.out::println);
	}

	private static void quicksort(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		if(end<=start)
			return ;
		
		int pivot = partition(a,start,end);
		quicksort(a,start,pivot-1);
		quicksort(a,pivot+1,end);
		
	}

	private static int partition(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = a[end];
		int i = start;
		int j = start-1;
		
		for (; i<end;i++) {
			if(a[i]< pivot) {
				int temp=a[i];
				j++;
				a[i]=a[j];
				a[j]=temp;
			}
			
		}
		j++;
		int temp=a[j];
		a[j]=pivot;
		a[i]=temp;
	
		return j;
	}

}
