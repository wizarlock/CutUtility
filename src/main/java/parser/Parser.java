package parser;
import cutter.Cutter;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

public class Parser {
    @Option(name = "-c", usage = "Indentation in characters", forbids = "-w")
    public boolean cKey = false;
    @Option(name = "-w", usage = "Indentation in words", forbids = "-c")
    public boolean wKey = false;
    @Option(name = "-o", usage = "Output File")
    public File outputFile;
    @Option (name = "-r", usage = "Required range")
    public String range;
    @Argument
    public File inputFile;


    public static void main(String[] arguments) throws IOException {
        new Parser().parseArguments(arguments);
    }

    public void parseArguments(String[] arguments) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(arguments);
            if ((range.isEmpty()) || (!wKey && !cKey) || !range.matches("\\d*-\\d*") || range.length() == 1)
                throw new IllegalArgumentException("The entered data is not satisfactory");
        } catch (IllegalArgumentException | CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar cut.jar [-c|-w] [-o ofile] [file] [-r range]");
            parser.printUsage(System.err);
            return;
        }
            new Cutter().cut(inputFile, outputFile, range, cKey, wKey);
    }
}
