package javacore;

public class CreateThread extends Thread{

	public static void main(String[] args) {
		System.out.println("Main Thread Started");
		
		// not efficient way
		Thread objectThread1 = new Thread(() -> {
			System.out.println("Thread 1 is running");
		});
		objectThread1.start();
		
		Runnable objectRunnable = () -> {
			System.out.println("Thread 2 is running");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 2 Completed");
		};
		
		Thread 	objectThread2 = new Thread(objectRunnable, "runnable thread");
		objectThread2.setDaemon(true);
		objectThread2.start();
		
		System.out.println("Main Thread completed");
		
		// Run thread in background without impacting main thread - like monitoring resources, garbage collection, logging
		
	}
}
