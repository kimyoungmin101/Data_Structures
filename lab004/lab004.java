import java.util.*;

/**
 * Generic version of the MyQueue class.
 * @param <T> the type of the value being queued
 */

class MyQueue <T> {
	private T[] queue;	// array for queue elements
	private int front, // one counterclockwise from front
	            rear, 	// array position of rear element
				capacity;	// capacity of queue array

	/**
	 * Create an empty queue whose initial capacity is cap
	 */
	@SuppressWarnings("unchecked")
	MyQueue(int cap) {
		capacity = cap;
		queue = (T []) new Object [capacity];
		front = rear = 0;
	}

	/** 
	 * If number of elements in the queue is 0, return true else return false
	 */
	boolean IsEmpty() {

// NEED TO IMPLEMENT


		return true;
	}

	/**
	 * Add x at rear of queue
	 */
	void Push (T x) throws Exception { 

// NEED TO IMPLEMENT

		// if queue full, throw the following message
		throw new Exception ("Queue is Full");

	}

	/**
	 * Delete front element from queue
	 */
	T Pop() throws Exception {
		// if queue is empty, throw the following message
			throw new Exception("Queue is empty. Cannot delete.");

// NEED TO IMPLEMENT

	}
	
	public String toString() {
		String a = new String();

		a = "MyQueue : ";

// NEED TO IMPLEMENT


		return a;
	}
}; 


