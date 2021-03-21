import cutter.Cutter;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CutUtilityTest {
    private void assertFileContent(String name, String expectedContent) throws IOException {
        List<String> content = Files.readAllLines(Paths.get(name));
        List<String> lines = new ArrayList<>(content);
        List<String> newContent = Files.readAllLines(Paths.get(expectedContent));
        List<String> newLines = new ArrayList<>(newContent);
        assertEquals(lines, newLines);
    }

    @Test
    void cut() throws IOException {
        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "0-2", false, true);
        assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected.txt");

        Cutter.cut("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\input\\input.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt", "8-16", true, false);
        assertFileContent("C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\output\\output.txt","C:\\Users\\Виталий\\IdeaProjects\\CutUtility\\expected\\expected1.txt");
    }
    }

