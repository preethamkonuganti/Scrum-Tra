package game.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class SpriteParser { // Make the class final

    // Private constructor to prevent instantiation

    String path;
    private SpriteParser() {
        File file  = new File("_");
        path  = file.getAbsolutePath();
        System.out.println(path);
        path  = path.substring(0,path.length()-1)+"res";
    }

    // Inner static class for thread-safe, lazy initialization of the instance
    private static class Holder {
        static final SpriteParser INSTANCE = new SpriteParser();
    }

    // Public method to get the instance
    public static SpriteParser getInstance() {
        return Holder.INSTANCE;
    }

    public static List<String> parseSim(String fpath){
        List<String> sim = getInstance().parseFileIntoSequence(fpath);
        boolean isConvoOpen = false;
        List<String> res = new ArrayList<>();
        String by = "";
        for(String s : sim){
            if(s.startsWith("<convo")){
                by = s.substring(10,s.length()-1);
                isConvoOpen = true;
                continue;
            }
            else if(s.startsWith("</convo>")){
                isConvoOpen = false;
                continue;
            }
            if(isConvoOpen){
                res.add(by + " > "+s);
            }
        }
        return res;
    }

    public List<String> parseFileIntoSequence(String fPath) {
        File file = new File(path+fPath);
        ArrayList<String> sequence = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
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