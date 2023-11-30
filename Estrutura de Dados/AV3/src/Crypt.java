import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypt {

  public static String sha1(String string) {
    try {
      if (string == null) return "";

      // Criação de uma instância do MessageDigest para SHA-1
      MessageDigest digest = MessageDigest.getInstance("SHA-1");

      // Converte a string para bytes e calcula o hash
      byte[] hashBytes = digest.digest(string.getBytes());

      // Converte o hash em representação hexadecimal
      StringBuilder hexString = new StringBuilder();
      for (byte hashByte : hashBytes) {
        String hex = Integer.toHexString(0xff & hashByte);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }

      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Erro: Algoritmo SHA-1 não disponível");
    }
  }
}
