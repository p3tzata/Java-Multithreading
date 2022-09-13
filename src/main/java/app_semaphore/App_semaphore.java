package app_semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App_semaphore {

	public static void main(String[] args) throws InterruptedException {

		
		
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {

			executorService.submit(new Runnable() {

				public void run() {

					
						Connection.getInstance().connect();
					
				}

			});
		}

		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.HOURS);
		
//		Semaphore semaphore = new Semaphore(5);
//		
//		semaphore.release();
//		semaphore.release();
//		semaphore.acquire();
//		
//		System.out.println("Available permits: "+semaphore.availablePermits());
	}

}
