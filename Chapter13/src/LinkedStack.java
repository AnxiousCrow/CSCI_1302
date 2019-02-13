package Lab2;

// ***************************************************************
// LinkedStack.java
//
// A linked implementation of an Object stack class with operations push,
// pop, and isEmpty and isFull.
// ***************************************************************

public class LinkedStack implements StackADT {

	// private Node list;
	private Node top; // reference to top of stack
	private static int size;

	// ---------------------------------------------------
	// Constructor -- initializes top
	// ---------------------------------------------------
	public LinkedStack() {
		top = new Node(null);
		size = 0;
	}

	// ---------------------------------------------------
	// Adds element to top of stack if it's not full, else
	// does nothing.
	// ---------------------------------------------------
	public void push(Object val) {

		Node newNode = new Node(val);
		newNode.setNext(top);

		top.setElement(newNode);


	}
		//Node newNode = new Node(val);

		// temp = top
		// newNode = top
		// top.setNext(temp)

		//	0	1	2	3
		// 	top .n
		//		temp


//		if (top != null) {
//
//			size++;
//
//			Node temp = new Node(top);
//
//			top.setElement(val);
//			top.setNext(temp);
//
//
//			System.out.println("test");
//
//		}
//	}

//		else if (top.getElement() == null) {
//			top.setElement(newNode);
//		}



	/*

	// ----------------------------------------------
	// Adds new element to front of list
	// ----------------------------------------------
	public void addToFront(int val) {

		IntNode newNode = new IntNode(val);
		newNode.next = list;

		if (list != null) {
			list.prev = newNode;
			front = newNode;
		}



		list = newNode;
		front = list;
	}

	*/

	// ---------------------------------------------------
	// Removes and returns value at top of stack. If stack
	// is empty returns null.
	// ---------------------------------------------------
	public Object pop() {

		if (top != null) {
			size--;
			if (top.getNext() != null) {
				Node temp = new Node(top);
				//temp.setElement(top);

				System.out.println("UUUUU");

				top = top.getNext();
				return temp;
			}
		}
//		if(top == null) {
//			System.out.println("null!!!");
//			return null;
//		}
		System.out.println("*null*");
		return null;
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
		return false;
	}
}
