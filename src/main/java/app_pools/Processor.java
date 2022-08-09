package app_pools;

public class Processor implements Runnable {
	private int id;
	
	
	public Processor(int id) {
		this.id = id;
	}


	public void run() {
		System.out.println("Start Processor ID:"+ this.id);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Finish Processor ID:"+this.id);
		
		
	}

}
