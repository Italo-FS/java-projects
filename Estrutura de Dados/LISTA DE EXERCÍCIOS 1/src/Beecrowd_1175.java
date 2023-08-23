import java.util.Scanner;

public class Beecrowd_1175 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] n = new int[20];

		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextInt();
		}

		int aux;

		for (int i = 0; i < n.length / 2; i++) {
			aux = n[n.length - i - 1];
			n[n.length - i - 1] = n[i];
			n[i] = aux;
		}

		for (int i = 0; i < n.length; i++) {
			System.out.printf("N[%d] = %d%n", i, n[i]);
		}

		sc.close();
	}
}
