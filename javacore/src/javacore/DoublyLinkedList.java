package javacore;

class Node {
	int data;
	Node next;
	Node back;
	
	Node(int data, Node next, Node back){
		this.data = data;
		this.back = back;
		this.next = next;
	}
	
	Node(int data){
		this.data = data;
		this.back = null;
		this.next = null;
	}
}


public class DoublyLinkedList {
	
	private static Node convertArr2DLL(int[] arr) {
		Node head = new Node(arr[0]);
		Node prev = head;
		for(int i = 1 ; i < arr.length; i++) {
			Node temp = new Node(arr[i], null, prev);
			prev.next = temp;
			prev = temp;
		}
		return head; // O(n)
	}
	
	public static void print(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static Node removeHead(Node head) {
		if(head == null || head.next == null) return null;
		
		Node prev = head;
		head =  head.next;
		
		head.back = null;
		prev = null;
		
		return head;
	}
	
	public static Node removeTail(Node head) {
		if(head == null || head.next == null) return null;
		Node tail = head;
		while(tail.next != null) {
			tail = tail.next;
		}
		Node newTail = tail.back;
		newTail.next = null;
		tail.back = null;
		return head;
	}
	
	private static Node removeAtK(Node head, int k) {
		
		return head;
	}

	
	public static void main(String[] args) {
		int[] arr = {12, 5, 8, 7};
		Node head = convertArr2DLL(arr);
		
		head = removeTail(head);
		print(head);
	}
}
