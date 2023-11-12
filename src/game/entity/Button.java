package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class Button extends Text implements ButtonInterface{

    private Color strokeColor = Color.BLACK;

    public Button(String value, GamePanel gp, KeyHandler kh) {
        super(value, gp, kh);
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
    public void setTextColor(Color color) {

    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(strokeColor);
        g.fill3DRect(x-paddingStart-4,y-36-4,getStringWidth()+paddingEnd+8,36+paddingBottom+paddingTop+8,false);

        super.draw(g);
    }

    public void setPaddings(int s, int e, int t, int b){
        paddingEnd = e;
        paddingStart = s;
        paddingTop = t;
        paddingBottom = b;
    }
}