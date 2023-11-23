package game.screen;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

/**
 * CreateSimulationScreen - It will enable user to create their own simulation story.
 */
public class CreateSimulationStoryScreen extends Screen{
    public CreateSimulationStoryScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(Color.decode("#5F259F"));
        g.fillRect(10,10,gp.width-20,gp.height-120);

        g.setColor(Color.white);
        g.fillRect(18, 18,gp.width-36, gp.height-156);

    }

    @Override
    public void update() {

    }
}