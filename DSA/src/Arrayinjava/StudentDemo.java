package Arrayinjava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//sutd
public class StudentDemo {
	
	private int age;
	private String name;
	private int totalmarks ;
	public StudentDemo(int age, String name, int totalmarks) {
		super();
		this.age = age;
		this.name = name;
		this.totalmarks = totalmarks;
	}
	
	
	@Override
	public String toString() {
		return "StudentDemo [age=" + age + ", name=" + name + ", totalmarks=" + totalmarks + "]";
	}


	public static void main(String args[]) {
		
		
		ArrayList <StudentDemo> studlist = new ArrayList();
		
		int minage=10;
		int maxage=15;
		
		studlist.add(new StudentDemo(17,"stude1", 100));
		studlist.add(new StudentDemo(20,"stude1", 200));
		studlist.add(new StudentDemo(6,"stude1", 100));
		studlist.add(new StudentDemo(70,"stude1", 90));
		studlist.add(new StudentDemo(24,"stude1", 105));
		studlist.add(new StudentDemo(16,"stude1", 105));
		studlist.add(new StudentDemo(10,"stude1", 120));
		List<StudentDemo> topFivestud2=findtopfivestudents(studlist,minage,maxage);
		List<StudentDemo> topFivestud1=findtopfivestudents(studlist,5,10);
		//topFivestud2.stream().forEach(System.out::println);
		completefuturedemo(studlist);
		System.out.println("future");
		Executorservicedemo(studlist);
		
	}


	private static void Executorservicedemo(ArrayList<StudentDemo> studlist) {
		
		// TODO Auto-generated method stub
		CompletableFuture future = new CompletableFuture();
		Executors.newCachedThreadPool().submit(()->{
			List<StudentDemo> topFivestud=findtopfivestudents(studlist,20,30);
			topFivestud.stream().forEach(System.out::println);
			future.complete(future);
		});
		
	}


	private static void completefuturedemo(ArrayList <StudentDemo> studlist) {
		// TODO Auto-generated method stub
		CompletableFuture future = CompletableFuture.supplyAsync(()->{
			List<StudentDemo> topFivestud=findtopfivestudents(studlist,15,30);
			topFivestud.stream().forEach(System.out::println);
			return topFivestud;
		});
	//1 cpu
			
		CompletableFuture future1 = CompletableFuture.supplyAsync(()->{
			List<StudentDemo> topFivestud=findtopfivestudents(studlist,6,10);
			topFivestud.stream().forEach(System.out::println);
			return topFivestud;
		});
	
		System.out.println("usage of allof usage");
		CompletableFuture.allOf(future,future1);
	}


	private static List<StudentDemo> findtopfivestudents(ArrayList<StudentDemo> studlist,int minage,int maxage) {
		// TODO Auto-generated method stub
		System.out.println("Thread name"+Thread.currentThread().getName());
		return studlist.stream().filter(s->s.age >= minage && s.age <=maxage).sorted(Comparator.comparingInt(s1->s1.totalmarks)).collect(Collectors.toList());
	}

}//10 - 20
//20-30
//30-40

//divide the list and map it thread
//url shortner design