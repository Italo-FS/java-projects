import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      System.out.println(
        (sc.nextLine().equals("0")) ? "vai ter copa!" : "vai ter duas!"
      );
    }

    sc.close();
  }
}
