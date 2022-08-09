package app_volatile;

public class App_volatile_caching {

	public static void main(String[] args) throws InterruptedException {
		
		Processor proc1 =new Processor();
		proc1.start();
		Thread.sleep(2000);
		proc1.shutdown();
		
	}

}
