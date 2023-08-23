import java.util.Scanner;

public class Beecrowd_1080 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[100];

		int maior = -1;
		int posicao = -1;

		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			if (array[i] > maior) {
				maior = array[i];
				posicao = i;
			}
		}

		sc.close();

		System.out.println(maior);
		System.out.println(posicao + 1);
	}
}
