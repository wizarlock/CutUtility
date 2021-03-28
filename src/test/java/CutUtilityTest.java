import cutter.Cutter;
import org.junit.jupiter.api.Test;
import parser.Parser;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CutUtilityTest {
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
    void cut() throws IOException, URISyntaxException {
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
    void cutUtility() throws IOException, URISyntaxException {
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
    }

    private File getFile(String filename) throws URISyntaxException, IOException {
        URI uri = getClass().getResource(filename).toURI();

        if ("jar".equals(uri.getScheme())) {
            for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
                if (provider.getScheme().equalsIgnoreCase("jar")) {
                    try {
                        provider.getFileSystem(uri);
                    } catch (FileSystemNotFoundException e) {
                        provider.newFileSystem(uri, Collections.emptyMap());
                    }
                }
            }
        }
        Path source = Paths.get(uri);
        return source.toFile();
    }
}

