public class App {

  public static void main(String[] args) throws Exception {
    String fileContent = File.read("arquivo.txt");

    Stack<AvlTree<String>> treeStack = new Stack<>();
    for (String row : fileContent.split("\\n")) {
      Stack<String> wordStack = new Stack<>();
      for (String word : row.split("\\s+")) {
        wordStack.push(word);
      }

      treeStack.push(new AvlTree<String>());
      while (wordStack.getHeight() > 0) {
        treeStack.peek().insert(wordStack.pop());
      }
    }

    while (treeStack.getHeight() > 0) {
      String hash = treeStack.pop().hashTree();
      System.out.println(hash);
    }
  }
}
/**
 * == Passo a Passo ============================================================
 * 1. Lê o arquivo .txt e armazena seu conteúdo na variável 'fileContent'.
 * 2. Para cada linha em 'fileContent':
 *    1. Cria uma Pilha de Árvores (treeStack).
 *    2. Empilha cada palavra da linha na Pilha de Palavras (wordStack).
 *    3. Empilha uma nova Árvore de Strings no topo da Pilha de Árvores 'treeStack'.
 *    4. Desempilha cada palavra de 'wordStack' e insere na Árvore de Strings no topo
 *       da Pilha de Árvores (treeStack).
 * 3. Para cada árvore na Pilha de Árvores (treeStack):
 *    1. Desempilha cada Árvore e aplica o hash.
 *    2. Imprime o hash da Árvore no console.
 * ==============================================================================
 **/
