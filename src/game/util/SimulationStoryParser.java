package game.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class SimulationStoryParser { // Make the class final

    private SimulationStoryParser() {
    }

    // Inner static class for thread-safe, lazy initialization
    private static class Holder {
        private static final SimulationStoryParser INSTANCE = new SimulationStoryParser();
    }

    public static SimulationStoryParser getInstance() {
        return Holder.INSTANCE;
    }

    public static List<String> parseSim(String fpath) {
        List<String> sim = getInstance().parseFileIntoSequence(fpath);
        boolean isConvoOpen = false;
        List<String> res = new ArrayList<>();
        String by = "";
        for (String s : sim) {
            if (s.startsWith("<convo")) {
                by = s.substring(10, s.length() - 1);
                isConvoOpen = true;
                continue;
            } else if (s.startsWith("</convo>")) {
                isConvoOpen = false;
                continue;
            }
            if (isConvoOpen) {
                res.add(by + " > " + s);
            }
        }
        return res;
    }

    public List<String> parseFileIntoSequence(String fPath) {
        File file = new File(getClass().getResource(fPath).getFile());
        List<String> sequence = new ArrayList<>(); // Use List instead of ArrayList

        // Try-with-resources for Scanner
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sequence.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return sequence;
    }
}
