package PractiveJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnConcurrentException {

	
	public static void main(String args[]) {
		Empimpl emp = new Empimpl();
		List<Employee> emplist = emp.createemployee();
		Iterator <Employee>itr = emplist.iterator();
		
		removeusingiteratoru(itr,emplist);
		removingwithoutiterator(emplist);
	}

	private static void removingwithoutiterator(List <Employee>emplist) {
		for( Employee e : emplist) {
			if(e.getAge()==38)
				emplist.remove(e);
		}
	}
	private static void removeusingiteratoru(Iterator<Employee> itr,List <Employee>e) {
		// TODO Auto-generated method stub
		
		while(itr.hasNext()) {
			Employee e1=(Employee) itr.next();
			if (e1.getAge()==38)
				e.remove(e1);
			System.out.println(e);
		}
	}
}
