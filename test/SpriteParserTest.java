import game.util.SimulationStoryParser;
import game.util.SpriteParser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SpriteParserTest {

    @Test
    public void testSingletonInstance() {
        SpriteParser firstInstance = SpriteParser.getInstance();
        SpriteParser secondInstance = SpriteParser.getInstance();
        assertSame(firstInstance, secondInstance);
    }

    @Test
    public void testParseFileIntoSequence() {
        SpriteParser parser = SpriteParser.getInstance();
        List<String> sequence = parser.parseFileIntoSequence("/res/parseFileToSequence.txt");
        assertEquals("Read the file", sequence.get(0));
    }

}