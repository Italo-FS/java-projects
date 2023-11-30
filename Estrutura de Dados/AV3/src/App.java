public class App {

  public static void main(String[] args) throws Exception {
    Stack<BinarySearchTree<String>> stackTree = new Stack<>();

    String fileContent = File.read("arquivo.txt");

    for (String row : fileContent.split("\\n")) {
      Stack<String> fileStack = new Stack<>();
      stackTree.push(new BinarySearchTree<String>());

      for (String word : row.split("\\s+")) {
        fileStack.push(word);
      }

      while (fileStack.getHeight() > 0) {
        stackTree.peek().insert(fileStack.pop());
      }
    }

    while (stackTree.getHeight() > 0) {
      System.out.println(stackTree.pop().hashTree());
    }
  }
}
