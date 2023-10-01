
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarTests {
    @ParameterizedTest
    @CsvSource(value = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ:KLMNOPQRSTUVWXYZABCDEFGHIJ", "abcdefghijklmnopqrstuvwxyz:klmnopqrstuvwxyzabcdefghij",
            "syfxuhjunj:ciphertext", "huikbj:result"}, delimiter = ':')
    // testing encryption and decryption
    public void toCipherTest(String input, String expected) {
        Caesar c = new Caesar();
        c.setKey(10);
        String cipher_text = c.encrypt(input);
        Assertions.assertEquals(expected, cipher_text);
        String decipher_text = c.decrypt(cipher_text);
        Assertions.assertEquals(input, decipher_text);

    }

    @Test
    // testing if an exception is thrown when an integer not between 1 and 25 is given
    public void notValidKeyTest(){
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Caesar(0);
        });

        String expectedMessage1 = "the number has to be between 1 and 25!";
        String actualMessage1 = exception1.getMessage();

        Assertions.assertTrue(actualMessage1.contains(expectedMessage1));

        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Caesar(26);
        });

        String expectedMessage2 = "the number has to be between 1 and 25!";
        String actualMessage2 = exception1.getMessage();

        Assertions.assertTrue(actualMessage2.contains(expectedMessage2));
    }

    @Test
    public void notAlphabetTest(){
        Caesar c = new Caesar(15);
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String s = c.encrypt("123");
        });

        String expectedMessage1 = "Not English alphabet!";
        String actualMessage1 = exception1.getMessage();

    }
}
