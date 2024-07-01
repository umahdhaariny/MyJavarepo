package Datastructures;

public class MyQueue {
	public Node head;
	public Node tail;

	public static void main(String args[]) {
		MyQueue queue =  new MyQueue();
		queue.add(10);

		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.print();
		queue.remove();
		queue.print();

	}

	private void remove() {
		// TODO Auto-generated method stub
		Node temp = head;
		Node prev = null;
		while(temp.next != null) {
			prev = temp;
			temp=temp.next;
			
		}
		prev.next=null;
	}

	private void print() {
		// TODO Auto-generated method stub
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	private void add(int i) {
		// TODO Auto-generated method stub
		Node temp = new Node (i);
		if(head == null) {
			head=temp;
			tail=head;
		}
		else {
			tail.next=temp;
			tail=temp;
		}
	}
}
