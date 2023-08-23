import java.util.Scanner;

public class Beecrowd_1067 {
	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int number = Integer.parseInt(sc.nextLine());

    for (int i = 1; i <= number; i += 2) {
      System.out.println(i);
    }

    sc.close();
  }
}
