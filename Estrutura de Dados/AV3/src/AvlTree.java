/**
 * Árvore AVL genérica.
 *
 * @param <T> tipo genérico que estende Comparable para a árvore AVL.
 */
public class AvlTree<T extends Comparable<T>> {

  /**
   * Classe interna que representa um nó na árvore AVL.
   */
  class Node {

    T data; // Dados armazenados no nó
    int rightLength; // Comprimento do ramo direito a partir deste nó
    int leftLength; // Comprimento do ramo esquerdo a partir deste nó
    Node left; // Referência para o Nó filho esquerdo
    Node right; // Referência para o Nó filho direito

    /**
     * Construtor que inicializa um nó com os dados fornecidos.
     *
     * @param data os dados a serem armazenados no nó
     */
    public Node(T data) {
      this.data = data;
    }

    /**
     * Obtém o maior comprimento entre os ramos esquerdo e direito a partir deste nó.
     *
     * @return int O maior comprimento entre os ramos esquerdo e direito
     */
    public int getBiggerLength() {
      return (rightLength > leftLength) ? rightLength : leftLength;
    }

    /**
     * Calcula a diferença entre os comprimentos do ramo esquerdo e direito a
     * partir deste nó.
     *
     * @return int A diferença entre os comprimentos do ramo esquerdo e direito
     */
    public int getDifference() {
      return leftLength - rightLength;
    }

    /**
     * Atualiza os comprimentos do ramo esquerdo e direito a partir deste nó.
     */
    public void updateLength() {
      leftLength = left == null ? 0 : left.getBiggerLength() + 1;
      rightLength = right == null ? 0 : right.getBiggerLength() + 1;
    }

    /**
     * Compara os dados deste nó com os dados de outro nó.
     * Se os dados forem Strings, compara sem diferenciar maiúsculas e minúsculas.
     *
     * @param otherNode o nó a ser comparado
     * @return int Um valor negativo se menor, zero se igual e um valor positivo se
     *         maior
     */
    public int compareTo(Node otherNode) {
      if (data instanceof String && otherNode.data instanceof String) {
        return ((String) data).compareToIgnoreCase((String) otherNode.data);
      } else {
        return data.compareTo(otherNode.data);
      }
    }

    /**
     * Obtém o hash SHA-1 dos dados deste nó, assumindo que os dados são do tipo
     * String.
     *
     * @return o hash SHA-1 dos dados deste nó
     */
    public String getHash() {
      return Crypt.sha1((String) data);
    }
  }

  Node root;

  /**
   * Imprime a árvore AVL horizontalmente.
   */
  public void printTree() {
    printTree(root, "");
    System.out.println();
  }

  private void printTree(Node node, String address) {
    if (node != null) {
      int level = address.length();
      printTree(node.right, address + "1");
      if (level > 0) {
        for (int i = 0; i < level - 1; i++) {
          if (address.charAt(i) != address.charAt(i + 1)) {
            System.out.print("│   ");
          } else {
            System.out.print("    ");
          }
        }
        if (address.charAt(level - 1) == '1') {
          System.out.print("┌───");
        } else {
          System.out.print("└───");
        }
      }
      System.out.println(node.data);
      printTree(node.left, address + "0");
    }
  }

  /**
   * Calcula o hash da árvore AVL.
   *
   * @return o hash SHA-1 da árvore AVL
   */
  public String hashTree() {
    return hashTree(root);
  }

  private String hashTree(Node node) {
    if (node == null) return "";
    if (node.left == null && node.right == null) {
      return Crypt.sha1((String) node.data);
    } else {
      return Crypt.sha1(
        hashTree(node.left) +
        hashTree(node.right) +
        Crypt.sha1((String) node.data)
      );
    }
  }

  /**
   * Exibe os dados da árvore AVL em ordem crescente.
   */
  public void showOrder() {
    showOrder(root);
    System.out.println();
  }

  private void showOrder(Node node) {
    if (node != null) {
      showOrder(node.left);
      System.out.print(node.data + " ");
      showOrder(node.right);
    }
  }

  /**
   * Verifica se a árvore AVL contém um determinado valor.
   *
   * @param value o valor a ser verificado
   * @return boolean true se a árvore contém o valor, caso contrário, false
   */
  public boolean contains(T value) {
    Node comparisonNode = new Node(value);
    return contains(root, comparisonNode);
  }

