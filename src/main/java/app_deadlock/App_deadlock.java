package app_deadlock;


public class App_deadlock {
	public static void main(String[] args) throws InterruptedException {
		//final Runner_simulateDeadLock app = new Runner_simulateDeadLock();
		final Runner_avoidDeadLock app = new Runner_avoidDeadLock();
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				try {
				//while (true) {
					app.firstThread();
				//}
					
				} catch (InterruptedException e) {
				}
			}
		});
		
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
				//while (true) {
					app.secondThread();
				//}
					
				} catch (InterruptedException e) {
				}
			}
		});
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		app.finished();

	}

}
