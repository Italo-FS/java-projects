import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

  public static String read(String fileName) {
    StringBuilder content = new StringBuilder();

    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader reader = new BufferedReader(fileReader);

      String row;

      // Lê cada linha do arquivo e adiciona ao StringBuilder
      while ((row = reader.readLine()) != null) {
        content.append(row).append("\n");
      }

      reader.close(); // Fecha o leitor após a leitura do arquivo
    } catch (IOException e) {
      throw new RuntimeException(
        "Ocorreu um erro ao ler o arquivo: " + e.getMessage()
      );
    }

    return content.toString();
  }
}
