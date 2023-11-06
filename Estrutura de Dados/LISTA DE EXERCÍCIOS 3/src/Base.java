public class Base {
    public class SinglyLinkedList {
        private Node head;
        private Node tail;
        private int tamanho;

        public SinglyLinkedList() {
            tamanho = 0;
            head = null;
            tail = null;
        }

        public int getValue(int posicao) {
            return getNode(posicao).value;
        }

        private Node getNode(int posicao) {
            if (head == null) {
                throw new RuntimeException("Lista está vazia!");
            } else if (posicao < 0 || posicao >= tamanho) {
                throw new IndexOutOfBoundsException("posição " + posicao + " está fora dos limites da lista");
            }
            Node auxNode = head;
            for (int i = 0; i < posicao; i++) {
                auxNode = auxNode.next;
            }
            return auxNode;

        }

        public void insertFirstNode(int value) {
            if (head != null)
                return;
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            tamanho++;
        }

        public void insertAtBeginning(int value) {
            if (head == null)
                insertFirstNode(value);
            else {
                Node newNode = new Node(value);
                newNode.next = head;
                head = newNode;
                tamanho++;
            }
        }

        public void insertAtEnd(int value) {
            if (head == null)
                insertFirstNode(value);
            else {
                Node newNode = new Node(value);
                tail.next = newNode;
                tail = newNode;
                tamanho++;
            }
        }

        public void insertAtPosition(int index, int value) {
            if (index <= 0) {
                insertAtBeginning(value);
            } else if (index >= tamanho) {
                insertAtEnd(value);
            } else {
                Node newNode = new Node(value);
                Node auxNode = getNode(index - 1);
                newNode.next = auxNode.next;
                auxNode.next = newNode;
                tamanho++;
            }

        }

        public void printList() {
            System.out.print("[");
            Node auxNode = head;
            while (auxNode != null) {
                System.out.print(auxNode.value);
                auxNode = auxNode.next;
                if (auxNode != null) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
