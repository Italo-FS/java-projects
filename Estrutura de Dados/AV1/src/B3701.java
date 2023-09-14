import java.util.Scanner;

public class B3701 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Byte _byte = new Byte();

    int n = sc.nextInt();

    for (int i = 0; i < 8; i++) {
      _byte.push(sc.nextInt());
    }

    sc.nextLine();

    for (int i = 0; i < n; i++) {
      String cmd = sc.nextLine();

      if (cmd.equals("direita"))
        _byte.shiftRight();
      else if (cmd.equals("esquerda"))
        _byte.shiftLeft();
      else
        throw new RuntimeException("comando inválido");
    }

    sc.close();
    _byte.print();
  }

  public static class Byte {
    Bit head;
    Bit tail;
    int length;

    public Byte() {
      this.length = 0;
      this.head = null;
      this.tail = null;
    }

    public void print() {
      Bit auxNode = this.head;
      do {
        System.out.print(auxNode.value);
        auxNode = auxNode.next;
      } while (auxNode != this.head);
      System.out.println();
    }

    private void insertFirstNode(Bit node) {
      if (this.length != 0)
        throw new RuntimeException("A lista deve estar vazia para que se insira o primeiro nó.");
      this.head = node;
      this.tail = node;
      this.tail.next = this.head;
      this.head.previous = this.tail;
      this.length++;
    }

    public void push(int value) {
      Bit node = new Bit(value);
      if (this.length == 0)
        insertFirstNode(node);
      else {
        node.next = this.head;
        node.previous = this.tail;
        this.tail.next = node;
        this.head.previous = node;
        this.tail = node;
        this.length++;
      }
    }

    public void shiftLeft() {
      this.tail = this.head;
      this.head = this.head.next;
    }

    public void shiftRight() {
      this.head = this.tail;
      this.tail = this.head.previous;
    }
  }

  public static class Bit {
    int value;
    Bit next;
    Bit previous;

    public Bit(int value) {
      this.value = value;
    }
  }
}
