package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class Player extends ImageButton{

    private String name;
    public Player(GamePanel gp, KeyHandler kh, int x, int y, int width, int height, String name) {
        super(gp, kh, x, y, width, height);
        this.name = name;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC, 18));
        g.drawString(name,x,y+height+20);
    }
}
