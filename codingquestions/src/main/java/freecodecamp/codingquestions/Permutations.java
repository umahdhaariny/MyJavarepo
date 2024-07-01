package freecodecamp.codingquestions;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str = "abc";
			printpermutation(str.toCharArray() , 0);
	}

	private static void printpermutation(char str[], int indextoswap) {
		
		// TODO Auto-generated method stub
		if(indextoswap==str.length-1) {
			System.out.println(str);
			return;
		}	
		for(int i=indextoswap;i<str.length;i++) {
			swap(str,i,indextoswap);
			printpermutation(str,indextoswap+1);
			swap(str,i,indextoswap);
			System.out.println("brin back to same pos");
			System.out.println(str);
			
			
		}
			
		
	}

	private static void swap(char[] str, int i, int indextoswap) {
		// TODO Auto-generated method stub
		char c = str[i];
		str[i]=str[indextoswap];
		str[indextoswap]=c;
	}

}
