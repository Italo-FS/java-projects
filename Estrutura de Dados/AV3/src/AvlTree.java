public class AvlTree<T extends Comparable<T>> {

  class Node {

    T data;
    int rightLength;
    int leftLength;
    Node left;
    Node right;

    public Node(T data) {
      this.data = data;
    }

    public int getBiggerLength() {
      return (rightLength > leftLength) ? rightLength : leftLength;
    }

    public int getDifference() {
      return leftLength - rightLength;
    }

    public void updateLenght() {
      leftLength = left == null ? 0 : left.getBiggerLength() + 1;
      rightLength = right == null ? 0 : right.getBiggerLength() + 1;
    }

    public int compareTo(Node otherNode) {
      if (data instanceof String && otherNode.data instanceof String) {
        return ((String) data).compareToIgnoreCase((String) otherNode.data);
      } else {
        return data.compareTo(otherNode.data);
      }
    }

    public String getHash() {
      return Crypt.sha1((String) data);
    }
  }

  Node root;

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

      node.updateLenght();
      balance(node);
    }
  }

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
      node.updateLenght();
      balance(node);
    }

    return node;
  }

  private Node findMinChildren(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

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

  private void rotateLeft(Node node) {
    Node auxNode = node.right;

    node.right = auxNode.right;
    auxNode.right = auxNode.left;
    auxNode.left = node.left;
    node.left = auxNode;

    swapValues(node, auxNode);
    auxNode.updateLenght();
    node.updateLenght();
  }

  private void rotateRight(Node node) {
    Node auxNode = node.left;

    node.left = auxNode.left;
    auxNode.left = auxNode.right;
    auxNode.right = node.right;
    node.right = auxNode;

    swapValues(node, auxNode);
    auxNode.updateLenght();
    node.updateLenght();
  }

  private void swapValues(Node nodeA, Node nodeB) {
    T aux = nodeA.data;
    nodeA.data = nodeB.data;
    nodeB.data = aux;
  }
}
