import java.util.Scanner;

public class Beecrowd_2424 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		System.out.println((x >= 0 && x <= 432) && (y >= 0 && y <= 468) ? "dentro" : "fora");

		sc.close();
	}
}
