package ListaPrioridade;

class UnsortedPriorityQueue extends PriorityQueue {
    @Override
    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    @Override
    protected Node minNode() {
        if (isEmpty()) {
            return null;
        }
        Node minNode = first;
        Node auxNode = first.next;
        while (auxNode != null) {
            if (auxNode.key < minNode.key) {
                minNode = auxNode;
            }
            auxNode = auxNode.next;
        }
        return minNode;
    }

    @Override
    public Entry min() {
        Node minNode = minNode();
        return new Entry(minNode.key, minNode.value);
    }

    @Override
    public Entry removeMin() {
        Node minNode = minNode();
        if (minNode == null) {
            return null;
        }

        if (size == 1) {
            first = null;
            last = null;

        } else if (minNode.prev == null) {
            first = first.next;
            first.prev = null;
            minNode.next = null;

        } else if (minNode.next == null) {
            last = last.prev;
            last.next = null;
            minNode.prev = null;

        } else {
            minNode.prev.next = minNode.next;
            minNode.next.prev = minNode.prev;
            minNode.next = null;
            minNode.prev = null;
        }
        size--;
        return new Entry(minNode.key, minNode.value);

    }

}
