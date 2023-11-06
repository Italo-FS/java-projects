import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class B1077 {
    private static Map<Character, Integer> precedenceMap = new HashMap<>();

    static {
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('^', 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String infixExpression = sc.nextLine();
            String postfixExpression = convertToPostfix(infixExpression);
            sb.append(postfixExpression);
            sb.append("\n");
        }
        sc.close();
        System.out.print(sb);
    }

    private static String convertToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Removendo o '(' do topo da pilha
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        return precedenceMap.getOrDefault(operator, -1);
    }
}