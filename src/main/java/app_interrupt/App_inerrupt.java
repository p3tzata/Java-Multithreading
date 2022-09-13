package app_interrupt;

public class App_inerrupt {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Starting.");
		
		Thread t = new Thread(new Runnable() {
			
			public void run() {
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
				
			}
		});
		
		t.start();
		
		Thread.sleep(300);
		
		t.interrupt();
		
		
		t.join();
		
		System.out.println("Finished.");

	}

}
