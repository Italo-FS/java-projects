import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		sc.nextLine();
		double salario = Double.parseDouble(sc.nextLine());
		double vendas = Double.parseDouble(sc.nextLine());

		System.out.printf("TOTAL = R$ %.2f%n", salario + vendas * 0.15);
	}
}