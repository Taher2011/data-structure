package _07_fibonacciseries;

public class FibonacciSeries {

	public static void fibonacci(int limit) {
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		System.out.print(n1 + "," + n2);
		for (int i = 0; i < limit; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print("," + n3);
		}
	}

	public static void main(String[] args) {
		fibonacci(1);
	}

}
