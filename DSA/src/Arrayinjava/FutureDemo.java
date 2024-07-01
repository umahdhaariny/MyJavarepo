package Arrayinjava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureDemo {
	private int age;
	private String name;
	private int totalmarks ;
	
	public FutureDemo(int age,String name,int totalmarks) {
		this.age=age;
		this.name=name;
		this.totalmarks=totalmarks;
	}

	private static List<FutureDemo> findtopfivestudents(ArrayList<FutureDemo> studlist,int minage,int maxage) {
		// TODO Auto-generated method stub
		System.out.println("Thread name"+Thread.currentThread().getName());
		studlist.stream().filter(s->s.age >= minage).sorted(Comparator.comparingInt(s1->s1.totalmarks)).collect(Collectors.toList())
		.stream().forEach(System.out::println);
		return studlist.stream().filter(s->s.age >= minage).sorted(Comparator.comparingInt(s1->s1.totalmarks)).collect(Collectors.toList());
	}

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		
		ArrayList <FutureDemo> studlist = new ArrayList();
		
		int minage=10;
		int maxage=15;
		
		studlist.add(new FutureDemo(17,"stude1", 100));
		studlist.add(new FutureDemo(20,"stude1", 200));
		studlist.add(new FutureDemo(6,"stude1", 100));
		studlist.add(new FutureDemo(70,"stude1", 90));
		studlist.add(new FutureDemo(24,"stude1", 105));
		studlist.add(new FutureDemo(16,"stude1", 105));
		studlist.add(new FutureDemo(10,"stude1", 120));
		List<FutureDemo> topFivestud2=findtopfivestudents(studlist,minage,maxage);
		List<FutureDemo> topFivestud1=findtopfivestudents(studlist,5,10);
		//topFivestud2.stream().forEach(System.out::println);
	//creating arrayof future
		ArrayList<Future <List<FutureDemo>>> futurlist = new ArrayList();
		ExecutorService executors = Executors.newCachedThreadPool();
		futurlist.add(	 (Future<List<FutureDemo>>) executors.submit(()->{
			List<FutureDemo> topFivestud= findtopfivestudents(studlist,6,0);
			return topFivestud;
		 } ));
		futurlist.add(	 (Future<List<FutureDemo>>) executors.submit(()->{
			List<FutureDemo> topFivestud=findtopfivestudents(studlist,20,0);
			return topFivestud;
		 } ));
		for(Future<List<FutureDemo>> f: futurlist) {
			System.out.println(f.get());
		}
		
		executors.shutdown();
		
		 
	}

	@Override
	public String toString() {
		return "FutureDemo [age=" + age + ", name=" + name + ", totalmarks=" + totalmarks + "]";
	}

}
