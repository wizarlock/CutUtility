import cutter.Cutter;
import org.junit.jupiter.api.Test;
import parser.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class CutUtilityTest {
    private boolean assertFileContent(String actual, String expected) throws IOException {
        List<String> expectedLines = Files.readAllLines(Paths.get(expected));
        List<String> actualLines = Files.readAllLines(Paths.get(actual));
        if (expectedLines.size() != actualLines.size()) return false;
        for (int i = 0; i <= expectedLines.size() - 1; i++) {
            if (!actualLines.get(i).equals(expectedLines.get(i))) return false;
        }
        return true;
    }

    @Test
    void cut() throws IOException {
        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "0-2", false, true);
        assertTrue(
        assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "-4", false, true);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected2.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "-6", false, true);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected3.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "-100", false, true);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "3-", false, true);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected4.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "2-7", false, true);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected6.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "8-16", true, false);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected1.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "8-100", true, false);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected7.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "-10", true, false);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected8.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "-100", true, false);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "5-", true, false);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected9.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "100-", false, true);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected5.txt"));

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "100-", true, false);
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected5.txt"));
    }
    @Test
    void cutUtility() throws IOException {
        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 0-2".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected.txt"));

        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r -4".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected2.txt"));

        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r -6".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected3.txt"));

        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r -100".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt"));

        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 3-".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected4.txt"));

        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 2-7".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected6.txt"));

        Parser.main("-c -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 8-16".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected1.txt"));

        Parser.main("-c -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 8-100".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected7.txt"));

        Parser.main("-c -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r -10".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected8.txt"));

        Parser.main("-c -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r -100".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt"));

        Parser.main("-c -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 5-".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected9.txt"));

        Parser.main("-w -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 100-".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected5.txt"));

        Parser.main("-c -o C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt -r 100-".split(" "));
        assertTrue(
                assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected5.txt"));
    }
    }

