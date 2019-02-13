package Lab2;

//***************************************************************
// LinkedStack.java
// Caleb Phillips
// Chapter 13, Lab 2
//
// A linked implementation of an Object stack class with operations push,
// pop, and isEmpty and isFull.
//***************************************************************

public class LinkedStack implements StackADT {

	private Node top; // reference to top of stack
	private int size;
	private final int MAX_SIZE = 100;

	// ---------------------------------------------------
	// Constructor -- initializes top
	// ---------------------------------------------------
	public LinkedStack() {
		top = null;
		size = 0;
	}

	// ---------------------------------------------------
	// Adds element to top of stack if it's not full, else
	// does nothing.
	// ---------------------------------------------------
	public void push(Object val) {

		Node newNode = new Node(val);
		newNode.setNext(top);

		if (top == null) {
			top = new Node(val);
		} else if (top != null) {
			top = newNode;
		}

		size++;
	}

	// ---------------------------------------------------
	// Removes and returns value at top of stack. If stack
	// is empty returns null.
	// ---------------------------------------------------
	public Object pop() {
		Node temp = new Node(top.getElement());

		if (top.getNext() != null) {
			top = top.getNext();
		} else {
			top.setElement(null);
		}

		if (top == null) {
			return null;
		}
		size--;
		return temp.getElement();
	}

	// ---------------------------------------------------
	// Returns true if stack is empty, false otherwise.
	// ---------------------------------------------------
	public boolean isEmpty() {
		return size == 0;
	}

	// ---------------------------------------------------
	// Returns true if stack is full, false otherwise.
	// ---------------------------------------------------
	public boolean isFull() {
		return size >= MAX_SIZE;
	}
}
