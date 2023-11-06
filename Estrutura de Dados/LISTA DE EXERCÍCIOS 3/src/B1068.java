import java.util.Scanner;

public class B1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String expression = sc.nextLine();
            int open = 0;
            boolean wrong = false;

            for (int i = 0; i < expression.length(); i++) {
                char character = expression.charAt(i);
                if (character == ')') {
                    if (open == 0) {
                        wrong = true;
                        break;
                    }
                    open--;
                } else if (character == '(') {
                    open++;
                }
            }
            if (wrong || open > 0) {
                System.out.println("incorrect");
            } else {
                System.out.println("correct");
            }
        }

        sc.close();

    }
}
