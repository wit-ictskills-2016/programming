 

import java.lang.StringBuffer;

/*
 * For simplicity work in upper case and use [A-Z] only
 * That is, no other characters, such as white space and so on.
 * All input strings are immediately normalized to bytes in range [0 25] for algorithmic simplicity
 * For example the character A whose code is 65 becomes 0, B becomes 1 and so on.
 * The normalization process is reversed when required such as on generating output.
 * @author jfitzgerald
 * @see http://www.cs.mtu.edu/~shene/NSF-4/Tutorial/VIG/Vig-Base.html
 * @see http://ascii.cl/
 * @version 15-2-2016
 */
public class VigenereCipher
{

  private static final byte NUMBER_CHARS = 26;
  private static byte[][] vigenereTable = new byte[NUMBER_CHARS][NUMBER_CHARS];

  // The underlying numerical value of the character A
  private static final byte TRANSFORM_UPPER = 65;

  public VigenereCipher()
  {
    generateVigenereTable();
  }

  /**
   * Generates the Vigenere Table.
   */
  public static void generateVigenereTable()
  {
    // populate normalized vigenere table
    for (byte row = 0; row < NUMBER_CHARS; row += 1)
    {
      for (byte col = 0; col < NUMBER_CHARS; col += 1)
      {
        vigenereTable[row][col] = (byte) ((row + col) % NUMBER_CHARS);
      }
    }
  }

  /**
   * Use the keyword to generate a key. Key length is the same as the length of
   * the plain text. The key comprises repeating keyword. The last keyword in
   * the key is truncated if necessary.
   *
   * @param keyLength
   *          The number of characters in the key.
   * @param plainText
   *          The plain text for which a key will be generated.
   * @return The key for use in encrypting a message whose length matches the
   *         key length.
   */
  public static String generateKey(String keyword, int keyLength)
  {
    byte[] keywordBytes = keyword.getBytes();
    byte[] key = new byte[keyLength];

    int i = 0;
    do
    {
      int j = 0;
      while (j < keyword.length() && i < keyLength)
      {
        key[i++] = (byte) (keywordBytes[j++]);
      }
    } while (i < keyLength);

    return new String(key);
  }

  /**
   * Encrypts plain text (message text) under the key using the Vigenere Table.
   * 
   * @param plainText
   *          The plain text (message text) to be encrypted
   * @param key
   *          The key under which the plain text is encrypted
   * @return The cipher text created by encrypting the plaintext under the
   *         generated key.
   */
  public static String encrypt(String key, String plainText)
  {
    byte[] cipherText = new byte[plainText.length()];
    for (byte i = 0; i < plainText.length(); i += 1)
    {
      byte col = (byte) (plainText.charAt(i) - TRANSFORM_UPPER);
      byte row = (byte) (key.charAt(i) - TRANSFORM_UPPER);
      cipherText[i] = (byte) (vigenereTable[row][col] + TRANSFORM_UPPER);
    }
    return new String(cipherText);
  }

  /**
   * Decrypts cipher text under the key using the Vigenere Table.
   * 
   * @param key
   *          The key under which the cipher text is deccrypted
   * @param cipherText
   *          The cipher text to be decrypted.
   * @return The plain text obtained by decrypting the cipher text under the
   *         generated key.
   */

  public static String decrypt1(String key, String cipherText)
  {
    byte[] plainText = new byte[cipherText.length()];
    for (byte i = 0; i < plainText.length; i += 1)
    {
      byte row = (byte) (key.charAt(i) - TRANSFORM_UPPER);
      byte col = getColumn(row, (byte) (cipherText.charAt(i) - TRANSFORM_UPPER));
      plainText[i] = (byte) (col + TRANSFORM_UPPER);
    }
    return new String(plainText);
  }

  /**
   * Given the row number and the Vigenere Table entry, find the corresponding
   * column number.
   * 
   * @param row
   *          The row number on which the table entry is located.
   * @param tableEntry
   *          The current Vigenere Table entry.
   * @return The column number at which the current Vigenere Table entry is
   *         located or negative 1 in case of failure.
   */
  private static byte getColumn(byte row, byte tableEntry)
  {
    byte col = 0;
    do
    {
      if (tableEntry == vigenereTable[row][col])
      {
        return col;
      }
      col += 1;
    } while (col < vigenereTable[row].length);
    return -1;
  }

  /**
   * Decrypts cipher text under the key using the Vigenere Table.
   * 
   * @param key
   *          The key under which the cipher text is deccrypted
   * @param cipherText
   *          The cipher text to be decrypted.
   * @return The plain text obtained by decrypting the cipher text under the
   *         generated key.
   */
  public static String decrypt2(String key, String cipherText)
  {
    byte[] plainText = new byte[cipherText.length()];
    for (byte i = 0; i < plainText.length; i += 1)
    {
      byte keyRow = (byte) (key.charAt(i) - TRANSFORM_UPPER);
      byte cipherByte = (byte) (cipherText.charAt(i) - TRANSFORM_UPPER);
      plainText[i] = (byte) (((cipherByte - keyRow + NUMBER_CHARS ) % NUMBER_CHARS) + TRANSFORM_UPPER);
    }
    return new String(plainText);
  }

  /**
   * Print the vigenere table.
   * 
   */
  public static void printVigenereTable()
  {
    for (byte row = 0; row < NUMBER_CHARS; row += 1)
    {
      for (byte col = 0; col < NUMBER_CHARS; col += 1)
      {
        // transforms to ascii upper case character
        System.out.printf("%2s", (char) (vigenereTable[row][col] + TRANSFORM_UPPER));
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Print the key.
   * 
   * @param key
   *          The key used for encryption and decryption.
   */
  public static void printKey(String key)
  {
    System.out.println(key);
  }

  /**
   * Print the plain text (message text).
   * 
   * @param plainText
   *          The plain text (message text).
   */
  public static void printMessage(String plainText)
  {
    System.out.println(plainText);
  }

  /**
   * Print the cipher text.
   * 
   * @param cipherText
   *          The encrypted message.
   */
  public static void printCipher(String cipherText)
  {
    System.out.println(cipherText);
  }

  /**
   * Test method by: Generating and printing Vigenere Table, Generating the key
   * using the keyword, Encrypting a message (plain text), Decrypting the cipher
   * text. Printing the table, key, message, ciphertext & decrypted ciphertext.
   */
  public static void main(String[] args)
  {

    generateVigenereTable();

    String messageText = "MICHIGANTECHNOLOGICALUNIVERSITY";
    String key = generateKey("HOUGHTON", messageText.length());
    String cipherText = encrypt(key, messageText);
    String decrypted = decrypt2(key, cipherText);

    printVigenereTable();
    printKey(key);
    printMessage(messageText);
    printCipher(cipherText);
    printMessage(decrypted);
  }
}
