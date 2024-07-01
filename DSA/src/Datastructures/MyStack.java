package Datastructures;

import java.util.Scanner;

public class MyStack {

	public Node head;
	public Node tail;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to create stack");
		MyStack firststack = new MyStack();
		String c = scan.next();
			while(c.equalsIgnoreCase("A") || c.equalsIgnoreCase("R")) {
				
				if(c.equalsIgnoreCase("A")) {
					System.out.println("Enter element ot be added to stack");
					int data = scan.nextInt();
					firststack.push(data);
				}
				if(c.equalsIgnoreCase("R")) {
					firststack.pop();
					
				}
						
				
				
				
				System.out.println("Do you want to continue adding  element or remove element");
				 c = scan.next();
			}
			firststack.printstack();
	}

	private void pop() {
		// TODO Auto-generated method stubh
		head = head.next;
		
	}

	private  void printstack() {
		// TODO Auto-generated method stub
		Node temp =head;
		while(temp != null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}

	public void push(int data) {
		// TODO Auto-generated method stub
		Node temp = new Node(data);
		if(head == null) {
			head=temp;
			tail=temp;
			temp.next=null;
		}
		else {
			temp.next=head;
			head=temp;
			
		}
		
	}

}
