package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class SimulationCardView extends Entity{
    public SimulationCardView(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x,y,width,height);

        g.setColor(Color.white);
        g.fillRect(x+16, y+16,width-32, height-32);

    }

    @Override
    public void update() {

    }
}
