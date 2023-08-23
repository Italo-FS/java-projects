import java.util.Scanner;

public class Beecrowd_1041 {
	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    String[] coordenadas = sc.nextLine().split(" ");
    Double x = Double.parseDouble(coordenadas[0]);
    Double y = Double.parseDouble(coordenadas[1]);

    if (x == 0 && y == 0) {
      System.out.println("Origem");
    } else if (x != 0 && y == 0) {
      System.out.println("Eixo X");
    } else if (x == 0 && y != 0) {
      System.out.println("Eixo Y");
    } else if (x > 0 && y > 0) {
      System.out.println("Q1");
    } else if (x < 0 && y > 0) {
      System.out.println("Q2");
    } else if (x < 0 && y < 0) {
      System.out.println("Q3");
    } else if (x > 0 && y < 0) {
      System.out.println("Q4");
    }

    sc.close();
  }
}
