package javacore.CreationalDesignPattern;

// singleton class

class Singleton {
	// static variable to hold single instance of the class
	private static Singleton instance = new Singleton(); // Eager instantiation
	
	// Private constructor to prevent instantiation
	private Singleton() {
		System.out.println("Singleton instance created");
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			System.out.println("Creating first instance");
			instance = new Singleton();
		}
		
		System.out.println("Fetching instance");
		return instance;
	}
}
public class SingletonDesignPattern {

	public static void main(String[] args) {
		
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println("are both instance same: " + (singleton1 == singleton2));
	}
}
