package app_waitNotify;

import java.util.Scanner;

public class Processor {
	
	public void producer() throws InterruptedException {
		
		synchronized (this) {
			
				System.out.println("Producer running...");
				wait();
				System.out.println("Producer resumed.");
			
			
			
		}
		
	}
	
	public void consumer() throws InterruptedException {
		Thread.sleep(100);
		Scanner scanner = new Scanner(System.in);
		synchronized (this) {
			
				System.out.println("Press enter key...");
				scanner.nextLine();
				System.out.println("Enter key pressed.");
				notify();
				System.out.println("Notify Called. please wait 5 seconds");
				Thread.sleep(5000);
			
			
		}
		
	}

}
