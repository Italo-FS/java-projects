import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String[] cpf = sc.nextLine().replaceAll("[\\.\\-]", "").split("");

      int somaA = 0;
      int somaB = 0;

      for (int i = 1; i <= 9; i++) {
        somaA += Integer.parseInt(cpf[i - 1]) * i;
        somaB += Integer.parseInt(cpf[i - 1]) * (10 - i);
      }

      int d1 = somaA % 11;
      d1 = d1 == 10 ? 0 : d1;

      int d2 = somaB % 11;
      d2 = d2 == 10 ? 0 : d2;

      if (Integer.parseInt(cpf[9]) == d1 && Integer.parseInt(cpf[10]) == d2) {
        System.out.println("CPF valido");
      } else {
        System.out.println("CPF invalido");
      }
    }

    sc.close();
  }
}
