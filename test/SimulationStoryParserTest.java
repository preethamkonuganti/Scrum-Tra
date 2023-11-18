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

}
