import game.util.SimulationStoryParser;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationStoryParserTest {
    @Test
    public void testParseFileIntoSequence() {
        SimulationStoryParser parser = SimulationStoryParser.getInstance();
        List<String> sequence = parser.parseFileIntoSequence("/res/parseFileToSequence.txt");
        assertEquals("Read the file", sequence.get(0));
    }

    @Test
    public void testParseSimulationStory() {
        try {
            SimulationStoryParser.parseSim("/dialogs_test.txt");
            assertTrue(true);
        } catch (Exception e) {
            fail("Method should not throw an exception");
        }
    }

}
