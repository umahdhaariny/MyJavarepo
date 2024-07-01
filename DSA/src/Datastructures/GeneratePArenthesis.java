package Datastructures;

import java.util.Stack;

public class GeneratePArenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				String str = "((())))";
				Boolean value =generateparent(str);
				if(value) 
					System.out.println("Paren matching ");
				else
					System.out.println("paren not matching");
				
	}

	private static Boolean generateparent(String str) {
		// TODO Auto-generated method stub
		Stack<Character> parenstack= new Stack();
		for (char c :str.toCharArray()) {
			if(c == '(') {
				parenstack.push(c);
			}
			else if ((parenstack.size()!=0)&&(c == ')')) {
				parenstack.pop();
			}
			else if(parenstack.size()==0)
				return false;
			
		}
		return true;

		
	}

}
