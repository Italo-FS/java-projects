import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int a = Integer.parseInt(scanner.nextLine());
		int b = Integer.parseInt(scanner.nextLine());

		System.out.printf("PROD = %d%n", a*b);
	}
}