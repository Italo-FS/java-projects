package ListaPrioridade;

class SortedPriorityQueue extends PriorityQueue {

    @Override
    protected Node minNode() {
        return first;
    }

    @Override
    public Entry removeMin() {
        Node minNode = first;
        first = first.next;
        first.prev = null;
        minNode.next = null;
        return new Entry(minNode.key, minNode.value);
    }

    @Override
    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else if (newNode.key < first.key) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        } else if (newNode.key >= last.key) {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        } else {
            Node auxNode = first;
            do {
                auxNode = auxNode.next;
            } while (auxNode.key <= newNode.key);
            newNode.prev = auxNode.prev;
            newNode.next = auxNode;
            auxNode.prev.next = newNode;
            auxNode.prev = newNode;
        }
        size++;
    }
}
