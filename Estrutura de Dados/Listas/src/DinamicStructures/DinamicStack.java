package DinamicStructures;

public class DinamicStack<T> {
    public int height;
    private Node<T> head;
    private Node<T> tail;

    public DinamicStack() {
        this.height = 0;
        this.head = null;
        this.tail = null;
    }

    public void insertFirstNode(T value) {
        if (height != 0)
            throw new RuntimeException(
                    "Não é possível inserir o primeiro elemento em uma pilha que já possui elementos.");
        this.head = this.tail = new Node<T>(value);
        this.height++;
    }

    public void insertLastNode(T value) {
        if (height != 0)
            insertFirstNode(value);
        else {
            this.head = this.tail = new Node<T>(value);
            this.height++;
        }
    }

    public void insertNodeAt(int index) {

    }

}
