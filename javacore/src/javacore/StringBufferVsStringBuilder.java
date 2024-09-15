package javacore;

public class StringBufferVsStringBuilder {
	public static void main(String[] args) {

//		StringBuffer objectStringbuffer = new StringBuffer(); // 16 + length of string
//		// all methods are sync -- Thread SAFE -- good for multithreading env -- support sync
//		objectStringbuffer.append(" Object");
//		objectStringbuffer.insert(0, "Buffer");
//		System.out.println(objectStringbuffer.toString());
//		System.out.println(objectStringbuffer.capacity());
//		
//		StringBuilder objectStringBuilder = new StringBuilder("Builder"); // Faster than Buffer
//		// Single thread env
//		objectStringBuilder.append(" Object");
//		System.out.println(objectStringBuilder.toString());
//		

		// Show StringBuffer is thread Safe

		StringBuffer objectStringBuilder = new StringBuffer();

		Thread T1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				objectStringBuilder.append("A");
			}
		});

		Thread T2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				objectStringBuilder.append("B");
			}
		});

		T1.start();
		T2.start();

		try {
			T1.join();
			T2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println(objectStringBuilder.toString().length());
	}
}
