Simple java encryption
======================

This is a very simple java encryption library, it uses a secret password as encryption key, it must be 16 bytes in length sample 16 byte strings are:

* randomPassword00
* rándomPassword0

Notice how the second string is one character shorter, it is nonetheless a 16 byte string, that is because we use UTF-8 byte representation.

Usage is quite simple:



        import iamedu.crypt.CryptoUtil;

        public class HelloWorld {
          public static void main(String[] args) {
            String password = ...
            String encryptedString = CryptoUtil.encrypt(password, "my secret string");
            System.out.println("I can transfer this string " + encryptedString);

            // Don't tell anyone this, it is a secret
            String decodedString = CryptoUtil.decrypt(password, encryptedString);
          }
        }


Ecnrypted string are Base64 encoded, so you don't need to worry they are valid ASCII strings

