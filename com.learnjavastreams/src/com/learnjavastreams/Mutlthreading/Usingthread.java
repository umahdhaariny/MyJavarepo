package com.learnjavastreams.Mutlthreading;

public class Usingthread extends Thread{
	public  void run() {
		System.out.println(" i am testing test class");
	}
	public static void main(String args[]) {
		Usingthread thread = new Usingthread() ;
		thread.start();
		System.out.println("trying to use lambda expr");
		Thread thread1 = new Thread( ()->{
			hello();
		});
		
	}
	private static void hello() {
		// TODO Auto-generated method stub
		
	}
	

}
