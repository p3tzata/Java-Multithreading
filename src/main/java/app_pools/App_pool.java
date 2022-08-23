package app_pools;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App_pool {
public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		int waitMs=random.nextInt(1000)+1000;
		for (int i = 0; i < 15; i++) {
			executorService.submit(new Processor(i,2000));
		}
		
		executorService.shutdown();
		
		System.out.println("All tasks are submitted.");
		
		executorService.awaitTermination(1, TimeUnit.HOURS);
		
		System.out.println("All tasks are completed");
		

	}
}
