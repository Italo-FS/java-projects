public class App {

  public static void main(String[] args) throws Exception {
    Stack<BinarySearchTree<String>> treeStack = new Stack<>();

    String fileContent = File.read("arquivo.txt");

    for (String row : fileContent.split("\\n")) {
      Stack<String> wordStack = new Stack<>();
      treeStack.push(new BinarySearchTree<String>());

      for (String word : row.split("\\s+")) {
        wordStack.push(word);
      }

      while (wordStack.getHeight() > 0) {
        treeStack.peek().insert(wordStack.pop());
      }
    }

    while (treeStack.getHeight() > 0) {
      System.out.println(treeStack.pop().hashTree());
    }
  }
}
