import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int t = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < t; i++) {
      String[] input = sc.nextLine().split(" ");

      int pa = Integer.parseInt(input[0]);
      int pb = Integer.parseInt(input[1]);

      double g1 = (double) Double.parseDouble(input[2]) / 100;
      double g2 = (double) Double.parseDouble(input[3]) / 100;

      int j;

      for (j = 1; j <= 100; j++) {
        pa += pa * g1;
        pb += pb * g2;

        if (pa > pb) {
          break;
        }
      }

      if (j > 100) {
        System.out.printf("Mais de 1 seculo.%n");
      } else {
        System.out.printf("%d anos.%n", j);
      }
    }

    sc.close();
  }
}
