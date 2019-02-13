package Lab1;

// ***************************************************************
// DoubleLinked.java
// Caleb Phillips
// Chapter 13, Lab 1
//
// A class using a doubly linked list to represent 
// a list of integers.
// ***************************************************************
public class DoubleLinked {

	private IntNode list;

	// ----------------------------------------------
	// Constructor -- initializes list
	// ----------------------------------------------
	public DoubleLinked() {
		list = null;
		// size = 0;
	}

//	public void test() {
//		addToFront(3);
//		addToFront(2);
//		addToFront(1);
//		System.out.println("");
//		print();
//	}

	// ----------------------------------------------
	// Prints the list elements
	// ----------------------------------------------
	public void print() {
		for (IntNode temp = list; temp != null; temp = temp.next)
			System.out.println(temp.val);
		System.out.println("");
	}

	// ----------------------------------------------
	// Adds new element to front of list
	// ----------------------------------------------
	public void addToFront(int val) {

		IntNode newNode = new IntNode(val);
		newNode.next = list;

		if (list != null) {
			list.prev = newNode;
		}

		list = newNode;
	}

	// ----------------------------------------------
	// Adds new element to end of list
	// ----------------------------------------------
	public void addToEnd(int val) {

		IntNode newNode = new IntNode(val);

		if (list == null) {
			list = newNode;
		} else {
			IntNode temp = list;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	// ----------------------------------------------
	// Removes the first element in the list
	// ----------------------------------------------
	public void removeFirst() {
		if (list != null) {
			list = list.next;
		}
	}

	// ----------------------------------------------
	// Removes the last element in the list
	// ----------------------------------------------
	public void removeLast() {
		if (list != null) {
			while (list.next != null) {
				list = list.next;
			}

			if (list.next == null && list.prev != null) {

				list = list.prev;
				list.next = null;

				while (list.prev != null) {
					list = list.prev;
				}

			} else if (list.next == null && list.prev == null) {
				list = null;
			}
		}
	}

	// ----------------------------------------------
	// Removes the an element in the list
	// ----------------------------------------------
	public void remove(int val) {
		if (list != null) {

			IntNode temp = list;

			while (temp.val != val) {
				System.out.println(temp.val);
				temp = temp.next;
			}

			if (temp.prev == null) {
				removeFirst();
			} else if (temp.next == null) {
				removeLast();
			} else {
				temp = temp.next;
				while (temp.prev != null) {
					temp = temp.prev;
				}
				
			}

		}
	}

	// ***************************************************************
	// An inner class that represents a list element.
	// ***************************************************************
	private class IntNode {
		public int val;
		public IntNode next;
		public IntNode prev;

		public IntNode(int val) {
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}
}