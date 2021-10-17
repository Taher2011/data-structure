package _01_custom_arraylist;

public class CustomArrayList<T> {

	private Object[] data;
	private int index;
	private int initialCapacity = 5;

	public CustomArrayList() {
		data = new Object[initialCapacity];
	}

	public boolean add(T obj) {
		checkArraySize();
		data[index] = obj;
		index++;
		return true;
	}

	public T get(int index) {
		rangeCheck(index);
		return (T) data[index];
	}

	public T set(int index, T obj) {
		rangeCheck(index);
		T oldValue = (T) data[index];
		data[index] = obj;
		return oldValue;
	}

	public boolean remove(T obj) {
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(obj)) {
				for (int j = i; j < size(); j++) {
					data[j] = data[j + 1];
				}
				index--;
				return true;
			}
		}
		return false;
	}

	public T remove(int index) {
		rangeCheck(index);
		for (int i = 0; i < size(); i++) {
			if (i == index) {
				T removedValue = (T) data[index];
				for (int j = i; j < size(); j++) {
					data[j] = data[j + 1];
				}
				this.index--;
				return removedValue;
			}
		}
		return null;
	}

	public void add(int index, T obj) {
		rangeCheck(index);
		for (int i = 0; i < size(); i++) {
			if (i == index) {
				checkArraySize();
				for (int j = size(); j > i; j--) {
					data[j] = data[j - 1];
				}
				data[index] = obj;
				this.index++;
				return;
			}
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(T obj) {
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return index;
	}

	public int indexOf(T obj) {
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(T obj) {
		for (int i = size() - 1; i >= 0; i--) {
			if (data[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		data = new Object[initialCapacity];
		index = 0;
	}

	public String toString() {
		System.out.print("[");
		if (size() == 0) {
			System.out.print("]");
			return "";
		}
		for (int i = 0; i < size(); i++) {
			if (i != size() - 1) {
				System.out.print(data[i] + ",");
				continue;
			}
			System.out.print(data[i] + "]");
		}
		return "";
	}

	private void checkArraySize() {
		if (size() == initialCapacity) {
			resizeArray();
			copyOldArrayToNewArray();
		}
	}

	private void resizeArray() {
		int newCapacity = (initialCapacity * 3) / 2 + 1;
		initialCapacity = newCapacity;
	}

	private void copyOldArrayToNewArray() {
		Object[] newData = new Object[initialCapacity];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	private void rangeCheck(int index) {
		if (index > size())
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	}

	public static void main(String[] args) {
		CustomArrayList<Integer> al = new CustomArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println(al);
		al.set(0, 0);
		System.out.println(al);
		System.out.println(al.remove(0));
		System.out.println(al);
		System.out.println(al.remove(new Integer(2)));
		System.out.println(al);
		System.out.println(al.contains(3));
		al.add(1, 35);
		System.out.println(al);
	}

}
