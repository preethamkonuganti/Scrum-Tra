package game.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpriteParser {

    private static SpriteParser instance = null;
    private SpriteParser(){
    }

    public static SpriteParser getInstance() {
        if(instance == null)
            instance = new SpriteParser();
        return instance;
    }
    public List<String> parseFileIntoSequence(String fPath) {
        File file = new File(getClass().getResource(fPath).getFile());


        ArrayList<String> sequence = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
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