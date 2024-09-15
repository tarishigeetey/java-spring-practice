package javacore;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {

	private AtomicInteger count = new AtomicInteger();

	public int getCount() {
		return count.get();
	}

	public void increment() {
		count.incrementAndGet();
	}

}

public class RaceCondition {

	public static void main(String[] args) {

		SharedCounter sharedCounter = new SharedCounter();

		// Thread 1
		new Thread(() -> {
			System.out.println("Thread 1 started");
			for (int i = 0; i < 50000; i++) {
				sharedCounter.increment();
			}
			System.out.println("Thread 1 completed");
		}).start();

		// Thread 2
		new Thread(() -> {
			System.out.println("Thread 2 started");
			for (int i = 0; i < 50000; i++) {
				sharedCounter.increment();
			}
			System.out.println("Thread 2 completed");
			System.out.println("Final count : " + sharedCounter.getCount());
		}).start();
		
	}
}
