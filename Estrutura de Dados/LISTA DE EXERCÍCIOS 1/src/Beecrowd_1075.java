import java.util.Scanner;

public class Beecrowd_1075 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		sc.close();

		int soma = 2;

		do {
			System.out.println(soma);
			soma += n;
		} while (soma < 10000);
	}
}
