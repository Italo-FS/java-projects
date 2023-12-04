import java.util.Scanner;

public class B1030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTests = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= numberOfTests; i++) {
            DoubleChainedList dcl = new DoubleChainedList();

            int numberOfSoldiers = sc.nextInt();
            int killJump = sc.nextInt();
            sc.nextLine();

            for (int j = 1; j <= numberOfSoldiers; j++) {
                dcl.insert(j);
            }

            System.out.printf("Case %d: %d%n", i, dcl.killThemAll(killJump));
        }

        sc.close();

    }

    static class DoubleChainedList {
        private Node first;
        private Node last;
        private int size;

        public DoubleChainedList() {

        }

        public void insert(int value) {
            if (first == null)
                firstInsert(value);
            else
                lastInsert(value);
        }

        private void firstInsert(int value) {
            if (first != null)
                throw new RuntimeException("A lista deve estar vazia para relizar esta operação.");
            Node newNode = new Node(value);
            first = newNode;
            last = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
            size++;
        }

        private void lastInsert(int value) {
            if (first == null)
                firstInsert(value);
            Node newNode = new Node(value);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            last.next = first;
            first.prev = last;
            size++;

        }

        public void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public Node getNodeAtNStepsFrom(Node node, int steps) {
            Node auxNode = node;
            for (int i = 0; i < steps; i++) {
                auxNode = auxNode.next;
            }
            return auxNode;
        }

        public Node getNodeAt(int pos) {
            Node auxNode = first;
            for (int i = 0; i < pos; i++) {
                auxNode = auxNode.next;
            }
            return auxNode;
        }

        public int killThemAll(int step) {
            Node auxNode = getNodeAt(step - 1);

            while (size > 1) {
                removeNode(auxNode);
                auxNode = getNodeAtNStepsFrom(auxNode, step);
            }
            ;

            return auxNode.value;
        }

    }

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }
}
