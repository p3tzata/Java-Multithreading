package app_semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance=new Connection();
	private static int connections=0;
	private static Semaphore semaphore = new Semaphore(10,true);
	
	public Connection() {
	
	}
	
	
	public static Connection getInstance() {
		return instance;
	}
	
	
	public  void connect()  {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			
		}
		try {
		  doConnect();
		} finally {
			semaphore.release();
		}
			
	}
	
	
	public  void doConnect()  {
		
		
		synchronized (this) {
			
			connections++;
			System.out.println("Connections are: "+connections);
			
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			 
		}
		
		synchronized (this) {
			
			
			connections--;
			 
			
		}
		
		
		
	}
	

}
