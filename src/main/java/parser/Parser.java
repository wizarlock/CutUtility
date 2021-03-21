package parser;
import cutter.Cutter;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.IOException;

public class Parser {
    @Option(name = "-c", usage = "Indentation in characters")
    public boolean cKey = false;
    @Option(name = "-w", usage = "Indentation in words")
    public boolean wKey = false;
    @Option(name = "-o", usage = "Output File")
    public String outputFile;
    @Option (name = "-r", usage = "Required range")
    public String range;
    @Argument
    public String inputFile;


    public static void main(String[] arguments) {
        new parser.Parser().parseArguments(arguments);
    }

    public void parseArguments(String[] arguments) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(arguments);
            if ((inputFile.isEmpty() || range.isEmpty()) || (!wKey && !cKey)) {
                System.err.println("java -jar cut.jar cut [-c|-w] [-o ofile] [file] [-r range]");
                parser.printUsage(System.err);
            }
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar cut.jar cut [-c|-w] [-o ofile] [file] [-r range]");
            parser.printUsage(System.err);
            return;
        }
        try {
            Cutter.cut(inputFile, outputFile, range, wKey, cKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
