package game.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    public JSON parseFileIntoSequence(String fPath) {
        File file = new File(getClass().getResource(fPath).getFile());


        ArrayList<String> sequence = new ArrayList<>();
        Scanner sc = null;

        String res = "";

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                res += line;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return JSON.parseString(res);
    }
}