import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {				
				Scanner scanner = new Scanner(System.in);				
				Double raio = Double.parseDouble(scanner.nextLine());
				System.out.printf("A=%.4f%n", 3.14159 * Math.pow(raio, 2));
    }
}
