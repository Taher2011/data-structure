package _05_custom_hasttable;

public class CustomHashTable<K, V> {

	private int DEFAULT_INITIAL_CAPACITY = 16;
	private final float DEFAULT_LOAD_FACTOR = 0.75f;
	private HashEntry[] data;
	private int size;

	public CustomHashTable() {
		data = new HashEntry[DEFAULT_INITIAL_CAPACITY];
	}

	static class HashEntry<K, V> {
		private K key;
		private V value;
		private HashEntry<K, V> next;

		public HashEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
			this.next = null;
		}

	}

	public V put(K key, V value) {
		// Get the index
		int index = getIndex(key);
		System.out.println("index for key " + key + " is " + index);
		// Create linkedlist entry
		HashEntry<K, V> entry = new HashEntry<>(key, value);
		// Check if entry already exist or not
		if (data[index] == null) {
			data[index] = entry;
			size++;
		} else {
			// HashCollison here so get all the entries object at index
			HashEntry<K, V> hashEntry = data[index];
			while (hashEntry.next != null) {
				if (hashEntry.key.equals(key)) {
					V oldValue = hashEntry.value;
					hashEntry.value = value;
					return oldValue;
				}
				hashEntry = hashEntry.next;
			}
			if (hashEntry.key.equals(key)) {
				V oldValue = hashEntry.value;
				hashEntry.value = value;
				return oldValue;
			}
			// Add new entry object
			hashEntry.next = entry;
			// size++;
		}
		return null;
	}

	public V get(K key) {
		// Get the index
		int index = getIndex(key);
		// Check if entry already exist or not
		if (data[index] != null) {
			// Get all the entries object at index
			HashEntry<K, V> hashEntry = data[index];
			while (hashEntry.next != null) {
				if (hashEntry.key.equals(key)) {
					V value = hashEntry.value;
					return value;
				}
				hashEntry = hashEntry.next;
			}
			V value = hashEntry.value;
			return value;
		}
		return null;
	}

	public int size() {
		return size;
	}

	public String toString() {
		System.out.print("{");
		if (size() == 0) {
			System.out.print("}");
			return "";
		}
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			HashEntry<K, V> hashEntry = data[i];
			if (hashEntry != null) {
				while (hashEntry.next != null) {
					System.out.print(hashEntry.key + "=" + hashEntry.value + ",");
					hashEntry = hashEntry.next;
				}
				if (count != 0) {
					System.out.print(",");
				}
				System.out.print(hashEntry.key + "=" + hashEntry.value);
				count++;
			}
		}
		System.out.print("}");
		return "";
	}

	private int getIndex(K key) {
		checkMapSize();
		// Get hashCode of key
		int hashCode = key.hashCode();
		// Convert to index
		int index = hashCode % DEFAULT_INITIAL_CAPACITY;
		// test for hashcollision
		if (key.equals("B") || key.equals("C") || key.equals("D")) {
			return 1;
		}
		return index;
	}

	private void checkMapSize() {
		if (size() == data.length) {
			resizeMap();
		}
	}

	private void resizeMap() {
		DEFAULT_INITIAL_CAPACITY = DEFAULT_INITIAL_CAPACITY + (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
		HashEntry[] newData = new HashEntry[DEFAULT_INITIAL_CAPACITY];
		copyArray(newData);
	}

	private void copyArray(HashEntry[] newData) {
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public static void main(String[] args) {
		CustomHashTable<String, String> cht = new CustomHashTable<>();
		cht.put("A", "123");
		cht.put("B", "123");
		cht.put("C", "123");
		cht.put("D", "123");
		cht.put("E", "123");
		cht.put("F", "123");
		cht.put("G", "123");
		cht.put("H", "123");
		cht.put("I", "123");
		cht.put("J", "123");
		cht.put("K", "123");
		cht.put("L", "123");
		cht.put("M", "123");
		cht.put("N", "123");
		cht.put("O", "123");
		cht.put("P", "123");
		cht.put("Q", "123");
		cht.put("R", "123");
		cht.put("S", "123");
		cht.put("T", "123");
		cht.put("U", "123");
		cht.put("V", "123");
		cht.put("V", "456");
		System.out.println("size is " + cht.size);
		System.out.println(cht);
	}

}
