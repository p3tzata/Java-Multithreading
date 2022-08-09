package app_synchronized_block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker_NotGood {
	Random random = new Random();
	List<Integer> list1 = new ArrayList();
	List<Integer> list2 = new ArrayList();

	synchronized void stageA() {

		try {
			Thread.sleep(1);
			this.list1.add(this.random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	synchronized void stageB() {

		try {
			Thread.sleep(1);
			this.list2.add(this.random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void process() {
		for (int i = 0; i < 1000; i++) {
			this.stageA();
			this.stageB();
		}
	}

	void main() throws InterruptedException {

		long startTime = System.currentTimeMillis();

		Thread thread1 = new Thread(new Runnable() {

			public void run() {
				process();

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				process();

			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		long endTime = System.currentTimeMillis();

		System.out.println("Finished in:" + (endTime - startTime));
		System.out.println("List1 size:" + list1.size() + " List2 size:" + list2.size());

	}

}
