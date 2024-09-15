package javacore;

import java.util.ArrayList;
import java.util.List;

public class PlatformThreadExample {

	public static void main(String[] args) throws InterruptedException {
		final int numberOfThreads = 10_000;

		List<Thread> listOfThreads = new ArrayList<>();

		Runnable objRunnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Fetching data from API");
				try {
					Thread.sleep(10000); // simulate time taken for fetching data
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Data fetched from API");
			}
		};

		for (int i = 0; i < numberOfThreads; i++) {
			Thread thread = new Thread(objRunnable);
			thread.setDaemon(true);
			thread.setName("Thread " + i);
			thread.start();
			String str = String.format("Thread number %s", i);
			System.out.println(str);
			listOfThreads.add(thread);
		}

		for (Thread thr : listOfThreads) {
			thr.join();
			System.out.println(thr.getName() +  " Completed");
		}
	}
}
