public class Generics {
    public static class SinglyLinkedList<T> {
        protected Node<T> head;
        protected Node<T> tail;
        protected int size;

        public SinglyLinkedList() {
            size = 0;
            head = null;
            tail = null;
        }

        public SinglyLinkedList(T value) {
            Node<T> newNode = new Node<T>(value);
            head = newNode;
            tail = newNode;
            size = 1;
        }

        public T getValueAt(int position) {
            return getNodeAt(position).value;
        }

        protected Node<T> getNodeAt(int position) {
            if (head == null) {
                throw new RuntimeException("List is empty!");
            } else if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Position " + position + " is out of bounds of the list");
            }
            Node<T> tempNode = head;
            for (int i = 0; i < position; i++) {
                tempNode = tempNode.next;
            }
            return tempNode;
        }

        public void insertAtStart(T value) {
            Node<T> newNode = new Node<T>(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        public void insertAtEnd(T value) {
            Node<T> newNode = new Node<T>(value);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }

        public void insertAtPosition(int position, T value) {
            if (position <= 0) {
                insertAtStart(value);
            } else if (position >= size) {
                insertAtEnd(value);
            } else {
                Node<T> newNode = new Node<T>(value);
                Node<T> tempNode = getNodeAt(position - 1);
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                size++;
            }
        }
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }
}
