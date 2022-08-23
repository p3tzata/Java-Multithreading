package app_pools;

public class Processor implements Runnable {
	private int id;
	private int waitMs;
	
	
	public Processor(int id,int waitMs) {
		this.id = id;
		this.waitMs=waitMs;
	}


	public void run() {
		System.out.println("Start Processor ID:"+ this.id);
		
		try {
			Thread.sleep(waitMs);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Finish Processor ID:"+this.id);
		
		
	}

}
