package app_interrupt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App_interupt_withPool {

	public static void main(String[] args) throws InterruptedException {
		 
		System.out.println("Starting.");
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Future<Void> future = executorService.submit(new Callable<Void>() {

			public Void call() throws Exception {
				
				int count =0;
				for (int i=0;i<1E7;i++) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Grace full interupted");
						break;
					}
					
					count++;
					Math.sinh(4D);
				}
				System.out.println(count);
				
				return null;
			}
		});
		
		executorService.shutdown();
		
		Thread.sleep(500);
		executorService.shutdownNow();
		//future.cancel(true);
		
		executorService.awaitTermination(1, TimeUnit.DAYS);
		
		
		System.out.println("Finished.");
		
		
		

	}

}
