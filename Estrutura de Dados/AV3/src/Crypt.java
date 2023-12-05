import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária para criptografia.
 */
public class Crypt {

  /**
   * Retorna o hash SHA-1 de uma string.
   *
   * @param string a string para a qual o hash SHA-1 será calculado
   * @return o hash SHA-1 da string fornecida
   * @throws RuntimeException se o algoritmo SHA-1 não estiver disponível
   */
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
