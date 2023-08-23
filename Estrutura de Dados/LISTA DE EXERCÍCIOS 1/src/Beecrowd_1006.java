import java.util.Scanner;

public class Beecrowd_1006 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Double a = Double.parseDouble(sc.nextLine());
		Double b = Double.parseDouble(sc.nextLine());
		Double c = Double.parseDouble(sc.nextLine());
		
		System.out.printf("MEDIA = %.1f%n", (a * 2 + b * 3 + c * 5)/10);
		sc.close();
	}
}
