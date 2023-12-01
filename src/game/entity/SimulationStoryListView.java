package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulationStoryListView extends Entity {
    private List<SimulationCardView> storyCards;

    public SimulationStoryListView(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        fetchStoriesPath();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#56CCF2"));
        g.setFont(new Font("Serif", Font.ITALIC, 24));
        g.drawString("Choose simulation story", x, y);

        g.setColor(Color.decode("#56CCF2"));
        g.fillRect(x, y + 32, width, height);

        g.setColor(Color.white);
        g.fillRect(x + 8, y + 32 + 8, width - 16, height - 16);

        g.setFont(new Font("Serif", Font.ITALIC, 18));
        for (SimulationCardView cardView : storyCards) {
            cardView.draw(g);
        }
    }

    @Override
    public void update() {
        // Currently, there's no update logic needed for this class
    }

    public void fetchStoriesPath() {
        List<String> stories = new ArrayList<>(); // Changed to a local variable

        File file = new File(getClass().getResource("/simulation_stories/stories.txt").getFile());
        try (Scanner sc = new Scanner(file)) { // Using try-with-resources to ensure the scanner is closed
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                stories.add(line.trim());
            }

            storyCards = new ArrayList<>();
            for (String story : stories) { // Removed unused variable 's'
                SimulationCardView card = new SimulationCardView(gp, kh, x + 32, y + 100);
                card.setCardTitle("Test story");
                card.setDescription("This is some test description for our test story");
                storyCards.add(card);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SimulationCardView> getStoryCards() {
        return storyCards;
    }
}
