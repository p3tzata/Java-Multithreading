package app_deadlock;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner_avoidDeadLock {
	private Account acc1=new Account();
	private Account acc2=new Account();
	private Random random=new Random();
	private ReentrantLock lock1= new ReentrantLock();
	private ReentrantLock lock2= new ReentrantLock();
	
	private void acquireLocks(Lock lock1, Lock lock2) throws InterruptedException {
		
		Boolean gotFirstLock=false;
		Boolean gotSecondLock=false;
		while (true) {
			//Acquire lock
			try {
			gotFirstLock=lock1.tryLock();
			gotSecondLock=lock2.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					return;
				}
				
				if (gotFirstLock) {
					lock1.unlock();
				}
				
				if (gotSecondLock) {
					lock2.unlock();
				}
				
			}
			
			//Not acquired lock;
			Thread.sleep(1);
			
		}
		
	}
	
	
	public void firstThread() throws InterruptedException {
		
		for (int i = 0; i < 10000; i++) {
			try {
				acquireLocks(lock1,lock2);
			Account.transffer(acc1, acc2, this.random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}	
			
		}
		
	}
	

	public void secondThread() throws InterruptedException{
		
		for (int i = 0; i < 10000; i++) {

			try {
				acquireLocks(lock2,lock1);
				
			Account.transffer(acc2, acc1, this.random.nextInt(100));
			} finally {
				lock2.unlock();
				lock1.unlock();
			}
						
		}
	
	}
	
	public void finished() {
		
		System.out.println("Account 1 balance:"+acc1.getBalance());
		System.out.println("Account 2 balance:"+acc2.getBalance());
		System.out.println("Total balance:"+( acc1.getBalance() + acc2.getBalance()) );
	}
	
}
