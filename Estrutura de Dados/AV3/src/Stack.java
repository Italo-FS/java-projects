public class Stack<T> {

  public class Node {

    T data;
    Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node top;
  private int height;

  public Stack() {
    top = null;
    height = 0;
  }

  public void printStack() {
    Node auxNode = top;
    while (auxNode != null) {
      if (auxNode.data instanceof BinarySearchTree) {
        ((BinarySearchTree) auxNode.data).printTree();
      } else {
        System.out.println("[" + auxNode.data + "]");
      }
      auxNode = auxNode.next;
    }
  }

  public T pop() {
    if (top == null) {
      throw new RuntimeException("Pila vazia.");
    }
    Node poppedNode = top;
    top = top.next;
    poppedNode.next = null;
    height--;
    return poppedNode.data;
  }

  public void push(T data) {
    Node newNode = new Node(data);
    if (top == null) {
      top = newNode;
    } else {
      newNode.next = top;
      top = newNode;
    }
    height++;
  }

  public T peek() {
    return top.data;
  }

  public Node getTop() {
    return top;
  }

  public int getHeight() {
    return height;
  }
}
