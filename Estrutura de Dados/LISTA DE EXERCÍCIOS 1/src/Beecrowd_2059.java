import java.util.Scanner;

public class Beecrowd_2059 {
	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int p = sc.nextInt();
    int j1 = sc.nextInt();
    int j2 = sc.nextInt();
    int r = sc.nextInt();
    int a = sc.nextInt();

    int winner;

    if (r == 1) {
      winner = (a == 0) ? 1 : 2;
    } else if (a == 1) {
      winner = (r == 1) ? 2 : 1;
    } else {
      winner =
        ((p == 1 && (j1 + j2) % 2 == 0) || (p == 0 && (j1 + j2) % 2 != 0))
          ? 1
          : 2;
    }

    System.out.printf("Jogador %d ganha!%n", winner);

    sc.close();
  }
}
