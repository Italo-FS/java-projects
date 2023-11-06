import java.util.Scanner;

public class B1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = sc.nextInt();
            sc.nextLine();

            if (N == 0)
                break;

            Stack deck = new Stack();
            Queue discarded = new Queue();

            for (int i = 1; i <= N; i++) {
                deck.smash(i);
            }

            while (deck.getHeight() > 1) {
                int aux = deck.pop();
                discarded.enqueue(aux);
                deck.kick();
            }

            sb.append("Discarded cards:");
            sb.append(discarded.printQueue());
            sb.append("\n");
            sb.append("Remaining card: ");
            sb.append(deck.peek());
            sb.append("\n");
        }

        System.out.print(sb);
        sc.close();
    }

    public static class Stack {

        private Node top;
        private int height;
        private Node bottom;

        public Stack() {
            top = null;
            height = 0;
        }

        public void kick() {
            if (height <= 1) {
                return;
            }
            smash(pop());
        }

        public void printStack() {
            Node startNode = top;
            while (startNode != null) {
                System.out.println("[" + startNode.value + "]");
                startNode = startNode.next;
            }
            System.out.println("===");
        }

        public int pop() {
            if (top == null) {
                throw new RuntimeException("Pilha vazia.");
            }
            Node poppedNode = top;
            top = top.next;
            poppedNode.next = null;
            height--;
            return poppedNode.value;
        }

        public void smash(int valor) {
            Node newNode = new Node(valor);
            if (top == null) {
                top = newNode;
                bottom = newNode;
            } else {
                bottom.next = newNode;
                bottom = newNode;
            }
            height++;
        }

        public int peek() {
            return top.value;
        }

        public int getHeight() {
            return height;
        }
    }

    public static class Queue {

        private Node first;
        private Node last;
        private int length;

        public Queue() {
            first = null;
            last = null;
            length = 0;
        }

        public void enqueue(int valor) {
            Node newNode = new Node(valor);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            length++;
        }

        public void dequeue() {
            if (first == null) {
                throw new RuntimeException("Fila tá vazia!");
            }
            Node auxiliarNode = first;
            if (length == 1) {
                first = null;
                last = null;
            } else {
                first = auxiliarNode.next;
                auxiliarNode.next = null;
                length--;
            }
        }

        public String printQueue() {
            Node auxNode = first;
            StringBuilder sb = new StringBuilder();
            while (auxNode != null) {
                sb.append(" " + auxNode.value);
                if (auxNode.next != null) {
                    sb.append(",");
                }
                auxNode = auxNode.next;
            }
            return sb.toString();
        }
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}