import java.util.Scanner;

public class Beecrowd_1073 {
	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());

    for (int i = 2; i <= n; i += 2) {
      System.out.printf("%d^2 = %.0f%n", i, Math.pow(i, 2));
    }

    sc.close();
  }
}
