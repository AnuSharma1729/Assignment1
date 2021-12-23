import java.io.*;

// Java program to implement
// a Singly Linked List
public class LinkedList {

	Node head; 
	static class Node {

		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	public static LinkedList insert(LinkedList list,
									int data)
	{
		
		Node new_node = new Node(data);
		new_node.next = null;

	
		if (list.head == null) {
			list.head = new_node;
		}
		else {
		
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			
			last.next = new_node;
		}

		
		return list;
	}

	
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;

		System.out.print("\nLinkedList: ");

		
		while (currNode != null) {
			
			System.out.print(currNode.data + " ");

			
			currNode = currNode.next;
		}
		System.out.println("\n");
	}


	public static LinkedList deleteByKey(LinkedList list,
										int key)
	{
		
		Node currNode = list.head, prev = null;

		

		if (currNode != null && currNode.data == key) {
			list.head = currNode.next; 

			
			System.out.println(key + " found and deleted");

			
			return list;
		}

		while (currNode != null && currNode.data != key) {
		
			prev = currNode;
			currNode = currNode.next;
		}

	
		if (currNode != null) {
		
			prev.next = currNode.next;

			
			System.out.println(key + " found and deleted");
		}


		if (currNode == null) {
		
			System.out.println(key + " not found");
		}

		
		return list;
	}


	public static LinkedList
	deleteAtPosition(LinkedList list, int index)
	{
	
		Node currNode = list.head, prev = null;

	

		if (index == 0 && currNode != null) {
			list.head = currNode.next; // Changed head

			
			System.out.println(
				index + " position element deleted");

			
			return list;
		}

		int counter = 0;

		while (currNode != null) {

			if (counter == index) {
			
				prev.next = currNode.next;

				// Display the message
				System.out.println(
					index + " position element deleted");
				break;
			}
			else {
			
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		if (currNode == null) {
			// Display the message
			System.out.println(
				index + " position element not found");
		}
		// return the List
		return list;
	}
}

import static java.lang.System.exit;

// Create Stack Using Linked list
class StackUsingLinkedlist {

	// A linked list node
	private class Node {

		int data; // integer data
		Node link; // reference variable Node type
	}
	// create global top reference variable global
	Node top;
	// Constructor
	StackUsingLinkedlist()
	{
		this.top = null;
	}

	// Utility function to add an element x in the stack
	public void push(int x) // insert at the beginning
	{
		// create new node temp and allocate memory
		Node temp = new Node();

		// check if stack (heap) is full. Then inserting an
		// element would lead to stack overflow
		if (temp == null) {
			System.out.print("\nHeap Overflow");
			return;
		}

		// initialize data into temp data field
		temp.data = x;

		// put top reference into temp link
		temp.link = top;

		// update top reference
		top = temp;
	}

	// Utility function to check if the stack is empty or not
	public boolean isEmpty()
	{
		return top == null;
	}

	// Utility function to return top element in a stack
	public int peek()
	{
		// check for empty stack
		if (!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	// Utility function to pop top element from the stack
	public void pop() // remove at the beginning
	{
		// check for stack underflow
		if (top == null) {
			System.out.print("\nStack Underflow");
			return;
		}

		// update the top pointer to point to the next node
		top = (top).link;
	}

	public void display()
	{
		// check for stack underflow
		if (top == null) {
			System.out.printf("\nStack Underflow");
			exit(1);
		}
		else {
			Node temp = top;
			while (temp != null) {

				// print node data
				System.out.printf("%d->", temp.data);

				// assign temp link to temp
				temp = temp.link;
			}
		}
	}
}
// main class
public class GFG {
	public static void main(String[] args)
	{
		// create Object of Implementing class
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		// insert Stack value
		obj.push(11);
		obj.push(22);
		obj.push(33);
		obj.push(44);

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n", obj.peek());

		// Delete top element of Stack
		obj.pop();
		obj.pop();

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n", obj.peek());
	}
}
// Java program for linked-list implementation of queue

// A linked list (LL) node to store a queue entry
class QNode {
	int key;
	QNode next;

	// constructor to create a new linked list node
	public QNode(int key)
	{
		this.key = key;
		this.next = null;
	}
}

// A class to represent a queue
// The queue, front stores the front node of LL and rear stores the
// last node of LL
class Queue {
	QNode front, rear;

	public Queue()
	{
		this.front = this.rear = null;
	}

	// Method to add an key to the queue.
	void enqueue(int key)
	{

		// Create a new LL node
		QNode temp = new QNode(key);

		// If queue is empty, then new node is front and rear both
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}

		// Add the new node at the end of queue and change rear
		this.rear.next = temp;
		this.rear = temp;
	}

	// Method to remove an key from queue.
	void dequeue()
	{
		// If queue is empty, return NULL.
		if (this.front == null)
			return;

		// Store previous front and move front one node ahead
		QNode temp = this.front;
		this.front = this.front.next;

		// If front becomes NULL, then change rear also as NULL
		if (this.front == null)
			this.rear = null;
	}
}

// Driver class
public class Test {
	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.key);
		System.out.println("Queue Rear : " + q.rear.key);
	}
}

