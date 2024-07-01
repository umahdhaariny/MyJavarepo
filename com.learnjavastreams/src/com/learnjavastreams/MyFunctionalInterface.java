package com.learnjavastreams;


@FunctionalInterface
public interface MyFunctionalInterface {
	public abstract int add(int num1,int num2);
	
	public static String strinfjoin(String s1,String s2) {
		return s1.concat(s2);
	}
	default  void printstring(String s1,String s2) {
		System.out.println("pring values s1 = "+s1 + "s2 = "+s2);
	}

}
