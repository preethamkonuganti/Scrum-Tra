package game.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class SpriteParser { // Make the class final

    // Private constructor to prevent instantiation
    private SpriteParser() {
    }

    // Inner static class for thread-safe, lazy initialization of the instance
    private static class Holder {
        static final SpriteParser INSTANCE = new SpriteParser();
    }

    // Public method to get the instance
    public static SpriteParser getInstance() {
        return Holder.INSTANCE;
    }

    public List<String> parseFileIntoSequence(String fPath) {
        File file = new File(getClass().getResource(fPath).getFile());
        List<String> sequence = new ArrayList<>(); // Use List instead of ArrayList

        // Try-with-resources for automatic resource management
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sequence.add(line.trim());
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return sequence;
    }
}
