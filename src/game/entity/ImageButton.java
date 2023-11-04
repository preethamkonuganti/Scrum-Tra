package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageButton extends Entity implements ButtonInterface{


    public ImageButton(GamePanel gp, KeyHandler kh,int x, int y,  int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        atk = new BufferedImage[1];
    }

    public void setBackgroundImage(String file){
        try {
            atk[0] = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            System.out.println("Could not set button image : "+e);
        }
    }

    @Override
    public void setStrokeColor(Color color) {

    }

    @Override
    public void onMouseCursorOnButton() {

    }

    @Override
    public void setEnable(boolean isEnabled) {

    }

    @Override
    public void setBackgroundColor(Color color) {

    }

    @Override
    public void setTextColor(Color color) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(atk[spriteIndex],x,y,width,height,null);
    }

    @Override
    public void update() {

    }
}
