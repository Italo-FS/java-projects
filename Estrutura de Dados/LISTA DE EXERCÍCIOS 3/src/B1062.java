import java.util.Scanner;

public class B1062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int trainSize = sc.nextInt();
            sc.nextLine();
            if (trainSize == 0)
                break;

            while (true) {
                Train b = new Train(0, null);
                Train station = new Train(0, b);
                Train a = new Train(trainSize, station);
                List desire = new List(); // Lista do modelo desejado

                int wagon = sc.nextInt();
                if (wagon == 0)
                    break;
                desire.insertAtBeginning(wagon);

                for (int i = 0; i < trainSize - 1; i++) {
                    wagon = sc.nextInt();
                    desire.insertAtEndding(wagon);
                }

                sc.nextLine();
                Node searchedWagon = desire.head;

                while (b.size < trainSize) {
                    if (!station.searchWagon(searchedWagon.value)) {
                        a.detachWagon(searchedWagon.value);
                    }
                    station.detachWagon(searchedWagon.value);
                    searchedWagon = searchedWagon.next;
                }

                if (Train.compare(b, desire))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
            System.out.println();
        }
        sc.close();
    }

    public static class Train extends List {
        Train next;

        public Train(int size, Train next) {
            this.next = next;
            for (int i = size; i > 0; i--) {
                insertAtEndding(i);
            }
        }

        public boolean searchWagon(int wagon) {
            Node auxNode = tail;
            while (auxNode != null) {
                if (wagon == auxNode.value)
                    return true;
                auxNode = auxNode.prev;
            }
            return false;
        }

        public void detachWagon(int wagon) {
            while (size > 0) {
                int detachedWagon = removeAtEndding();
                next.insertAtEndding(detachedWagon);
                if (wagon == detachedWagon)
                    break;
            }
        }

        public static boolean compare(List trainA, List trainB) {
            if (trainA.size != trainB.size)
                throw new RuntimeException("Os trens devem possuir mesmo tamanho.");

            Node auxNodeA = trainA.head;
            Node auxNodeB = trainB.head;

            while (auxNodeA != null && auxNodeB != null) {
                if (auxNodeA.value != auxNodeB.value)
                    return false;
                auxNodeA = auxNodeA.next;
                auxNodeB = auxNodeB.next;
            }

            return true;
        }
    }

    public static class List {
        protected int size;
        protected Node head;
        protected Node tail;

        public void insertAtBeginning(int value) {
            if (head == null) {
                insertFirst(value);
            } else {
                Node newNode = new Node(value);
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
                size++;
            }
        }

        public void insertAtEndding(int value) {
            if (tail == null) {
                insertFirst(value);
            } else {
                Node newNode = new Node(value);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                size++;
            }
        }

        private void insertFirst(int value) {
            if (head != null)
                throw new RuntimeException("A lista deve estar vazia para executar 'insertFirst()'.");
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            size++;
        }

        public int removeAtBeginning() {
            if (head == tail) {
                return removeLast();
            } else {
                Node auxNode = head;
                head = auxNode.next;
                head.prev = null;
                auxNode.next = null;
                size--;
                return auxNode.value;
            }
        }

        public int removeAtEndding() {
            if (head == tail) {
                return removeLast();
            } else {
                Node auxNode = tail;
                tail = auxNode.prev;
                tail.next = null;
                auxNode.prev = null;
                size--;
                return auxNode.value;
            }
        }

        private int removeLast() {
            if (head != tail)
                throw new RuntimeException("A lista deve ter tamanho 1 para executar 'insertFirst()'.");
            Node auxNode = head;
            head = null;
            tail = null;
            size--;
            return auxNode.value;
        }

        public void print() {
            Node auxNode = head;
            while (auxNode != null) {
                System.out.print(auxNode.value);
                auxNode = auxNode.next;
                if (auxNode != null)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }
}