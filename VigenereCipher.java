import java.util.Scanner;

public class VigenereCipher {

    // Encrypts the plain text using the key
    public static String stringEncryption(String text, String key) {
        StringBuilder cipherText = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char plainChar = text.charAt(i);
            char keyChar = key.charAt(i % key.length());

            // Encrypt alphabetic characters
            int encryptedChar = (plainChar + keyChar) % 256;  // Use modulo 256 to stay within ASCII range
            cipherText.append((char) encryptedChar);
        }

        return cipherText.toString();
    }

    // Decrypts the cipher text using the key
    public static String stringDecryption(String s, String key) {
        StringBuilder plainText = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char cipherChar = s.charAt(i);
            char keyChar = key.charAt(i % key.length());

            // Decrypt alphabetic characters
            int decryptedChar = (cipherChar - keyChar + 256) % 256;  // Ensure positive result using modulo 256
            plainText.append((char) decryptedChar);
        }

        return plainText.toString();
    }

    // Expands the key to match the length of the text
    public static String expandKey(int length, String key) {
        StringBuilder expandedKey = new StringBuilder();
        for (int i = 0; i < length; i++) {
            expandedKey.append(key.charAt(i % key.length()));
        }
        return expandedKey.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plainText = scanner.nextLine();

        System.out.print("Enter Key: ");
        String key = scanner.nextLine();

        String expandedKey = expandKey(plainText.length(), key);
        String cipherText = stringEncryption(plainText, expandedKey);

        System.out.println("Cipher Text is: " + cipherText);
        System.out.println("Decrypted Plain Text is: " + stringDecryption(cipherText, expandedKey));

        scanner.close();
    }
}
