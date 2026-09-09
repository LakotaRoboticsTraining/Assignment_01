import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void mainPrintsNonEmptyStringToConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outputStream));

            Main.main(new String[]{});

            assertFalse(
                outputStream.toString().trim().isEmpty(),
                "Main should print a non-empty string to the console."
            );
        } finally {
            System.setOut(originalOut);
        }
    }
}
