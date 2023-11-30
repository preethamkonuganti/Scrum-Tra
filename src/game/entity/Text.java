package game.entity;

import game.event.KeyHandler;
import game.GamePanel;

import java.awt.*;

public class Text extends Entity {

    String value;

    Color textColor = Color.black;

    protected Color backGroundColor = Color.white;
    protected int paddingStart = 18;
    protected int paddingEnd = 18;
    protected int paddingTop = 6;
    protected int paddingBottom = 6;


    public Text(String value, GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        this.value = value;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        drawBackGround(g);
        drawText(g);
    }

    protected void drawBackGround(Graphics2D g) {
        g.setColor(backGroundColor);
        g.fillRect(x-paddingStart,y-36,getStringWidth()+paddingEnd,36+paddingBottom+paddingTop);
    }

    private void setFont(Graphics2D g){
        g.setFont(new Font("Serif", Font.ITALIC, 36));
    }

    public void setTextColor(Color color){
        textColor = color;
    }

    protected void drawText(Graphics2D g){
        g.setColor(textColor);
        setFont(g);
        g.drawString(value,x,y);
    }

    public int getStringWidth(){
        return (int)((value.length()*31)*0.56);
    }
}
