package app_count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App_countDownLatch {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		ExecutorService eService = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 10; i++) {
			eService.submit(new Processor(countDownLatch));
		}
		
		
		countDownLatch.await();
		System.out.println("Completed.");
		
		
	}

}
