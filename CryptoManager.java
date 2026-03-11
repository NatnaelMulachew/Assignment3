public class CryptoManager {

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    private static final String ALPHABET64 =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";


    public static boolean isStringInBounds(String text) {

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (c < LOWER_RANGE || c > UPPER_RANGE)
                return false;
        }

        return true;
    }


    /* =======================
       Caesar Cipher
       ======================= */

    public static String caesarEncryption(String plainText, int key) {

        if (!isStringInBounds(plainText))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < plainText.length(); i++) {

            result += shiftChar(plainText.charAt(i), key);
        }

        return result;
    }


    public static String caesarDecryption(String encryptedText, int key) {

        if (!isStringInBounds(encryptedText))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < encryptedText.length(); i++) {

            result += shiftChar(encryptedText.charAt(i), -key);
        }

        return result;
    }


    /* =======================
       Vigenere Cipher
       ======================= */

    public static String vigenereEncryption(String plainText, String key) {

        if (!isStringInBounds(plainText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < plainText.length(); i++) {

            char p = plainText.charAt(i);
            char k = key.charAt(i % key.length());

            int shift = k - LOWER_RANGE;

            result += shiftChar(p, shift);
        }

        return result;
    }


    public static String vigenereDecryption(String encryptedText, String key) {

        if (!isStringInBounds(encryptedText) || !isStringInBounds(key))
            return "The selected string is not in bounds, Try again.";

        String result = "";

        for (int i = 0; i < encryptedText.length(); i++) {

            char e = encryptedText.charAt(i);
            char k = key.charAt(i % key.length());

            int shift = k - LOWER_RANGE;

            result += shiftChar(e, -shift);
        }

        return result;
    }


    /* =======================
       Playfair Cipher
       ======================= */

    public static String playfairEncryption(String plainText, String key) {

        if (!isStringInBounds(plainText))
            return "The selected string is not in bounds, Try again.";

        if (plainText.length() % 2 != 0)
            plainText += "X";

        return plainText;
    }


    public static String playfairDecryption(String encryptedText, String key) {

        if (!isStringInBounds(encryptedText))
            return "The selected string is not in bounds, Try again.";

        if (encryptedText.endsWith("X"))
            encryptedText = encryptedText.substring(0, encryptedText.length() - 1);

        return encryptedText;
    }


    /* =======================
       Helper Method
       ======================= */

    private static char shiftChar(char c, int key) {

        int value = c - LOWER_RANGE;

        int shifted = (value + key) % RANGE;

        if (shifted < 0)
            shifted += RANGE;

        return (char) (shifted + LOWER_RANGE);
    }

}