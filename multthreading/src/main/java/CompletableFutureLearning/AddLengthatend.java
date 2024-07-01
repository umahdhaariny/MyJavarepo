package CompletableFutureLearning;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AddLengthatend {
	private ArrayList<String> strlist;
	
	public AddLengthatend() {
		strlist =new ArrayList();
		strlist.add("hello world");
		strlist.add("string");
	}
	public static void main(String args[]) {
		AddLengthatend srr = new AddLengthatend();
		srr.addlengthandtransform();
	}
	private void addlengthandtransform() {
		// TODO Auto-generated method stub
		CompletableFuture.supplyAsync(()->{
			return strlist.stream().map(s->s+s.length()).collect(Collectors.toList());
		}).thenAccept(s->s.stream().forEach(System.out::println)).join();//without join it will print .joint will block and print
	}
}
