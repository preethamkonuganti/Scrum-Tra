import game.GamePanel;
import game.entity.SimulationCardView;
import game.entity.SimulationStoryListView;
import game.event.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MockGamePanel extends GamePanel {
}

class MockKeyHandler extends KeyHandler {
}

class SimulationStoryListViewTest {

    private SimulationStoryListView simulationStoryListView;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        MockGamePanel mockGamePanel = new MockGamePanel(/* parameters if needed */);
        MockKeyHandler mockKeyHandler = new MockKeyHandler(/* parameters if needed */);

        // Assuming your SimulationStoryListView fetches files using a classpath-relative path
        File classpathRoot = new File(tempDir.toFile(), "classes");
        classpathRoot.mkdir();
        File simulationStoriesDir = new File(classpathRoot, "simulation_stories");
        simulationStoriesDir.mkdir();

        // Modify the system classloader to include our temporary directory
        System.setProperty("java.class.path", tempDir.toAbsolutePath().toString());

        simulationStoryListView = new SimulationStoryListView(mockGamePanel, mockKeyHandler, 0, 0, 100, 100);
    }

    @Test
    void testFetchStoriesPathWithValidFile() throws IOException {
        File storiesFile = new File(new File(tempDir.toFile(), "classes/simulation_stories"), "stories.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storiesFile))) {
            writer.write("Story1\nStory2\nStory3");
        }
        simulationStoryListView.fetchStoriesPath();

        List<SimulationCardView> storyCards = simulationStoryListView.getStoryCards();
        assertNotNull(storyCards);
        assertEquals(1, storyCards.size());
    }

//    @Test
//    void testFetchStoriesPathWithNonExistentFile() {
//
//        Exception exception = assertThrows(RuntimeException.class, simulationStoryListView::fetchStoriesPath);
//        assertTrue(exception.getCause() instanceof FileNotFoundException);
//    }
}
