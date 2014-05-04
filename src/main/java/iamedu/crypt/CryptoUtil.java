package iamedu.crypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CryptoUtil {
  private static SecretKeySpec generateSecretKey(String password) throws Exception {
    byte[] passwordBytes = password.getBytes("UTF-8");

    if(passwordBytes.length != 16) {
      throw new SecurityException("Password should be of 16 bytes length");
    }

    return new SecretKeySpec(passwordBytes, "AES");
  }

  public static String encrypt(String password, String string) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      SecretKeySpec secretKey = generateSecretKey(password);

      cipher.init(Cipher.ENCRYPT_MODE, secretKey);

      final String encryptedString = Base64.encodeBase64String(cipher.doFinal(string.getBytes("UTF-8")));

      return encryptedString;
    } catch(Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  public static String decrypt(String password, String encrypted) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      SecretKeySpec secretKey = generateSecretKey(password);

      cipher.init(Cipher.DECRYPT_MODE, secretKey);

      final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(encrypted)));

      return decryptedString;
    } catch(Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

}
