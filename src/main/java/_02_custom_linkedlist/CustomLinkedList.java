package _02_custom_linkedlist;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> {

	Node<T> head;
	Node<T> tail;
	int index;

	static class Node<T> {

		private T data;
		private Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
		}

	}

	public boolean add(T element) {
		if (head == null) {
			addFirst(element);
			return true;
		}
		Node<T> newNode = new Node<>(element);
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		tail = temp.next;
		index++;
		return true;
	}

	public boolean remove(T element) {
		Node<T> temp = head;
		if (temp.next == null) {
			removeFirst();
			return true;
		}
		while (temp.next != null) {
			if (temp.next.data.equals(element)) {
				temp.next = temp.next.next;
				index--;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public T remove(int index) {
		rangeCheck(index);
		Node<T> temp = head;
		int count = 1;
		while (temp.next != null) {
			if (count == index) {
				T data = temp.next.data;
				temp.next = temp.next.next;
				this.index--;
				return data;
			}
			temp = temp.next;
			count++;
		}
		return removeLast();
	}

	public void addFirst(T element) {
		Node<T> newNode = new Node<>(element);
		if (head == null) {
			head = tail = newNode;
			index++;
			return;
		}
		newNode.next = head;
		head = newNode;
		index++;
	}

	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	public T removeFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		T data = head.data;
		head = head.next;
		index--;
		return data;
	}

	public void addLast(T element) {
		if (head == null) {
			addFirst(element);
			return;
		}
		Node<T> newNode = new Node<>(element);
		tail.next = newNode;
		tail = newNode;
		index++;
	}

	public T getLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	public T removeLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		Node<T> temp = head;
		while (temp.next != null) {
			if (temp.next.next == null) {
				T data = temp.data;
				temp.next = null;
				tail = temp;
				index--;
				return data;
			}
			temp = temp.next;
		}
		T data = temp.data;
		temp = null;
		head = tail = temp;
		index--;
		return data;
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

	private void rangeCheck(int index) {
		if (index >= size())
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	}

	public static void main(String[] args) {
	}

}
