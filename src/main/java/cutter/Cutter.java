package cutter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cutter {


    private static List<String> cutText(List<String> list, String range, boolean cKey, boolean wKey) {
        String[] values = range.split("-");
        List<String> newText = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        if (cKey) {
            if (range.charAt(0) == '-') {
                for (String line : list) {
                    for (int i = 0; i <= Integer.parseInt(range.replace("-", "")); i++) {
                        newLine.append(line.charAt(i));
                        if (i == line.length() - 1) break;
                    }
                    newText.add(newLine.toString());
                    newLine.setLength(0);

                }
            } else if (range.charAt(range.length() - 1) == '-') {
                for (String line : list) {
                    for (int i = Integer.parseInt(values[0]); i <= line.length() - 1; i++)
                        newLine.append(line.charAt(i));
                    newText.add(newLine.toString());
                    newLine.setLength(0);
                }
            } else {
                for (String line : list) {
                    for (int i = Integer.parseInt(values[0]); i <= Integer.parseInt(values[1]); i++) {
                        newLine.append(line.charAt(i));
                        if (i == line.length() - 1) break;
                    }
                    newText.add(newLine.toString());
                    newLine.setLength(0);
                }
            }
        }
        if (wKey) {
            if (range.charAt(0) == '-') {
                for (String line : list) {
                    String[] words = line.split(" ");
                    for (int i = 0; i <= Integer.parseInt(range.replace("-", "")); i++) {
                        newLine.append(words[i]).append(" ");
                        if (i == words.length - 1) break;
                    }
                    newText.add(newLine.toString().trim());
                    newLine.setLength(0);
                }
            } else if (range.charAt(range.length() - 1) == '-') {
                for (String line : list) {
                    String[] words = line.split(" ");
                    for (int i = Integer.parseInt(values[0]); i <= words.length - 1; i++)
                        newLine.append(words[i]).append(" ");
                    newText.add(newLine.toString().trim());
                    newLine.setLength(0);
                }
            } else {
                for (String line : list) {
                    String[] words = line.split(" ");
                    for (int i = Integer.parseInt(values[0]); i <= Integer.parseInt(values[1]); i++) {
                        newLine.append(words[i]).append(" ");
                        if (i == words.length - 1) break;
                    }
                    newText.add(newLine.toString().trim());
                    newLine.setLength(0);
                }
            }
        }
        return newText;
    }

    public static void cut(String inputName, String outputName, String range, boolean cKey, boolean wKey) throws IOException {
        if (inputName == null) {
            List<String> listOfString = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            System.out.println("Write text to cut");
            while (in.hasNext()) listOfString.add(in.nextLine());
            List<String> newText = cutText(listOfString, range, cKey, wKey);

            if (outputName != null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));
                for (String line : newText) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
                writer.close();
            } else for (String line : newText) System.out.println(line);

        } else {
            List<String> newText = cutText(Files.readAllLines(Paths.get(inputName)), range,cKey, wKey);
            if (outputName != null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));
                for (String line : newText) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
                writer.close();
            } else for (String line : newText) System.out.println(line);
        }
    }
    public static void main(String[] arguments) throws IOException {
        cut (null, null, "3-", false, true);
    }
}


