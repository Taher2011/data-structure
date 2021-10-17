package _03_custom_stack;

import java.util.EmptyStackException;

public class CustomStack<T> {

	private Node<T> head;
	private int index;

	static class Node<T> {

		private T data;
		private Node<T> next;

		public Node(T t) {
			super();
			this.data = t;
		}

	}

	public T push(T t) {
		Node<T> newNode = new Node<>(t);
		if (head == null) {
			head = newNode;
			index++;
			return t;
		}
		newNode.next = head;
		head = newNode;
		index++;
		return t;
	}

	public T pop() {
		if (head == null) {
			throw new EmptyStackException();
		}
		T removedData = head.data;
		head = head.next;
		index--;
		return removedData;
	}

	public T peek() {
		if (head == null) {
			throw new EmptyStackException();
		}
		T dataAtHead = head.data;
		return dataAtHead;
	}

	public int size() {
		return index;
	}

	public String toString() {
		System.out.print("[");
		if (size() == 0) {
			System.out.print("]");
			return "";
		}
		Node<T> temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + ",");
			temp = temp.next;
		}
		System.out.print(temp.data + "]");
		return "";
	}

	public static void main(String[] args) {
		CustomStack<String> cs = new CustomStack<>();
		cs.push("A");
		cs.push("B");
		cs.push("C");
		cs.push("D");
		cs.push("E");
		System.out.println(cs);
		System.out.println("element popped : " + cs.pop());
		System.out.println("element popped : " + cs.pop());
		System.out.println("element popped : " + cs.pop());
		System.out.println("element popped : " + cs.pop());
		System.out.println("element popped : " + cs.pop());
		System.out.println(cs);
		cs.push("A");
		cs.push("B");
		cs.push("C");
		cs.push("D");
		cs.push("E");
		System.out.println(cs);
		System.out.println("element peeked : " + cs.peek());
	}

}
