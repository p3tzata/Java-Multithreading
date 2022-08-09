package app_synchronized;

import app_volatile.Processor;

public class App_sync {

	// This not work: private volatile int count=0;
	private int  count=0;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		App_sync app= new App_sync();
		app.doWork();
		
	}
	
	private synchronized void inc() {
		count++;
	}
	
	
	private void doWork() throws InterruptedException {
		
		Thread proc1 = new Thread(new Runnable() {
			
			public void run() {

				for (int i=0;i<1000;i++) {
					inc();
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("The thread  1 is finished");
			}
		});
		
		Thread proc2 = new Thread(new Runnable() {
			
			public void run() {

				for (int i=0;i<2000;i++) {
					inc();
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("The thread  2 is finished");
			}
			
		});
		
		proc1.start();
		proc2.start();
		
		proc1.join();
		System.out.println("---");
		proc2.join();		
		
		System.out.println("The count is: "+this.count);
		
		
	}
	
}
