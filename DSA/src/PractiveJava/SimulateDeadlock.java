package PractiveJava;

public class SimulateDeadlock implements Runnable {

	private Integer numberone = 0;
	private Integer numbertwo=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread T =new Thread(new SimulateDeadlock());
		
		Thread T1 =new Thread(new SimulateDeadlock());
		Thread T2 =new Thread(new SimulateDeadlock());
		T1.start();
		T.start();
		//T2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			incrementme();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void incrementme() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Thread name"+Thread.currentThread().getName());
		int sum =0;
		synchronized(this.numberone) {
			 sum = numberone+numbertwo;
			System.out.println(" i will sleeping -1"+"Thread name" +Thread.currentThread().getName());
			Thread.sleep(100000);
		}
		synchronized(this.numbertwo) {
			 sum = numberone+numbertwo;
			//Thread.sleep(100000);
			 System.out.println(" i will sleeping-2"+"Thread name" +Thread.currentThread().getName());
		}
		System.out.println(sum);
	}

}