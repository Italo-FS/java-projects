package ListaPrioridade;

abstract class PriorityQueue {

    protected class Node {
        int key;
        String value;
        Node next;
        Node prev;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    protected Node first;
    protected Node last;
    protected int size;

    public PriorityQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public PriorityQueue(int key, String value) {
        Node newNode = new Node(key, value);
        first = newNode;
        last = newNode;
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {
        Node auxNode = first;
        System.out.println();
        while (auxNode != null) {
            System.out.println("[" + auxNode.key + "]: " + auxNode.value);
            auxNode = auxNode.next;
        }
        System.out.println();
        System.out.println();

    }

    public Entry min() {
        Node minNode = minNode();
        return new Entry(minNode.key, minNode.value);
    };

    protected abstract Node minNode();

    public abstract Entry removeMin();

    public abstract void insert(int key, String value);

}
