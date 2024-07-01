package Datastructures;

import java.util.Scanner;

class Node{
	Node next;
	int data;
	public Node(int data) {
		super();
		this.data = data;
	}
	
}

public class ReverseLinkedList {
	public Node head;
	public Node tail;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ReverseLinkedList list1 = new ReverseLinkedList();
		
		list1.createlist();
		System.out.println("list1");
		list1.printlist();
		ReverseLinkedList list2 = new ReverseLinkedList();
		list2.createlist();
		System.out.println("list2");
		list2.printlist();
		Scanner scan  = new Scanner(System.in);
		System.out.println("Enter the Do you want to merge the list");
		String c = scan.next();
		if(c.equalsIgnoreCase("Y")) {
			mergelist(list1,list2);
		
			System.out.println("merge list");
			list1.printlist();
		}
	
		System.out.println("Enter the Do you want to merge the list");
		 c = scan.next();
		 if(c.equalsIgnoreCase("Y")) {
				list1.reverselist();
			
				System.out.println("REverse list");
				list1.printlist();
			}
			
	}

	private void reverselist() {
		// TODO Auto-generated method stub
		Node Current = head;
		Node prev = null;
		Node nextnode=null;
		//0x22  0x24 0x26 0x28
		//null 0x22 
		while(Current != null) {
			nextnode=Current.next;
			Current.next=prev;
			prev=Current;
			Current=nextnode;;
			
			
		}
		head=prev;
	}

	private static void mergelist(ReverseLinkedList list1, ReverseLinkedList list2) {
		// TODO Auto-generated method stub
		Node temp = list1.head;
		while (temp.next != null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		temp.next=list2.head;
	}

	private void printlist() {
		// TODO Auto-generated method stub
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}

	private void createlist() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("how many  nodes have to be inserted");
		int numofnode=scan.nextInt();
		
		for (int index =0 ;index < numofnode;index++) {
			System.out.println("Enter the data");
			int num = scan.nextInt();
			Node temp = new Node(num);
			if(head == null) {
				head=temp;
				tail=temp;
			}
			else {
				tail.next=temp;
				tail=temp;
			}
		}
		
	}

}
