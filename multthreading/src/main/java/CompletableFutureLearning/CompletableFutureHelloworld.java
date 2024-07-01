package CompletableFutureLearning;

import java.util.concurrent.CompletableFuture;

import learnjava.service.HelloWorldService;
import learnjava.util.CommonUtil;
import learnjava.util.LoggerUtil;

public class CompletableFutureHelloworld {
	private HelloWorldService helloworldservice;
	

	public CompletableFutureHelloworld( HelloWorldService hws) {
		super();
		helloworldservice= hws;
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		
		//main thread is release when below line executed ,so we see done in the console.
		//all getting executed at forkjoinpool
		HelloWorldService helloworldservice= new HelloWorldService();
		CompletableFuture.supplyAsync(()->helloworldservice.helloWorld()).
		thenApply(result->result.toUpperCase()).thenAccept((result)->{
			LoggerUtil.log("result is " + result);
		});
		LoggerUtil.log("done");
		//before we add the delay we did not see the o/p because they ran i a diff thread pool
		CommonUtil.delay(2000);
	}
	public CompletableFuture<String> helloworld(){
		return CompletableFuture.supplyAsync(()->helloworldservice.helloWorld()).
		thenApply(result->result.toUpperCase()		);
	}
	
	
}
