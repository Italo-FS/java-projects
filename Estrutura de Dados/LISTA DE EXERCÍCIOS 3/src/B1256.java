import java.util.Scanner;

public class B1256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numberOfTests = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfTests; i++) {
            int key = sc.nextInt();
            int caseSize = sc.nextInt();
            sc.nextLine();

            HashTable<Object> hashTable = new HashTable<>(key);

            for (int j = 0; j < caseSize; j++) {
                int value = sc.nextInt();
                int hash = hash(value, key);
                hashTable.insertValueAtListAtPosition(value, hash);
            }
            sc.nextLine();

            sb.append(hashTable.displayList());
            if (i + 1 < numberOfTests)
                sb.append("\n");

        }
        System.out.print(sb);

        sc.close();
    }

    public static int hash(int value, int key) {
        return value % key;
    }

    public static class HashTable<T> extends SinglyLinkedList<T> {
        @SuppressWarnings("unchecked")
        public HashTable(int size) {
            for (int i = 0; i < size; i++) {
                SinglyLinkedList<T> list = new SinglyLinkedList<T>();
                insertAtEnd((T) list);
            }
        }

        @SuppressWarnings("unchecked")
        public void insertValueAtListAtPosition(T Value, int Position) {
            SinglyLinkedList<T> list = (SinglyLinkedList<T>) getNodeAt(Position).value;
            list.insertAtEnd(Value);
        }

        @Override
        @SuppressWarnings("unchecked")
        public String displayList() {
            StringBuilder sb = new StringBuilder();
            Node<T> tempNode = head;
            for (int i = 0; i < size; i++) {
                SinglyLinkedList<T> list = (SinglyLinkedList<T>) tempNode.value;
                sb.append(i);
                sb.append(" -> ");
                sb.append(list.displayList());
                sb.append("\n");
                tempNode = tempNode.next;
            }
            return sb.toString();
        }
    }

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

        public String displayList() {
            StringBuilder sb = new StringBuilder();
            Node<T> tempNode = head;
            while (tempNode != null) {
                sb.append(tempNode.value);
                tempNode = tempNode.next;
                sb.append(" -> ");
            }
            sb.append("\\");
            return sb.toString();
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
