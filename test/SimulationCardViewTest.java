import game.GamePanel;
import game.entity.SimulationCardView;
import game.event.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationCardViewTest {

    private SimulationCardView simulationCardView;
    private GamePanel gp; // Mock or create a real instance as required
    private KeyHandler kh; // Mock or create a real instance as required

    @BeforeEach
    public void setUp() {
        simulationCardView = new SimulationCardView(gp, kh, 0, 0);
    }



    @Test
    public void testSplitDescription() throws NoSuchFieldException, IllegalAccessException {
        String description = "This is a long description that should be split into multiple parts.";
        simulationCardView.setDescription(description);
        Field field = SimulationCardView.class.getDeclaredField("descToRender");
        field.setAccessible(true);
        List<String> descToRender = (List<String>) field.get(simulationCardView);
        assertEquals("This is a long de",descToRender.get(0));
    }

    @Test
    public void testSplitDescriptionForExpectedNumberOfLines() throws NoSuchFieldException, IllegalAccessException {
        String description = "This is a long description that should be split into multiple parts.";
        simulationCardView.setDescription(description);
        Field field = SimulationCardView.class.getDeclaredField("descToRender");
        field.setAccessible(true);
        List<String> descToRender = (List<String>) field.get(simulationCardView);
        assertEquals(descToRender.size(),4);
    }
}