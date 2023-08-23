import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    String[] input = sc.nextLine().split(" ");

    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int c = Integer.parseInt(input[2]);
    int d = Integer.parseInt(input[3]);

    int start = a * 60 + b;
    int end = c * 60 + d;

    end = (start < end) ? end : end + 1440;

    int timePlayedInMinutes = end - start;

    int hoursPlayed = Math.floorDiv(timePlayedInMinutes, 60);
    int minutesPlayed = timePlayedInMinutes - hoursPlayed * 60;

    System.out.printf(
      "O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n",
      hoursPlayed,
      minutesPlayed
    );

    sc.close();
  }
}
