import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testCaesar() {

        String text = "HELLO";
        int key = 5;

        String encrypted = CryptoManager.caesarEncryption(text, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }

    @Test
    public void testVigenere() {

        String text = "TESTING";
        String key = "KEY";

        String encrypted = CryptoManager.vigenereEncryption(text, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }

    @Test
    public void testPlayfair() {

        String text = "JAVA";
        String key = "SECRET";

        String encrypted = CryptoManager.playfairEncryption(text, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);

        assertEquals(text, decrypted);
    }
}