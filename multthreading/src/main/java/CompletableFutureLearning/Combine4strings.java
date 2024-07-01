package CompletableFutureLearning;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Combine4strings {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		Combine4strings combine = new Combine4strings();
		combine.combineusage();
	}

	private void combineusage() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
	CompletableFuture<String> Hello=	CompletableFuture.supplyAsync(()->"hello");
	CompletableFuture<String> world=	CompletableFuture.supplyAsync(()->"world");
	CompletableFuture<String> welcome=	CompletableFuture.supplyAsync(()->"welcome");
	CompletableFuture<String> completable = CompletableFuture.supplyAsync(()->"sucess");
		CompletableFuture<String> h1=Hello.thenCombine(world,(h,w)->h+w).thenCombine(welcome,(prev,curr)->prev+curr).
				thenCombine(completable, (prev,curr)->prev+curr).
				thenApply(str->str.toUpperCase());
		
		System.out.println(h1.get());
	}
	

}
