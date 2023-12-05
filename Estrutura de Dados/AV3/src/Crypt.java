import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypt {

  public static String sha1(String string) {
    try {
      MessageDigest mDigest = MessageDigest.getInstance("SHA1");
      byte[] result = mDigest.digest(string.getBytes());
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < result.length; i++) {
        sb.append(
          Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1)
        );
      }

      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Erro: Algoritmo SHA-1 não disponível");
    }
  }
}
