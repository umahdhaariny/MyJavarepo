package com.learnjavastreams.Mutlthreading;

public class Helloworld {
	public static String result =""; 

	
	public static void hello() {
		System.out.println("hello function");
		result =result.concat("Hello");
		try {
			result.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("value of result"+result);
	}
	public static void main (String args[]) throws InterruptedException  {
		

		Thread T = new Thread(()->{		hello();		});
		Thread T2 = new Thread(()->world());
		T.start();
		T2.start();
		T.join();
		T2.join();
		System.out.println("printing" + result);
	}
	private static void world() {
		// TODO Auto-generated method stub
		System.out.println("world function");
		try {
			result.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result =result.concat("Hello");
	}

}
