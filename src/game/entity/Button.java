package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class Button extends Text implements ButtonInterface{

    private Color strokeColor = Color.BLACK;

    public Button(String value, GamePanel gp, KeyHandler kh) {
        super(value, gp, kh);
        width = getStringWidth();
        height = 40;
    }

    @Override
    public void setStrokeColor(Color color) {
        strokeColor = color;
    }

    @Override
    public void onMouseCursorOnButton() {
    }

    @Override
    public void setEnable(boolean isEnabled) {

    }

    @Override
    public void setBackgroundColor(Color color) {
        backGroundColor = color;
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(strokeColor);
        g.fill3DRect(x,y,getStringWidth(),50,false);
        g.setFont(new Font("Serif", Font.ITALIC, 24));
        g.setColor(Color.white);
        g.drawString(value,x+20,y+20);

    }

    public void setPaddings(int s, int e, int t, int b){
        paddingEnd = e;
        paddingStart = s;
        paddingTop = t;
        paddingBottom = b;
    }
}
