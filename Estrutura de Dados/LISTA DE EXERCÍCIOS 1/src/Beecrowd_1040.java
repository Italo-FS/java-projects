import java.util.Scanner;

public class Beecrowd_1040 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

		String notas[] = sc.nextLine().split(" ");

		double a = Double.parseDouble(notas[0]) * 2;
		double b = Double.parseDouble(notas[1]) * 3;
		double c = Double.parseDouble(notas[2]) * 4;
		double d = Double.parseDouble(notas[3]) * 1;

		double media = (a + b + c + d) / 10;

		System.out.printf("Media: %.1f%n", media);

		if (media >= 7) {
			System.out.println("Aluno aprovado.");
		} else if ( media >= 5) {
			System.out.println("Aluno em exame.");

			double e = Double.parseDouble(sc.nextLine()) * 1;

			System.out.printf("Nota do exame: %.1f%n", e);

			media = ( media + e ) / 2.0;

			if (media >= 5) {
				System.out.println("Aluno aprovado.");
			} else {
				System.out.println("Aluno reprovado.");
			}

			System.out.printf("Media final: %.1f%n", media);

		} else {
			System.out.println("Aluno reprovado.");
		}
		sc.close();
	}
}
