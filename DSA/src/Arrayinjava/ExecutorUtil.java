package Arrayinjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


class lib implements Runnable{
	AtomicInteger bookid = new AtomicInteger(0);
	String bookname;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookid.incrementAndGet();
		System.out.println("mybookid is"+ bookid);
		System.out.println("book name is"+ "bookname"+bookid);
	}
	
}

public class ExecutorUtil {
	int thread;
	String s;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			ExecutorService executors = Executors.newCachedThreadPool();
			ExecutorUtil obj1 = new ExecutorUtil();
			executors.execute(new lib());
			executors.execute(new lib());
			executors.execute(new lib());
			executors.shutdown();
			executors.awaitTermination(10, TimeUnit.SECONDS);//wait for other threads to complete
	}



}
