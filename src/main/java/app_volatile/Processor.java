package app_volatile;

public class Processor extends Thread {
	
	private volatile boolean running = true;
	@Override
	public void run() {
		
		while(running) {
			System.out.println("hi");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("The thread is terminated");
	}
	
	public void shutdown() {
		this.running=false;
	}

}
