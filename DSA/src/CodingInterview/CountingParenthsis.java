package CodingInterview;

import java.util.Stack;

public class CountingParenthsis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s ="(()()())";
			countmyparen(s);
	}

	private static void countmyparen(String s) {
		// TODO Auto-generated method stub
		Stack<Character> stackchar = new Stack();
//		int opencount =0;
//		int closecount=0;
		for ( char c : s.toCharArray()) {
		//	stackchar.push(c);
			if( c == ')') {
				if(stackchar.isEmpty()) 
					
				{
					System.out.println("No match for close parenthesis");
					return;
				}
				
				stackchar.pop();
			//	closecount++;
			}
			else if(( c== '(') ) {
				stackchar.push(c);
			//	opencount++;
			}
		}

	//	if(closecount == opencount)
		if(stackchar.isEmpty())
			System.out.println("the parenthesis matches");
		else 
			System.out.println("parenthesis does not match");
		
		
	}

}
