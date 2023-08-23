import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < n; i++) {
      String input[] = sc.nextLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      if (b == 0) {
        System.out.println("divisao impossivel");
      } else {
        double resultado = (double) a / b;
        System.out.printf("%.1f%n", resultado);
      }
    }

    sc.close();
  }
}
