package PraticeLab;

// ***************************************************************
// FILE: IntList.java
//
// Purpose: Defines a class that represents a list of integers
//
// ***************************************************************
public class IntList {
	private IntNode front; // first node in list
	// -----------------------------------------
	// Constructor. Initially list is empty.
	// -----------------------------------------

	public IntList() {
		front = null;
	}

	// -----------------------------------------
	// Adds given integer to front of list.
	// -----------------------------------------
	public void addToFront(int val) {
		front = new IntNode(val, front);
	}

	// -----------------------------------------
	// Adds given integer to end of list.
	// -----------------------------------------
	public void addToEnd(int val) {
		IntNode newnode = new IntNode(val, null);
		// if list is empty, this will be the only node in it
		if (front == null)
			front = newnode;

		else {
			// make temp point to last thing in list
			IntNode temp = front;
			while (temp.next != null)
				temp = temp.next;
			// link new node into list
			temp.next = newnode;
		}
	}

	// -----------------------------------------
	// Removes the first node from the list.
	// If the list is empty, does nothing.
	// -----------------------------------------
	public void removeFirst() {
		if (front != null)
			front = front.next;
	}

	// ------------------------------------------------
	// Prints the list elements from first to last.
	// ------------------------------------------------
	public void print() {
		System.out.println("--------------------");
		System.out.print("List elements: ");
		IntNode temp = front;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("\n-----------------------\n");
	}

	// *************************************************************
	// An inner class that represents a node in the integer list.
	// The public variables are accessed by the IntList class.
	// *************************************************************
	private class IntNode {
		public int val; // value stored in node
		public IntNode next; // link to next node in list
		// ------------------------------------------------------------------
		// Constructor; sets up the node given a value and IntNode reference
		// ------------------------------------------------------------------

		public IntNode(int val, IntNode next) {
			this.val = val;
			this.next = next;
		}
	}
}