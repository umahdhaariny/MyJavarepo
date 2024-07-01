package Arrayinjava;

public class reversearray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = { 1,2,4,5,6,7};
		if(a.length == 0) 
			System.out.println("Noe lement in array");
	
		
		for (int i=a.length-1;i>=0;i--)
				System.out.print(a[i]);
		}

	

}
