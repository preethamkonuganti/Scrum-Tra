package game.entity;

import game.event.KeyHandler;
import game.GamePanel;

import java.awt.*;

public class Text extends Entity {

    String value;

    public Text(String value, GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        this.value = value;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fill3DRect(x-18,y-36,(int)(324*0.8)+18,48,true);

        g.setColor(Color.WHITE);
        setFont(g);
        g.drawString(value,x,y);
    }

    private void setFont(Graphics2D g){
        g.setFont(new Font("Serif", Font.ITALIC, 36));
    }
}