  private boolean contains(Node node, Node comparisonNode) {
    if (node != null) {
      if (node.compareTo(comparisonNode) == 0) {
        return true;
      }
      if (comparisonNode.compareTo(node) < 0) {
        return contains(node.left, comparisonNode);
      } else {
        return contains(node.right, comparisonNode);
      }
    }
    return false;
  }

  /**
   * Insere um novo valor na árvore AVL.
   *
   * @param value o valor a ser inserido
   */
  public void insert(T value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
    } else {
      insert(root, newNode);
    }
  }

  private void insert(Node node, Node newNode) {
    if (node.data != newNode.data) {
      if (newNode.compareTo(node) < 0) {
        if (node.left == null) {
          node.left = newNode;
        } else {
          insert(node.left, newNode);
        }
      } else {
        if (node.right == null) {
          node.right = newNode;
        } else {
          insert(node.right, newNode);
        }
      }

      node.updateLength();
      balance(node);
    }
  }

  /**
   * Remove um valor específico da árvore AVL.
   *
   * @param value o valor a ser removido
   */
  public void remove(T value) {
    Node comparisonNode = new Node(value);
    remove(root, comparisonNode);
  }

  private Node remove(Node node, Node comparisonNode) {
    if (node == null) return null;

    if (comparisonNode.compareTo(node) < 0) {
      node.left = remove(node.left, comparisonNode);
    } else if (comparisonNode.compareTo(node) > 0) {
      node.right = remove(node.right, comparisonNode);
    } else {
      if (node.left == null && node.right == null) { // Leaf
        return null;
      } else if (node.left != null && node.right == null) { // One Children Left
        return node.left;
      } else if (node.left == null && node.right != null) { // One Children Right
        return node.right;
      } else { // Two Childrens
        Node successor = findMinChildren(node.right);
        node.data = successor.data;
        node.right = remove(node.right, successor);
      }
    }

    if (node != null) {
      node.updateLength();
      balance(node);
    }

    return node;
  }

  /**
   * Encontra e retorna o nó com o valor mínimo a partir do nó fornecido.
   *
   * @param node o nó a partir do qual a busca pelo valor mínimo começa
   * @return Node O nó com o valor mínimo encontrado a partir do nó fornecido
   */
  private Node findMinChildren(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  /**
   * Realiza o balanceamento da árvore AVL verificando e realizando rotações se
   * necessário.
   *
   * @param node o nó a ser balanceado
   */
  private void balance(Node node) {
    if (node.getDifference() < -1) {
      if (node.right != null && node.right.getDifference() > 0) {
        rotateRight(node.right);
      }
      rotateLeft(node);
    }
    if (node.getDifference() > 1) {
      if (node.left != null && node.left.getDifference() < 0) {
        rotateLeft(node.left);
      }
      rotateRight(node);
    }
  }

  /**
   * Realiza uma rotação para a esquerda em torno do nó fornecido.
   *
   * @param node o nó ao redor do qual a rotação para a esquerda é realizada
   */
  private void rotateLeft(Node node) {
    Node auxNode = node.right;

    node.right = auxNode.right;
    auxNode.right = auxNode.left;
    auxNode.left = node.left;
    node.left = auxNode;

    swapValues(node, auxNode);
    auxNode.updateLength();
    node.updateLength();
  }

  /**
   * Realiza uma rotação para a direita em torno do nó fornecido.
   *
   * @param node o nó ao redor do qual a rotação para a direita é realizada
   */
  private void rotateRight(Node node) {
    Node auxNode = node.left;

    node.left = auxNode.left;
    auxNode.left = auxNode.right;
    auxNode.right = node.right;
    node.right = auxNode;

    swapValues(node, auxNode);
    auxNode.updateLength();
    node.updateLength();
  }

  /**
   * Troca os valores entre dois nós na árvore AVL.
   *
   * @param nodeA o primeiro nó
   * @param nodeB o segundo nó
   */
  private void swapValues(Node nodeA, Node nodeB) {
    T aux = nodeA.data;
    nodeA.data = nodeB.data;
    nodeB.data = aux;
  }
}
