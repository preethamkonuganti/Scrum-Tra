package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class CustomTextInput extends Entity{

    public static char[] charMAP =  {'A','B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    String value = "";
    String finalVal = "";

    public String hint = "";

    public CustomTextInput(GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        width = 280;
        height = 48;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#55ACEE"));
        g.fill3DRect(x-18,y-36,width+18,48,true);


        filter();
        if(finalVal.isEmpty() )
        {
            g.setColor(Color.red);
            g.setFont(new Font("Serif", Font.ITALIC, 24));
            g.drawString(hint,x,y);
        }
        else {
            g.setColor(Color.WHITE);
            setFont(g);
            g.drawString(finalVal, x, y);
        }
    }

    @Override
    public void update() {
        for(int i = 0; i<26;i++){
            if(kh.characterPressed[i]){
                System.out.println(charMAP[i]);
                value += charMAP[i];
            }
        }
    }

    private void setFont(Graphics2D g){
        g.setFont(new Font("Serif", Font.ITALIC, 36));
    }

    private void filter(){
        if(value.length()<2)
            return;
        finalVal = ""+value.charAt(0);
        for(int i = 1;i<value.length();i++){
            if(value.charAt(i-1) != value.charAt(i))
                finalVal += value.charAt(i);
        }
    }
}