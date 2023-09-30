import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.runners.Parameterized.Parameter;
//import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

public class CaesarTests {
    @ParameterizedTest
    @CsvSource(value = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ:KLMNOPQRSTUVWXYZABCDEFGHIJ", "abcdefghijklmnopqrstuvwxyz:klmnopqrstuvwxyzabcdefghij",
            "syfxuhjunj:ciphertext", "huikbj:result"}, delimiter = ':')
    public void toCipherTest(String input, String expected) {
        // testing encryption and decryption
        Caesar c = new Caesar();
        c.setCaesar(10);
        String cipher_text = c.encrypt(input);
        Assertions.assertEquals(expected, cipher_text);
        String decipher_text = c.decrypt(cipher_text);
        Assertions.assertEquals(input, decipher_text);
    }

    @Test
    public void exceptionTest(){
        // testing if an exception is thrown when an integer not between 1 and 25 is given
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Caesar(26);
        });

        String expectedMessage = "the number has to be between 1 and 25!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
