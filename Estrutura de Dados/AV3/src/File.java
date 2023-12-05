import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitária para operações de leitura de arquivos.
 */
public class File {

  /**
   * Lê o conteúdo de um arquivo de texto.
   *
   * @param fileName o nome do arquivo a ser lido
   * @return uma string contendo o conteúdo do arquivo
   * @throws RuntimeException se ocorrer um erro durante a leitura do arquivo
   */
  public static String read(String fileName) {
    StringBuilder content = new StringBuilder();

    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader reader = new BufferedReader(fileReader);
      String row;

      while ((row = reader.readLine()) != null) {
        content.append(row).append("\n");
      }

      reader.close();
    } catch (IOException e) {
      throw new RuntimeException(
        "Ocorreu um erro ao ler o arquivo: " + e.getMessage()
      );
    }

    return content.toString();
  }
}
