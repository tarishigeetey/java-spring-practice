package javacore;

public class CreateThreadLocal {

	public static void main(String[] args) {
		ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();
		
		// simulate a user landing on webpage
		Long userId1  = 1234L;
		Long userId2 = 5678L;
		
		// Handle request in the new thread
		Thread requestThread  = new Thread(()->{
			System.out.println("Started Thread for " + userId1);
			userIdThreadLocal.set(userId1);
			//Process my logic
			//Db call
			System.out.println("Complete logic for " + userIdThreadLocal.get());
			// Good coding practice to remove threadLocal
			userIdThreadLocal.remove();
		     System.out.println("Removed " + userId1);
		});
		
		Thread requestThread2 = new Thread(() -> {
			System.out.println("Started Thread for " + userId2);
			userIdThreadLocal.set(userId2);
			System.out.println("Completed Logic for " + userIdThreadLocal.get());
			userIdThreadLocal.remove();
			System.out.println("Removed " + userIdThreadLocal.get());
		});
		
		requestThread.start();
		requestThread2.start();
		
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
		
		Thread objectThread3 = new Thread(() ->{
			inheritableThreadLocal.set("Instagram");
			userIdThreadLocal.set(123456L);
			
			Thread objectThread4 = new Thread(()->{
				System.out.println(inheritableThreadLocal.get());
				System.out.println(userIdThreadLocal.get());
			});
			objectThread4.start();
		});
		
		objectThread3.start();
	}
}
