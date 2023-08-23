import java.util.Scanner;

public class Beecrowd_1011 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

		System.out.printf("VOLUME = %.3f%n", ((4.0/3.0) * 3.14159 * Math.pow(Double.parseDouble(sc.nextLine()), 3)));
		sc.close();
    }
}
