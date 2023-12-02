package game.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulationStoryParser {

    private static SimulationStoryParser instance = null;
    static String path;
    private SimulationStoryParser(){
        File file  = new File("_");
        path  = file.getAbsolutePath();
        System.out.println(path);
        path  = path.substring(0,path.length()-1)+"res";
        System.out.println(path);
    }

    public static SimulationStoryParser getInstance() {
        if(instance == null)
            instance = new SimulationStoryParser();
        return instance;
    }
    public static List<String> parseSim(String fpath) {
        List<String> sim = getInstance().parseFileIntoSequence(path+fpath);
        boolean isConvoOpen = false;
        List<String> res = new ArrayList<>();
        String by = "";
        for (String s : sim) {
            if(s.startsWith("<task")){
                res.add(s);
            }
            else if (s.startsWith("<convo")) {
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
        File file = new File(fPath);
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

    public void parseStringsToSimulationFile(List<String> dialogues, String title){
        File file = new File(title+".txt");
        try {
            file.createNewFile();
                FileWriter fileWriter = new FileWriter(title+".txt");
                BufferedWriter writer = new BufferedWriter(fileWriter);
                for(String d : dialogues){
                    writer.append(d);
                }
                writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}