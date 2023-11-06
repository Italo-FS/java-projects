
import java.util.Scanner;

public class B2460 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Tree tree = new Tree();

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            queue.insertAtEnd(node);
            tree.push(node);
        }
        sc.nextLine();

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            int valorParaRemover = sc.nextInt();
            tree.removeValue(valorParaRemover);
        }

        sb.append(queue.printQueue());
        System.out.println(sb);

        sc.close();
    }

    public static class Tree {
        Node root;
        int size;

        protected void insertFirstNode(Node node) {
            if (root != null)
                throw new RuntimeException("A lista deve estar vazia para executar 'insertFirstNode()'.");
            root = node;
            size++;
        }

        public void push(Node node) {
            if (root == null)
                insertFirstNode(node);
            else {
                Node auxNode = root;
                Node sonNode = root;

                while (sonNode != null) {
                    auxNode = sonNode;
                    if (node.value <= auxNode.value) {
                        sonNode = auxNode.left;
                    } else {
                        sonNode = auxNode.right;
                    }
                }

                if (node.value <= auxNode.value) {
                    auxNode.left = node;
                } else {
                    auxNode.right = node;
                }

            }
        }

        public void removeValue(int value) {
            Node auxNode = getNodeByValue(value);
            if (auxNode != null)
                auxNode.removed = true;
        }

        public Node getNodeByValue(int value) {
            Node auxNode = root;
            while (auxNode != null && auxNode.value != value) {
                if (value > auxNode.value) {
                    auxNode = auxNode.right;
                } else {
                    auxNode = auxNode.left;
                }
            }
            return auxNode;
        }
    }

    public static class Queue extends SinglyLinkedList {
        public String printQueue() {
            StringBuilder sb = new StringBuilder();
            Node auxNode = head;
            while (auxNode != null) {
                if (auxNode.removed) {
                    auxNode = auxNode.next;
                } else {
                    if (sb.length() > 0)
                        sb.append(" ");
                    sb.append(auxNode.value);
                    auxNode = auxNode.next;
                }
            }
            return sb.toString();
        }
    }

    public static class SinglyLinkedList {
        public Node head;
        public Node tail;
        public int size;

        public SinglyLinkedList() {
            size = 0;
            head = null;
            tail = null;
        }

        public int getValue(int posicao) {
            return getNode(posicao).value;
        }

        private Node getNode(int posicao) {
            if (head == null) {
                throw new RuntimeException("Lista está vazia!");
            } else if (posicao < 0 || posicao >= size) {
                throw new IndexOutOfBoundsException("posição " + posicao + " está fora dos limites da lista");
            }
            Node auxNode = head;
            for (int i = 0; i < posicao; i++) {
                auxNode = auxNode.next;
            }
            return auxNode;

        }

        public void insertFirstNode(Node node) {
            if (head != null)
                return;
            head = node;
            tail = node;
            size++;
        }

        public void insertAtBeginning(Node node) {
            if (head == null)
                insertFirstNode(node);
            else {
                node.next = head;
                head = node;
                size++;
            }
        }

        public void insertAtEnd(Node node) {
            if (head == null)
                insertFirstNode(node);
            else {
                tail.next = node;
                tail = node;
                size++;
            }
        }

        public void insertAtPosition(int index, Node node) {
            if (index <= 0) {
                insertAtBeginning(node);
            } else if (index >= size) {
                insertAtEnd(node);
            } else {
                Node auxNode = getNode(index - 1);
                node.next = auxNode.next;
                auxNode.next = node;
                size++;
            }

        }

    }

    public static class Node {
        int value;
        boolean removed;
        Node parent;
        Node left;
        Node right;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

}