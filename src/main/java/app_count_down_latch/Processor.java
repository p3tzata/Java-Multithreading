package app_count_down_latch;

import java.util.concurrent.CountDownLatch;

public class Processor  implements Runnable{

	private CountDownLatch cLatch;
	
	
	public Processor(CountDownLatch cLatch) {
		this.cLatch = cLatch;
	}


	public void run() {
		
	System.out.println("Start Processor ID:");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		cLatch.countDown();
		
		System.out.println("Finish Processor ID:");
		
	}

	
	
}
