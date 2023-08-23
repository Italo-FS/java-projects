import java.util.Scanner;

public class Beecrowd_1397 {
	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      int rodadas = Integer.parseInt(sc.nextLine());

      if (rodadas == 0) break;

      int pa = 0;
      int pb = 0;

      for (int i = 0; i < rodadas; i++) {
        String[] input = sc.nextLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if (a > b) pa++;
        if (a < b) pb++;
      }

      System.out.printf("%d %d%n", pa, pb);
    }

	sc.close();
  }
}
