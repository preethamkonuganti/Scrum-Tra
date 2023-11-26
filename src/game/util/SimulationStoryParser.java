package game.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulationStoryParser {

    private static SimulationStoryParser instance = null;
    private SimulationStoryParser(){
    }

    public static SimulationStoryParser getInstance() {
        if(instance == null)
            instance = new SimulationStoryParser();
        return instance;
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
        File file = new File(getClass().getResource(fPath).getFile());
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
public void parseStringsToSimulationFile(List<String> dialogues, String title){
        File file = new File(getClass().getResource("/simulation_story/"+title+".txt").getFile());
        try {
            if(file.createNewFile()){
                FileWriter fileWriter = new FileWriter("/simulation_story/"+title+".txt");
                BufferedWriter writer = new BufferedWriter(fileWriter);
                for(String d : dialogues){
                    writer.append(d);
                }
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}