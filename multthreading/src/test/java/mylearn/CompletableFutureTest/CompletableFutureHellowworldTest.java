package mylearn.CompletableFutureTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

import CompletableFutureLearning.CompletableFutureHelloworld;
import learnjava.service.HelloWorldService;

public class CompletableFutureHellowworldTest {
	HelloWorldService helloworldservice;
	CompletableFutureHelloworld cfhw = new CompletableFutureHelloworld(helloworldservice);
	
	@Test
	public void helloworld() {
		System.out.print("executing");
		CompletableFuture<String> cf=cfhw.helloworld();
		cf.thenAccept(s->{
			assertEquals("HELLO WORLD",s);
		}).join();
	}
	
	

}
