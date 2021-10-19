package _06_custom_binarysearch;

public class CustomBinarySearch {

	static int[] a = new int[] { 10, 4, 7, 11, 17, 8, 21 };

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length - 1; j++) {
				int temp = 0;
				if (a[i] > a[j + 1]) {
					temp = a[j + 1];
					a[j + 1] = a[i];
					a[i] = temp;
				}
			}
		}
	}

	public static int search(int[] a, int firstIndex, int lastIndex, int elementToSearch) {
		int middleIndex = (firstIndex + lastIndex) / 2;
		if (elementToSearch == a[middleIndex]) {
			return middleIndex;
		} else if (elementToSearch > a[middleIndex]) {
			firstIndex = middleIndex + 1;
			if (firstIndex > lastIndex)
				return -1;
			return search(a, firstIndex, lastIndex, elementToSearch);
		} else if (elementToSearch < a[middleIndex]) {
			lastIndex = middleIndex - 1;
			if (lastIndex < firstIndex)
				return -1;
			return search(a, firstIndex, lastIndex, elementToSearch);
		}
		return -1;
	}

	public static void main(String[] args) {
		sort(a);
		int elementToSearch = 12;
		int firstIndex = 0;
		int lastIndex = a.length - 1;
		int index = search(a, firstIndex, lastIndex, elementToSearch);
		if (index != -1) {
			System.out.println("element " + elementToSearch + " is at index " + index);
		} else {
			System.out.println("element " + elementToSearch + " not found");
		}
	}
}
