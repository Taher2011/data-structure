package _04_custom_queue;

public class CustomQueue<T> {

	private Node<T> head;
	private Node<T> tail;
	private int index;

	static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
		}

	}

	public boolean offer(T t) {
		Node<T> newNode = new Node<>(t);
		if (head == null) {
			head = tail = newNode;
			index++;
			return true;
		}
		tail.next = newNode;
		tail = newNode;
		index++;
		return true;
	}

	public T poll() {
		if (head == null) {
			return null;
		}
		T removedData = head.data;
		head = head.next;
		index--;
		return removedData;
	}

	public T peek() {
		if (head == null) {
			return null;
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
	}

}
