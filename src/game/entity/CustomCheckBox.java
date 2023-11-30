package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class CustomCheckBox extends Entity{

    private String title = "Test checkbox";
    private boolean isChecked = false;

    public CustomCheckBox(GamePanel gp, KeyHandler kh, int x, int y, String title) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.height = 40;
        this.width = getTitleWidth();
        this.title = title;
    }

    @Override
    public void draw(Graphics2D g) {

        // logic for box rendering
        g.setColor(Color.decode("#56CCF2"));
        g.drawRect(x, y, 28, 28);
        //checkbox inner white background

        g.setColor(Color.white);
        setFont(g);
        g.drawString(title,x+44, y+24);

        if(isChecked){
            g.setColor(Color.white);
            g.fillRect(x+5,y+5,18,18); //checked button rendering
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
