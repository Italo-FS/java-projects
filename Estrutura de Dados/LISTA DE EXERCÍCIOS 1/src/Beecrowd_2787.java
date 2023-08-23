import java.util.Scanner;

public class Beecrowd_2787 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println((sc.nextInt() + sc.nextInt()) % 2 == 0 ? 1 : 0);
		sc.close();
	}
}