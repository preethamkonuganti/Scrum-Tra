package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class CheckBox extends Entity{

    private String title = "";
    private boolean isChecked = false;

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
        g.fillRect(x+2,y+2,44,44); //checkbox inner white background
        g.setColor(Color.white);
        g.drawString(title,x+72, y);
        if(isChecked){
            g.setColor(Color.green);
            g.fillRect(x+10,y+10,28,28); //checked button rendering
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void onClicked() {
        toggleCheck();
        super.onClicked();
    }

    private void toggleCheck() {
        if(isChecked){
            isChecked = false;
        }
        else {
            isChecked = true;
        }
    }

}