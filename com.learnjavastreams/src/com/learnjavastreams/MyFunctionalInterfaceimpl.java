package com.learnjavastreams;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class MyFunctionalInterfaceimpl implements MyFunctionalInterface{
	
	public static void main(String args[]) {
		MyFunctionalInterface addfun = (num1,num2)->num1+num2;
		
		System.out.println("The total is"+  addfun.add(5, 6));
		ArrayList<Integer> intlist=new ArrayList();
		intlist.add(1);
		intlist.add(2);
	
		addfun.printstring("Hello", "world");
		
		String str=MyFunctionalInterface.strinfjoin("Welcome", "Welcome");
		System.out.println("value from static method"+str);
		MyFunctionalInterfaceimpl o1 = new MyFunctionalInterfaceimpl();
		o1.usageofmethodref();
		str="tesing";
		o1.printstring(str, str);
		str =MyFunctionalInterfaceimpl.strinfjoin("welome", "here");
		System.out.println("to test overident function of static ="+str);
	}
	public static String strinfjoin(String s1,String s2) {
		String str = s1+s2+"i am overriden";
		return str;
		
	}
//	public  void printstring(String s1,String s2) {
//		System.out.println(" i am trying to override the deffaul method");
//	}
	public  void usageofmethodref() {
		// TODO Auto-generated method stub
		BiFunction<String, String, String>adder1 = MyFunctionalInterface::strinfjoin; 
		String str=adder1.apply("hello", "working");
		System.out.println("In custom usageofmethodref= "+str);
	}

	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return 0;
	}



}
