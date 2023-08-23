import java.util.Scanner;

public class Beecrowd_1004 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());

		System.out.printf("PROD = %d%n", a*b);
		sc.close();
	}
}
