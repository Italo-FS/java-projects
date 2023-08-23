import java.util.Scanner;

public class Beecrowd_1142 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = Integer.valueOf(sc.nextLine());
		int counter = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(counter);
				System.out.print(" ");
				counter++;
			}
			System.out.println("PUM");
			counter++;
		}

		sc.close();
	}
}
