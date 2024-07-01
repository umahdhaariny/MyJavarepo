package com.learnjavastreams;

import java.util.ArrayList;
import java.util.Iterator;

public class MyConcurrentException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ArrayList<Integer> intlist = new ArrayList();
		for (int i=0;i <10;i++)
			intlist.add(i);
		//throwconcurrentexception(intlist);
		throwceinstreams(intlist);
			
	}
	public static void myprint(int i) {
		System.out.println(i*i);
	}

	private static void throwceinstreams(ArrayList<Integer> intlist) {
		// TODO Auto-generated method stub
		intlist.stream().map(i->i).forEach(intlist::add);;//you are traversing and you are trying to modify the same collection
		
	}

	private static void throwconcurrentexception(ArrayList<Integer> intlist) {
		// TODO Auto-generated method stub
		Iterator itr = intlist.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			intlist.add(1);//while iterating  if you try to add anything to your list it will throw concurrent modification exception
		}
		itr = intlist.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			intlist.remove(itr.next());
		}
	}

}
