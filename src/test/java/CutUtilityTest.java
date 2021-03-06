import cutter.Cutter;
import org.junit.Test;
import parser.Parser;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CutUtilityTest {
    private boolean assertFileContent(File actual, File expected) throws IOException {
        List<String> expectedLines = Files.readAllLines(expected.toPath());
        List<String> actualLines = Files.readAllLines(actual.toPath());
        if (expectedLines.size() != actualLines.size()) return false;
        for (int i = 0; i <= expectedLines.size() - 1; i++) {
            if (!actualLines.get(i).equals(expectedLines.get(i))) return false;
        }
        return true;
    }

    @Test
    public void cut() throws IOException, URISyntaxException {
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "0-2", false, true);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "-6", false, true);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected3.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "-100", false, true);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("input.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "3-", false, true);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected4.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "2-7", false, true);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected6.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "8-16", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected1.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "8-100", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected7.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "-10", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected8.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "-100", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("input.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "8-16", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected1.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "5-", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected9.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "100-", true, false);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected5.txt"))
        );
        new Cutter().cut(getFile("input.txt"), getFile("output.txt"), "100-", false, true);
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected5.txt"))
        );
    }
    @Test
    public void cutUtility() throws IOException, URISyntaxException {
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 0-2").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected.txt"))
        );
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r -4").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected2.txt"))
        );
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r -6").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected3.txt"))
        );
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r -100").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("input.txt"))
        );
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 3-").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected4.txt"))
        );
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 2-7").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected6.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 8-16").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected1.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 8-16").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected1.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 8-100").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected7.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r -10").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected8.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r -100").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("input.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 5-").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected9.txt"))
        );
        Parser.main(("-c -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 100-").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected5.txt"))
        );
        Parser.main(("-w -o " + getFile("output.txt").getAbsolutePath() + " " + getFile("input.txt").getAbsolutePath() +" -r 100-").split(" "));
        assertTrue(
                assertFileContent(getFile("output.txt"), getFile("expected5.txt"))
        );
        String newLine = System.getProperty("line.separator");
        InputStream oldIn = System.in;
        System.setIn(new BufferedInputStream(new FileInputStream("src/test/resources/input.txt")));
        assertEquals("Write text to cut" + newLine + "???????????? ?????????????? ??" + newLine + "???????????? ?????? ????????????" + newLine,
                main(("-w -r -2").split(" ")));
        System.setIn(oldIn);
    }

    private File getFile(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }

    private String main (String[] args) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        PrintStream oldErr = System.err;
        System.setOut(new PrintStream(baos));
        System.setErr(new PrintStream(baos));

        Parser.main(args);

        System.out.flush();
        System.err.flush();
        System.setOut(oldOut);
        System.setErr(oldErr);
        return (baos.toString());
    }
}
