import java.util.Scanner;

public class Beecrowd_1185 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] matriz = new double[12][12];
		double soma = 0;

		String operador = sc.nextLine();

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				matriz[i][j] = sc.nextDouble();
				if (j < 11 - i)
					soma += matriz[i][j];
			}
		}

		System.out.printf("%.1f%n", operador.equals("S") ? soma : (double) soma / 66);

		sc.close();
	}
}
