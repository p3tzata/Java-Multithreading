package app_callableFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App_callableFuture {

	public static void main(String[] args) throws InterruptedException {


		 ExecutorService exService = Executors.newFixedThreadPool(5);
		 
		
		 Future<Integer> future = exService.submit(new Callable<Integer>() {

			public Integer call() throws Exception {
				Random random = new Random();
				
				System.out.println("Thread is started...");
				int duration=random.nextInt(3000)+1000;
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					
				}
				
				
				System.out.println("Thread is finished...");
				
				if (true) {
					throw new Error("Simulate Error");
				}
				
				
				return duration;
			}
			
		
		 
		 });
		 
		 try {
			System.out.println("Result is:"+future.get());
		} catch (InterruptedException e) {
			
		} catch (ExecutionException e) {
			System.out.println(e);
		}
		 
		 
		 exService.shutdown();
		 exService.awaitTermination(1, TimeUnit.DAYS);
		 
		 
		 

	}

}
