
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
		for(int i = 0; i < queue.length; i++) {
			if(queue[i] != null) {
				return false;
			}
			}
		return true;
// NEED TO IMPLEMENT
	}

	/**
	 * Add x at rear of queue
	 */
	void Push (T x) throws Exception { 
		if((rear + 1) % capacity == front) { // rear가끝에있을경우 꽉찼다는걸 알림
			throw new Exception ("Queue is Full");
		}
		rear = (rear + 1) % capacity;
        queue[rear] = x;
// NEED TO IMPLEMENT
		// if queue full, throw the following message

	}

	/**
	 * Delete front element from queue
	 */
	T Pop() throws Exception {		
		if(IsEmpty() == true) {
			throw new Exception("Queue is empty. Cannot delete.");
		}
		else {
			front = (front + 1) % capacity;
			queue[front] = null;
		}
		// if queue is empty, throw the following message 
// NEED TO IMPLEMENT
		return null;
	}
	
	public String toString() {
		String a = new String();
		a = "MyQueue : ";
		int i = front+1;

		while(true) {
			if(i == queue.length) {
				i %= queue.length;
			}
			if(queue[i] == null) {
				break;
			}
			if(queue[i] != null) {
				a = a + queue[i] + " ";
			}
			i++;
		}
		a = a + "\r" + "rear=" + rear + ", " + "front=" + front;
// NEED TO IMPLEMENT
		return a;
	}
}; 


