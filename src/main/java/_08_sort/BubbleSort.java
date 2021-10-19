package _08_sort;

public class BubbleSort {

	static int[] a = new int[] { 4, 8, 1, 5, 2, 0, 7, 8 };

	public static void sort(int[] a) {
		int n = a.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = 0;
				if (a[i] > a[j + 1]) {
					temp = a[i];
					a[i] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void print(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) {
				System.out.print(a[i] + ",");
			} else {
				System.out.print(a[i] + "]");
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Before sorting ");
		print(a);
		System.out.println();
		sort(a);
		System.out.print("After sorting  ");
		print(a);
	}

}
