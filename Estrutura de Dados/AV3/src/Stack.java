/**
 * Pilha genérica.
 *
 * @param <T> tipo genérico de elementos armazenados na pilha
 */
public class Stack<T> {

  /**
   * Classe interna que representa um nó na pilha.
   */
  public class Node {

    T data; // Dados armazenados no nó.
    Node next; // Referência para o próximo nó.

    /**
     * Construtor que inicializa um nó com os dados fornecidos.
     *
     * @param data os dados a serem armazenados no nó
     */
    public Node(T data) {
      this.data = data;
    }
  }

  private Node top; // Referência para o topo da pilha.
  private int height; // Altura da pilha (número de elementos).

  /**
   * Construtor que inicializa uma pilha vazia.
   */
  public Stack() {
    top = null;
    height = 0;
  }

  /**
   * Imprime os elementos da pilha.
   * Se um elemento for uma instância de AvlTree, imprime a árvore AVL.
   */
  public void printStack() {
    Node auxNode = top;
    while (auxNode != null) {
      if (auxNode.data instanceof AvlTree) {
        ((AvlTree<?>) auxNode.data).printTree();
      } else {
        System.out.println("[" + auxNode.data + "]");
      }
      auxNode = auxNode.next;
    }
  }

  /**
   * Remove e retorna o elemento no topo da pilha.
   *
   * @return o elemento removido do topo da pilha
   * @throws RuntimeException se a pilha estiver vazia
   */
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

  /**
   * Adiciona um elemento ao topo da pilha.
   *
   * @param data o elemento a ser adicionado à pilha
   */
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

  /**
   * Retorna o elemento no topo da pilha sem removê-lo.
   *
   * @return o elemento no topo da pilha
   */
  public T peek() {
    return top.data;
  }

  /**
   * Retorna a altura atual da pilha.
   *
   * @return a altura atual da pilha
   */
  public int size() {
    return height;
  }
}
