package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class CustomRadioButton extends Entity{

    private String title;
    private int id;

    private boolean isChecked = false;
    public CustomRadioButton(GamePanel gp, KeyHandler kh, int x, int y, String title) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.height = 40;
        this.title = title;
        this.width = getTitleWidth();
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(Color.decode("#56CCF2"));
        g.drawOval(x+10, y+6, 28, 28);
        //checkbox inner white background

        g.setColor(Color.white);
        setFont(g);
        g.drawString(title,x+56, y+28);

        if(isChecked){
            g.setColor(Color.white);
            g.fillRect(x+15,y+11,18,18); //checked button rendering
        }

        g.setColor(Color.blue);
        g.drawRect(x,y, g.getFontMetrics().stringWidth(title)+64,height);
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
        System.out.println("Toggled");
        if(isChecked){
            isChecked = false;
        }
        else {
            isChecked = true;
        }
    }

    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public boolean isChecked(){
        return isChecked;
    }

    public int getTitleWidth(){
        return (int)((title.length()*31)*0.56);
    }

    private void setFont(Graphics2D g){
        g.setFont(new Font("Serif", Font.ITALIC, 28));
    }
}
