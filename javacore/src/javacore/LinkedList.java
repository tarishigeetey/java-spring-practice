package javacore;

class Node1 {
	
	int data;
	Node1 next;
	
	Node1(int data, Node1 next){
		this.data = data;
		this.next = next; // index
	}
	
	Node1(int data){
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	private static Node1 convertArr2LL(int[] arr) {
		Node1 head = new Node1(arr[0]);
		Node1 mover = head;
		for(int i = 1 ; i < arr.length; i++) {
			Node1 temp = new Node1(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head; // O(n)
	}
	private static int lengthOfLL(Node1 head) { // O(N) for length and traversal
		int len = 0;
		Node1 temp = head;
		while(temp != null) {
			temp = temp.next;
			len++;
		}

		return len;
	}
	
	private static int checkIfPresent(Node1 head, int val) {
		Node1 temp = head;
		while(temp != null) {
			if(temp.data == val) {
				return 1;
			}
			temp = temp.next;
		}
		return 0;
	}
	
	public static Node1 removeHead(Node1 head) {
		if(head == null) return head;
		head = head.next;
		return head;
	}
	
	public static Node1 insertHead(Node1 head, int val) {
		Node1 temp = new Node1(val, head);
		return temp;
	}

	
	public static Node1 removeTail(Node1 head) {
		if(head == null || head.next == null) return head;
		Node1 temp = head;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	
	public static Node1 insertTail(Node1 head, int val) {
		if(head == null) return new Node1(val);
		Node1 temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		Node1 nw = new Node1(val, null);
		temp.next = nw;
		return head;
	}

	
	public static Node1 removeAtIndex(Node1 head, int k) {
		if(head == null) return head;
		if(k==1) return head.next;
		Node1 temp = head;
		int cnt = 0;
		Node1 prev = null;
		while(temp!= null) {
			cnt++;
			if(cnt == k) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}
	
	public static Node1 insertAtIndex(Node1 head, int k, int val) {
		if(head == null) return new Node1(val);
		if(k==1) return new Node1(val, head);
		Node1 temp = head;
		int cnt = 0;
		while(temp!= null) {
			cnt++;
			if(cnt == k-1) {
			 temp.next = new Node1(val, temp.next);
			 break;
			}
			temp = temp.next;
		}
		return head;
	}

	
	public static Node1 removeByVal(Node1 head, int val) {
		if(head == null) return head;
		if(head.data == val) return head.next;
		Node1 temp = head;
		Node1 prev = null;
		while(temp!= null) {
			if(temp.data == val) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}
	
	public static Node1 insertBeforeVal(Node1 head, int k, int val) {
		if(head == null) return null;
		if(head.data == val) return new Node1(val, head);
		Node1 temp = head;
		while(temp!= null) {
			if(temp.next.data == k) {
				temp.next = new Node1(val, temp.next);
				 break;
			}
			temp = temp.next;
		}
		return head;
	}

	public static void print(Node1 head) {
		Node1 temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,5,8,7};
		Node1 head = convertArr2LL(arr);
		//System.out.println(head.data);
		
		// System.out.println(lengthOfLL(head));
		
		// System.out.println(checkIfPresent(head, 4));
		
		// head = removeHead(head);
		// head = removeTail(head);
		head = insertBeforeVal(head, 5, 9);
		print(head);
	}
}
