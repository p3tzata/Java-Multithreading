package app_waitNotify;

import app_producerConsumer.App_producerConsumer;

public class App_waitNotify {

	public static void main(String[] args) {
		final Processor app = new Processor();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
				//while (true) {
					app.producer();
				//}
					
				} catch (InterruptedException e) {
				}
			}
		});
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
				//while (true) {
					app.consumer();
				//}
					
				} catch (InterruptedException e) {
				}
			}
		});
		
		thread2.start();

	}
	
	
	

}
