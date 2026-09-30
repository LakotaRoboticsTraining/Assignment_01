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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    @DisplayName("Challenge 1: team intro lines")
    void challenge1_printsTeamIntro() {
        List<String> lines = nonEmptyLines(runMain());

        assertTrue(
            lines.size() >= 3,
            "challenge1 failed - print at least 3 lines: team number, your name, and Programming."
        );
        assertTrue(
            lines.stream().anyMatch(line -> line.equals("Programming")),
            "challenge1 failed - The word \"Programming\" was not written (one line must be exactly: Programming)."
        );
    }

    @Test
    @DisplayName("Challenge 2: robot status board")
    void challenge2_printsAtLeastTwoLines() {
        List<String> lines = nonEmptyLines(runMain());

        assertTrue(
            lines.size() >= 5,
            "challenge2 failed - print a status board with at least 2 more lines after Challenge 1 "
                + "(need 5+ non-empty lines total). Your program printed "
                + lines.size() + " non-empty line(s)."
        );
    }

    @Test
    @DisplayName("Challenge 3: Autonomous mode with print + println")
    void challenge3_printsAutonomousMessageUsingPrintAndPrintln() throws IOException {
        String output = runMain();

        assertTrue(
            output.contains("Autonomous mode: starting..."),
            "challenge3 failed - output must include exactly: Autonomous mode: starting..."
        );

        String source = Files.readString(Path.of("src/main/java/Main.java"));
        assertTrue(
            source.contains("System.out.print("),
            "challenge3 failed - use System.out.print(...) for part of the message (not only println)."
        );
        assertTrue(
            source.contains("System.out.println("),
            "challenge3 failed - use System.out.println(...) for part of the message."
        );
        assertFalse(
            source.contains("System.out.println(\"Autonomous mode: starting...\")"),
            "challenge3 failed - do it with two print calls, not one println of the whole message."
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
