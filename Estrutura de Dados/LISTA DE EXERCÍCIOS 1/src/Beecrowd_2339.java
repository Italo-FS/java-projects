import java.util.Scanner;

public class Beecrowd_2339 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		int p = sc.nextInt();
		int f = sc.nextInt();

		System.out.println(p >= (c * f) ? "S" : "N");

		sc.close();
	}
}