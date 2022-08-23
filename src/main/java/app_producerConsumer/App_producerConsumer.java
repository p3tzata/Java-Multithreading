package app_producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App_producerConsumer {

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	Random random = new Random();
	public static void main(String[] args) {
		
		final App_producerConsumer app = new App_producerConsumer();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					app.producer();
				} catch (InterruptedException e) {
				}
			}
		});
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
					app.consumer();;
				} catch (InterruptedException e) {
				}
			}
		});
		
		thread2.start();

	}
	
	private void producer() throws InterruptedException {
		
		
		while(true) {
			
			queue.put(random.nextInt(1000));
		}
		
		
	}
	
	private void consumer() throws InterruptedException {
		while (true) {
			Thread.sleep(100);
			if (this.random.nextInt(10)==0) {
				Integer taken = this.queue.take();
				System.out.println("Taken value: "+taken + ", queue size is: "+this.queue.size());
			}
		}
	}
	

}
