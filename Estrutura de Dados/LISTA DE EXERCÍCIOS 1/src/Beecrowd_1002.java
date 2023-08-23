import java.util.Scanner;

public class Beecrowd_1002 {
	public static void main(String[] args) throws Exception {				
				Scanner sc = new Scanner(System.in);				
				Double raio = Double.parseDouble(sc.nextLine());
				System.out.printf("A=%.4f%n", 3.14159 * Math.pow(raio, 2));
				sc.close();
    }
}
