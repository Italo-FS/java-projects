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
