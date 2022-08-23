package app_lowLevelSync;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Processor {
	LinkedList<Integer> list = new LinkedList<Integer>();
	Integer LIMIT=10;
	Object lock=new Object();
	
	public void producer() throws InterruptedException {
		int value=0;
		while(true) {
			synchronized (lock) {
				while (this.list.size()==this.LIMIT) {
					lock.wait();
				}
				
				this.list.add(value++);
				lock.notify();
			}
			
		}
		
	}
	
	public void consumer() throws InterruptedException {
		Random random = new Random();
		
		while (true) {
			synchronized (lock) {
				
				while (this.list.size()==0) {
					lock.wait();
				}
				
				
				System.out.print("The size of list: "+ this.list.size());
				Integer value = this.list.removeFirst();
				System.out.println("; The value is: "+value);
				lock.notify();
			}
			
			Thread.sleep(random.nextInt(3000));
			
		}
		
		
		
	}

}
