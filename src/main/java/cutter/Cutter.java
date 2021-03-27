package cutter;
import java.io.*;
import java.util.*;

public class Cutter {
    private int startRange;
    private int endRange;

    private void parseRange(String range) {
        String[] values = range.split("-");
        if (range.charAt(0) == '-') {
            this.startRange = 0;
            this.endRange = Integer.parseInt(range.replace("-", ""));
        } else if (range.charAt(range.length() - 1) == '-') {
            this.startRange = Integer.parseInt(values[0]);
            this.endRange = Integer.MAX_VALUE;
        } else {
            this.startRange = Integer.parseInt(values[0]);
            this.endRange = Integer.parseInt(values[1]);
        }
    }

    private String cutLine(String line, String range, boolean cKey, boolean wKey) {
        parseRange(range);
        StringBuilder newLine = new StringBuilder();
        if (cKey && !wKey) {
            if (endRange == Integer.MAX_VALUE || endRange > line.length() - 1) endRange = line.length() - 1;
            for (int i = startRange; i <= endRange; i++) newLine.append(line.charAt(i));
            return newLine.toString();
        } else {
            String[] words = line.split(" ");
            if (endRange == Integer.MAX_VALUE || endRange > words.length - 1) endRange = words.length - 1;
            for (int i = startRange; i <= endRange; i++) newLine.append(words[i]).append(" ");
            return newLine.toString().trim();
        }
    }

    public void cut(File inputFile, File outputFile, String range, boolean cKey, boolean wKey) throws IOException {
        String newLine;
        List<String> newText = new ArrayList<>();
        if (inputFile == null) {
            Scanner in = new Scanner(System.in);
            System.out.println("Write text to cut");
            while (in.hasNext()) {
                newLine = cutLine(in.nextLine(), range, cKey, wKey);
                newText.add(newLine);
            }
        } else {
            String oldLine;
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                while ((oldLine = reader.readLine()) != null) {
                    newLine = cutLine(oldLine, range, cKey, wKey);
                    newText.add(newLine);
                }
            }
        }
        if (outputFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String line : newText) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } else for (String line : newText) System.out.println(line);
    }
}


