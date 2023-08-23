import java.util.Scanner;

public class Beecrowd_1044 {
	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    String[] valores = sc.nextLine().split(" ");
    int a = Integer.parseInt(valores[0]);
    int b = Integer.parseInt(valores[1]);

    if (a % b == 0 || b % a == 0) {
      System.out.println("Sao Multiplos");
    } else {
      System.out.println("Nao sao Multiplos");
    }

    sc.close();
  }
}
