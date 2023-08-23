import java.util.Scanner;

public class Beecrowd_2763 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split("[\\.\\-]");

		System.out.printf("%s%n%s%n%s%n%s%n", input[0], input[1], input[2], input[3]);

		sc.close();
	}
}
