import game.util.SimulationStoryParser;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationStoryParserTest {
    @Test
    public void testParseFileIntoSequence() {
        try {
            SimulationStoryParser parser = SimulationStoryParser.getInstance();
            parser.parseFileIntoSequence("/dialogs_test.txt");
            assertTrue(true);
        } catch (Exception e) {
            fail("Method should not throw an exception");
        }
    }

    @Test
    public void testParseSimulationStory() {
        try {
            SimulationStoryParser parser = SimulationStoryParser.getInstance();
            parser.parseSim("/dialogs_test.txt");
            assertTrue(true);
        } catch (Exception e) {
            fail("Method should not throw an exception");
        }
    }
@Test
    public void testParseStoryToSimulationFile(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Testing 1");
        strings.add("Testing 2");
        strings.add("Testing 3");
        strings.add("Testing 4");
        strings.add("Testing 5");
        strings.add("Testing 6");

        try{
            SimulationStoryParser.getInstance().parseStringsToSimulationFile(strings,"test");
            File file = new File("test.txt");
            if(!file.exists()){
                fail("File creation failed");
            }
            else{
                ArrayList<String> sequence = new ArrayList<>();
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    sequence.add(line.trim());
                }


            }
        } catch (FileNotFoundException e) {
            fail("File creation failed.");
        }

    }

}
