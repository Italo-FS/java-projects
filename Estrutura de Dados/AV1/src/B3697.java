import java.util.Scanner;

public class B3697 {
  public static void main(String[] args) {

    DoubleLinkedList primeList = new DoubleLinkedList(true);
    DoubleLinkedList notPrimeList = new DoubleLinkedList(false);

    Scanner sc = new Scanner(System.in);

    while (true) {
      int number = sc.nextInt();
      if (number < 0)
        break;

      if (number == 0) {
      } else if (isPrime(number))
        primeList.insert(number);
      else
        notPrimeList.insert(number);
    }
    sc.close();

    if (primeList.length == 0 || notPrimeList.length == 0) {
      System.out.println("Uma das listas está vazia.");
    } else {
      primeList.print();
      System.out.println("-");
      notPrimeList.print();
    }
  }

  public static boolean isPrime(int value) {
    for (int i = 2; i <= value / 2; i++) {
      if (value % i == 0)
        return false;
    }
    return true;
  }

  public static class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;
    private boolean crescentOrder;

    public DoubleLinkedList(boolean crescentOrder) {
      this.crescentOrder = crescentOrder;
      this.length = 0;
      this.head = null;
      this.tail = null;
    }

    public void print() {
      Node auxNode = this.head;
      do {
        System.out.println(auxNode.value);
        auxNode = auxNode.next;
      } while (auxNode != null);
    }

    private void insertFirstNode(Node node) {
      if (this.length != 0)
        throw new RuntimeException("A lista deve estar vazia para que se insira o primeiro nó.");
      this.head = node;
      this.tail = node;
      this.length++;
    }

    public void unshift(Node node) {
      if (this.length == 0)
        insertFirstNode(node);
      else {
        node.next = this.head;
        this.head.previous = node;
        this.head = node;
        this.length++;
      }
    }

    public void push(Node node) {
      if (this.length == 0)
        insertFirstNode(node);
      else {
        node.previous = this.tail;
        this.tail.next = node;
        this.tail = node;
        this.length++;
      }
    }

    public void insert(int value) {
      Node node = new Node(value);
      if (this.length == 0)
        insertFirstNode(node);
      else {
        Node auxNode = this.head;
        while (true) {
          if ((node.value < auxNode.value && this.crescentOrder)
              || (node.value > auxNode.value && !this.crescentOrder)) {

            if (auxNode == this.head)
              unshift(node);
            else {
              node.previous = auxNode.previous;
              node.next = auxNode;
              auxNode.previous = node;
              this.length++;
            }

            break;
          } else if (auxNode.next == null) {
            push(node);
            break;
          }
          auxNode = auxNode.next;
        }
      }
    }
  }

  public static class Node {
    public int value;
    public Node next;
    public Node previous;

    public Node(int value) {
      this.value = value;
    }
  }
}
