package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

/**
 * RadioGroup entity, provides radio buttons to select one answer among the given choices.
 */
public class RadioGroup extends Entity{

    private String title;
    public RadioGroup(GamePanel gp, KeyHandler kh, int x, int y, int width, int height, String title) {
        super(gp, kh);
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.title = title;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.fillRect(x+4, y+4,width-8, height-8);
    }

    @Override
    public void update() {

    }
}
