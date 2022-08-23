package app_reEntrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	int count=0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public void increment() {
		
		for (int i = 0; i < 10000; i++) {
			this.count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		
		
		this.lock.lock();
		System.out.println("Waiting...");
		this.condition.await();
		System.out.println("Woken up");
		
		try {
			this.increment();
		} finally {
			this.lock.unlock();	
		}
		

	}
	
	@SuppressWarnings("resource")
	public void secondThread() throws InterruptedException{
		
		
		Thread.sleep(1000);
		
		
		this.lock.lock();
		
		System.out.println("Press enter");
		new Scanner(System.in).nextLine();
		System.out.println("Got enter pressed");
		this.condition.signal();
		System.out.println("When Am I started");
		
		try {
			
			
			this.increment();
		} finally {
			
			this.lock.unlock();
			
		}

	}
	
	public void finished() {
		
		System.out.println("The count is: "+this.count);

	}
	
}
