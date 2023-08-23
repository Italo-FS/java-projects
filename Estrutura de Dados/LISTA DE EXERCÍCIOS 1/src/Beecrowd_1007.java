import java.util.Scanner;

public class Beecrowd_1007 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

		Integer a = Integer.parseInt(sc.nextLine());
		Integer b = Integer.parseInt(sc.nextLine());
		Integer c = Integer.parseInt(sc.nextLine());
		Integer d = Integer.parseInt(sc.nextLine());

		System.out.printf("DIFERENCA = %d%n", a * b - c * d);
		sc.close();
    }
}
