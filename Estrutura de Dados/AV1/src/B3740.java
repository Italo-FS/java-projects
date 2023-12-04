import java.util.Scanner;

public class B3740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStacks = Integer.parseInt(sc.nextLine());
        String uncyptedPhrase = sc.nextLine();

        Queue queue = new Queue();

        queue.encript(numberOfStacks, uncyptedPhrase);
        sc.close();
    }

    public static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }

    }

    public static class Stack {
        private Node top;
        Stack next;

        public Stack() {
            top = null;
        }

        public String pop() {
            if (top == null) {
                throw new RuntimeException("Pilha vazia.");
            }
            Node poppedNode = top;
            top = top.next;
            poppedNode.next = null;
            return poppedNode.value;
        }

        public void push(String value) {
            Node newNode = new Node(value);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
        }

        public String peek() {
            if (top == null)
                return null;
            return top.value;
        }

    }

    public static class Queue {
        private Stack initialStack;
        private Stack first;
        private Stack last;

        public Queue() {
            initialStack = null;
            first = null;
            last = null;
        }

        public void enqueue() {
            Stack newStack = new Stack();
            if (first == null) {
                first = newStack;
                last = newStack;
            } else {
                last.next = newStack;
                last = newStack;
            }
        }

        public Stack getFirstAndMove() {
            Stack auxStack = first;
            first = first.next;
            return auxStack;
        }

        public void addString(String value) {
            Stack auxStack = getFirstAndMove();
            auxStack.push(value);
        }

        public String getString() {
            return getFirstAndMove().pop();
        }

        public void encript(int lenght, String phrase) {
            for (int i = 0; i < lenght; i++) {
                this.enqueue();
            }

            circle();

            for (int i = 0; i < phrase.length(); i++) {
                addString(phrase.substring(i, i + 1));
            }

            print();
        }

        public void print() {
            Stack auxStack = initialStack;
            do {
                System.out.print(auxStack.pop());
                auxStack = auxStack.next;
            } while (auxStack.peek() != null);
            System.out.println();
        }

        public void circle() {
            initialStack = first;
            last.next = first;
        }
    }

}
