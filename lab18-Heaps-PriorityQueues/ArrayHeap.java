import java.util.ArrayList;

/** A Generic heap class. Unlike Java's priority queue, this heap doesn't just
  * store Comparable objects. Instead, it can store any type of object
  * (represented by type T) and an associated priority value.
  * @author CS 61BL Staff */
public class ArrayHeap<T> {

	/*
	ACTUALLY READ THESE METHODS! MAKE SURE YOU KNOW WHAT EACH ONE DOES.
	DO NOT CHANGE THESE METHODS. */

	/* An ArrayList that stores the nodes in this binary heap. */
	private ArrayList<Node> contents;

	/* A constructor that initializes an empty ArrayHeap. */
	public ArrayHeap() {
		contents = new ArrayList<>();
		contents.add(null);
	}

	/* Returns the node at index INDEX. */
	private Node getNode(int index) {
		if (index >= contents.size()) {
			return null;
		} else {
			return contents.get(index);
		}
	}

	private void setNode(int index, Node n) {
		// In the case that the ArrayList is not big enough
		// add null elements until it is the right size
		while (index + 1 >= contents.size()) {
			contents.add(null);
		}
		contents.set(index, n);
	}

	/* Swap the nodes at the two indices. */
	private void swap(int index1, int index2) {
		Node node1 = getNode(index1);
		Node node2 = getNode(index2);
		this.contents.set(index1, node2);
		this.contents.set(index2, node1);
	}

	/* Prints out the heap sideways. Use for debugging. */
	@Override
	public String toString() {
		return toStringHelper(1, "");
	}

	/* Recursive helper method for toString. */
	private String toStringHelper(int index, String soFar) {
		if (getNode(index) == null) {
			return "";
		} else {
			String toReturn = "";
			int rightChild = getRightOf(index);
			toReturn += toStringHelper(rightChild, "        " + soFar);
			if (getNode(rightChild) != null) {
				toReturn += soFar + "    /";
			}
			toReturn += "\n" + soFar + getNode(index) + "\n";
			int leftChild = getLeftOf(index);
			if (getNode(leftChild) != null) {
				toReturn += soFar + "    \\";
			}
			toReturn += toStringHelper(leftChild, "        " + soFar);
			return toReturn;
		}
	}

	/* A Node class that stores items and their associated priorities. */
	public class Node {
		private T item;
		private double priority;

		private Node(T item, double priority) {
			this.item = item;
			this.priority = priority;
		}

		public T item() {
			return this.item;
		}

		public double priority() {
			return this.priority;
		}

		@Override
		public String toString() {
			return this.item.toString() + ", " + this.priority;
		}
	}



	/* FILL IN THE METHODS BELOW. */

	/* Returns the index of the node to the left of the node at i. */
	private int getLeftOf(int i) {
		return 2 * i;
		//YOUR CODE HERE
	}

	/* Returns the index of the node to the right of the node at i. */
	private int getRightOf(int i) {
		return 2 * i + 1;
		//YOUR CODE HERE
	}

	/* Returns the index of the node that is the parent of the node at i. */
	private int getParentOf(int i) {
		return i / 2;
		//YOUR CODE HERE
	}

	/* Adds the given node as a left child of the node at the given index. */
	private void setLeft(int index, Node n) {
		setNode(2 * index, n);
		//YOUR CODE HERE
	}

	/* Adds the given node as the right child of the node at the given index. */
	private void setRight(int index, Node n) {
		setNode(2 * index + 1, n);

		//YOUR CODE HERE
	}

	/**
	 * Returns the index of the node with smaller priority. Precondition: not
	 * both nodes are null.
	 */
	private int min(int index1, int index2) {
		Node node1 = getNode(index1);
		Node node2 = getNode(index2);

		if (node1 != null) {
			if (node2 != null) {
				if (node1.priority < node2.priority) {
					return index1;
				} else {
					return index2;
				}
			}
			return index1;
		} else {
			return index2;
		}
	}


	//YOUR CODE HERE


	/* Returns the Node with the smallest priority value, but does not remove it
	 * from the heap. */
	public Node peek() {
		return getNode(1);
	}


	/* Bubbles up the node currently at the given index. */
	private void bubbleUp(int index) {
		/*if (index == 0) {
			throw new IllegalArgumentException ("nothing at index 0");
		}*/

		if (index == 1) {
			return; //swap yourself
		}
		while (index > 1 && getNode(index)!=null && getNode(getParentOf(index)) !=null && getNode(index).priority < getNode(getParentOf(index)).priority && index < contents.size()) {

				swap(index, getParentOf(index));
				index = getParentOf(index);

		}
	}

	/* Bubbles down the node currently at the given index. */
	private void bubbleDown(int index) {
		/*if (index == 0 ) {
			throw new NullPointerException("nothing to bubble down");
<<<<<<< HEAD
		}
		while (index < contents.size() && getNode(getLeftOf(index)) != null && getNode(getRightOf(index)) != null && getNode(index).priority >
=======
		}*/
		while (index < contents.size() && getNode(getLeftOf(index)) != null && getNode(index) != null
				&& getNode(min(getLeftOf(index), getRightOf(index))) != null && getNode(index).priority >
		getNode(min(getLeftOf(index), getRightOf(index))).priority) {
			int min = min(getLeftOf(index), getRightOf(index));
			if (getNode(index)!=null && getNode(min)!=null)
			swap(index, min);
			index = min;
		}
		if (getNode(getRightOf(index)) == null && getNode(getLeftOf(index)) != null && getNode(index).priority >
				getNode(getLeftOf(index)).priority) {
			swap(index, getLeftOf(index));
		}

	}

	/* Inserts an item with the given priority value. Same as enqueue, or offer. */
	public void insert(T item, double priority) {
		Node n = new Node(item, priority);
		contents.add(n);
		int pos = contents.size() - 1;
		bubbleUp(pos);


//		int parentPos = getParentOf(pos);

//		while (getNode(pos).priority < getNode(getParentOf(pos)).priority && getParentOf(pos) != 1) {
//			bubbleUp(pos);
//			pos = getParentOf(pos);
//		}
	}


	/* Returns the Node with the highest priority, a.k.a smallest value, and removes it from
  	 * the heap. Same as dequeue, or poll */
	public Node removeMin() {
		/*if (contents.size() == 1) {
			throw new NullPointerException("Nothing to remove at position 0");
		}*/

		Node minNode = getNode(1);
		int lastIndex = contents.size() - 1;
		if (getNode(1)!=null &&getNode(lastIndex)!=null)
		swap(1, lastIndex);
		contents.remove(lastIndex);
		bubbleDown(1);
		return minNode;

	}

	/* Changes the node in this heap with the given item to have the given
	 * priority. You can assume the heap will not have two nodes with the same
	 * item. Check for item equality with .equals(), not == */
	public void changePriority(T item, double priority) {
		for (int i = 1; i < contents.size(); i++) {
			if (getNode(i).item.equals(item)) {
				setNode(i, new Node(item, priority));
				bubbleDown(i);
				bubbleUp(i);
				return;
			}
		}
	}

//	public static void main(String[] args) {
//		ArrayHeap<String> a = new ArrayHeap<>();
//		System.out.print(a.contents.size());
//	}

}


