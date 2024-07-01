package CodingInterview;

import java.security.PKCS12Attribute;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagramwihtstream {
	
	private static Object var;
	public static void main(String args[]) {
		String s1 = "gardenebd";
		String s2 = "deengabra";
		boolean anagram=isanagramwithoutstreams(s1,s2);
		if(anagram==true)
			System.out.println("The string is anagram");
		else
			System.out.println("The strings are not anagram");
	}

	private static boolean isanagramwithstreams(String s1,String s2) {
		// TODO Auto-generated method stub
		if(s1.length()!= s2.length()) {
			System.out.println("its not anagram");
			return false;
		}
	Map <Character , Long>charmap1=s1.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	Map <Character, Long>charmap2=s2.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	boolean value = checkanagram(charmap1,charmap2);
	return value;
	}
	public static boolean checkanagram(Map <Character , Long>charmap1,Map <Character , Long>charmap2) {
		if( charmap1.size() == charmap2.size())
		{
			for ( Character c : charmap1.keySet()) {
				if(charmap2.containsKey(c)) {
					if(charmap1.get(c)== charmap2.get(c))
						continue;
					else
						return false;
				}
				else {
					return false ;
				}
			}
			System.out.println("both strings are anagream of each othere");
			return true;
		}
		else {
			System.out.println("the string is not anagram");
			return false;
		}
	}
	public static boolean isanagramwithoutstreams(String s1,String s2) {
			if(s1.length()!= s2.length()) {
				System.out.println("its not anagram");
				return false;
			}
			
			Map <Character , Long>charmap1 = new HashMap();
			Map <Character , Long>charmap2 = new HashMap();
			
			for ( char c : s1.toCharArray()) {
				if(charmap1.isEmpty())
					charmap1.put(c, 1L);
				else {
					Long var= (charmap1.containsKey(c)) ?charmap1.put(c, charmap1.get(c)+1L) : charmap1.put(c, 1L);			
				}
			}
			for ( char c : s2.toCharArray()) {
				if(charmap2.isEmpty())
					charmap2.put(c, 1L);
				else {
					var var= (charmap2.containsKey(c)) ?charmap2.put(c, charmap2.get(c)+1L) : charmap2.put(c, 1L);						
				}
			}
			
			return (checkanagram(charmap1,charmap2));
			//return false;
			
		}

}
