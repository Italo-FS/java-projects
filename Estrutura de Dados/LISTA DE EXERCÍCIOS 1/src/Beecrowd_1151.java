import java.util.Scanner;

public class Beecrowd_1151 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("%d", fibo(i));
			System.out.printf(i == n - 1 ? "%n" : " ");
		}
		sc.close();
	}

	public static int fibo(int n) {
		return n <= 1 ? n : fibo(n - 1) + fibo(n - 2);
	}
}
