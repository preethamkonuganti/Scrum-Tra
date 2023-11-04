package game.entity;

import game.event.KeyHandler;
import game.GamePanel;

import java.awt.*;

public class Text extends Entity {

    String value;
    int fontSize = 36;

    String fontFamily = "Serif";

    public Text(String value, GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        this.value = value;
        width = getTextWidth();
    }


    public String getValue() {
        return value;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fill3DRect(x-18,y-36,width+18,height,true);

        g.setColor(Color.WHITE);
        setFont(g);
        g.drawString(value,x,y);
    }

    private void setFont(Graphics2D g){
        g.setFont(new Font(fontFamily, Font.ITALIC, fontSize));
    }

    private int getTextWidth(){
        return (int)(value.length()*fontSize*0.5);
    }

    public void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public int getStringWidth(){
        return (int)((value.length()*36)*0.56);
    }
}
