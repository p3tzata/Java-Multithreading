package app_reEntrantLock;


public class App_reEntrantLock {

	public static void main(String[] args) throws InterruptedException {
		final Runner app = new Runner();
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
