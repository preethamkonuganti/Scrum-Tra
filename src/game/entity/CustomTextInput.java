package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class CustomTextInput extends Entity{

    public static char[] charMAP =  {'A','B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    String value;

    public CustomTextInput(GamePanel gp, KeyHandler kh) {
        super(gp, kh);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.blue);
        g.fill3DRect(x-18,y-36,width+18,48,true);

        g.setColor(Color.WHITE);
        setFont(g);
        g.drawString(value,x,y);
    }

    @Override
    public void update() {
        for(int i = 0; i<26;i++){
            if(kh.characterPressed[i]){
                value += charMAP[i];
            }
        }
    }

    @Override
    public void onClicked() {
        /**
         * start taking keyhandler inputs in update method
         */
    }

    private void setFont(Graphics2D g){
        g.setFont(new Font("Serif", Font.ITALIC, 36));
    }
}