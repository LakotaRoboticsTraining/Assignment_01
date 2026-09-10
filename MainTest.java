import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void challenge1_printsTeamIntro() {
        List<String> lines = nonEmptyLines(runMain());

        assertTrue(
            lines.size() >= 3,
            "Challenge 1: print three lines — team number, your name, and Programming."
        );
        assertTrue(
            lines.stream().anyMatch(line -> line.equals("Programming")),
            "Challenge 1: one of the lines must be exactly: Programming"
        );
    }

    @Test
    void challenge2_printsAtLeastTwoLines() {
        List<String> lines = nonEmptyLines(runMain());

        // Challenge 1 is 3 lines; require at least 2 more for the status board.
        assertTrue(
            lines.size() >= 5,
            "Challenge 2: print a status board with at least two lines "
                + "(in addition to Challenge 1's three lines)."
        );
    }

    @Test
    void challenge3_printsAutonomousMessageUsingPrintAndPrintln() throws IOException {
        String output = runMain();

        assertTrue(
            output.contains("Autonomous mode: starting..."),
            "Challenge 3: output must include: Autonomous mode: starting..."
        );

        String source = Files.readString(Path.of("Main.java"));
        assertTrue(
            source.contains("System.out.print("),
            "Challenge 3: use System.out.print(...) for part of the message."
        );
        assertTrue(
            source.contains("System.out.println("),
            "Challenge 3: use System.out.println(...) for part of the message."
        );
        assertFalse(
            source.contains("System.out.println(\"Autonomous mode: starting...\")"),
            "Challenge 3: do it with two print calls (not one println of the whole message)."
        );
    }

    private static String runMain() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outputStream));
            Main.main(new String[] {});
            return outputStream.toString();
        } finally {
            System.setOut(originalOut);
        }
    }

    private static List<String> nonEmptyLines(String output) {
        return Arrays.stream(output.split("\\R"))
            .map(String::trim)
            .filter(line -> !line.isEmpty())
            .collect(Collectors.toList());
    }
}
