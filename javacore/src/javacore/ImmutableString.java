package javacore;

public class ImmutableString {
 public static void main(String[] args) {
	 
	 // Immutable String
	 String s1 = "hello";
	 // String Pool
	 String s2 = s1.concat(" world");
	 // Heap Memory
	 String s3 = s1.concat(" world").intern();
	 // String Pool
	 String s4 = new String("Hello World");
	 // Heap Memorys
 }
}