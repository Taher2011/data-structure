package _01_custom_arraylist;

public class CustomArrayList {

	private Object[] data;
	private int index;
	private int initialCapacity = 5;

	public CustomArrayList() {
		data = new Object[initialCapacity];
	}

	public boolean add(Object obj) {
		checkArraySize();
		data[index] = obj;
		index++;
		return true;
	}

	public Object get(int index) {
		rangeCheck(index);
		return data[index];
	}

	public Object set(int index, Object obj) {
		rangeCheck(index);
		String oldValue = (String) data[index];
		data[index] = obj;
		return oldValue;
	}

	public boolean remove(Object obj) {
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

	public Object remove(int index) {
		rangeCheck(index);
		for (int i = 0; i < size(); i++) {
			if (i == index) {
				String removedValue = (String) data[index];
				for (int j = i; j < size(); j++) {
					data[j] = data[j + 1];
				}
				this.index--;
				return removedValue;
			}
		}
		return null;
	}

	public void add(int index, Object obj) {
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

	public boolean contains(Object obj) {
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

	public int indexOf(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(Object obj) {
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
	}

}
