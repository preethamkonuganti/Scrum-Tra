package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class CheckBox extends Entity{

    String value = "";
    public CheckBox(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g) {
        // logic for box rendering
        g.setColor(Color.GREEN);
        g.drawRect(x, y, 48, 48);

        g.setColor(Color.white);
        g.drawString(value,x+72, y);
    }

    @Override
    public void update() {

    }
}
