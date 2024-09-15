package javacore;

class SharedResources{
	private boolean flag = false;

	public synchronized boolean isFlag() {
		return flag;
	}

	public synchronized void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

// Visibility problem -- can be solved by both volatile and synchronized keywords 
public class VolatileKeyword {

	public static void main(String[] args) {
		
		SharedResources sharedResource = new SharedResources();
		
		// Thread 1 
		new Thread(() -> {
			System.out.println("Thread 1 started");
			try {
				System.out.println("Thread 1 logic started");
				Thread.sleep(1000);
				sharedResource.setFlag(true);
				System.out.println("Flag set by thread 1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		// Thread 2
		new Thread(() -> {
			System.out.println("Thread 2 started");
			while(!sharedResource.isFlag()) {
				// will keep running until flag is true
			}
			System.out.println("Thread 2 logic completed");
		}).start();
	}
}
