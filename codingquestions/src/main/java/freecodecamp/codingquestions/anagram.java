package freecodecamp.codingquestions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class anagram {
	public static void main(String args[]) {
		String str = "imalayalamio";
		Findisanagram(str);
		finreverseofstr(str);
		
		findusingjava8(str);
		
	}

	private static void findusingjava8(String str) {
		// TODO Auto-generated method stub
		Map<Character, Long>charcount=str.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		long count =charcount.entrySet().stream().filter(e->e.getValue()==1).count();
		System.out.println("java8");
		System.out.print(count);
		if(count >1 ) {
			System.out.println("Using java8"+"the string is not anagram");
		}
		
	}

	private static void finreverseofstr(String str) {
		// TODO Auto-generated method stub
		StringBuffer strnew = new StringBuffer();
		for (int i= str.length()-1; i >=0;i--){
			strnew.append(str.charAt(i));
		}
		System.out.println("The reverse of string is"+strnew);
	}

	private static void Findisanagram(String str) {
		// TODO Auto-generated method stub
		
		StringBuffer strnew = new StringBuffer(str);
		int first=0;
		int last=strnew.length()-1;
		int mid =last/2;
		int count=0;
		while(first < mid && last>mid) {
			if(strnew.charAt(first)==strnew.charAt(last)) 
				count++;
			
	
			first++;
			last--;
		}
		System.out.println("the count is "+count);
		if(count == mid) {
			System.out.println("Given string is anagram ");
		}
		else {
			System.out.println("given streing is not anagram");
		}
	}

}
