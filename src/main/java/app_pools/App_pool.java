package app_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App_pool {
public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 15; i++) {
			executorService.submit(new Processor(i));
		}
		
		executorService.shutdown();
		
		System.out.println("All tasks are submitted.");
		
		executorService.awaitTermination(1, TimeUnit.HOURS);
		
		System.out.println("All tasks are completed");
		

	}
}
