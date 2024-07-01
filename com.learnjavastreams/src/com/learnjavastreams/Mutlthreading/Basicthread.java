package com.learnjavastreams.Mutlthreading;

class Mythread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("testing my thread ");
		
	}
	
}
public class Basicthread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Mythread mythread = new Mythread();
		
		Thread t = new Thread(mythread);
		t.start();
	}

}

