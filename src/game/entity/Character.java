package game.entity;

import game.event.KeyHandler;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Character extends Entity{


    public Character(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        atk  = new BufferedImage[10];
        getAttackImgs();
    }

    @Override
    public void update() {

        spriteCounter+=2;
        if(spriteCounter > 10){
            spriteIndex += 1;
            if(spriteIndex >9){
                spriteIndex = 0;
            }
            spriteCounter = 0;
        }
    }


    @Override
    public void draw(Graphics2D g) {

        g.drawImage(atk[spriteIndex],x,y,525,275,null);
    }

    private void getAttackImgs(){
        try {
//            atk[0] = ImageIO.read(getClass().getResourceAsStream("/attack/tile000.png"));
//            atk[1] = ImageIO.read(getClass().getResourceAsStream("/attack/tile001.png"));
//            atk[2] = ImageIO.read(getClass().getResourceAsStream("/attack/tile002.png"));
//            atk[3] = ImageIO.read(getClass().getResourceAsStream("/attack/tile003.png"));
//            atk[4] = ImageIO.read(getClass().getResourceAsStream("/attack/tile004.png"));


            atk[0] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_000.png"));
            atk[1] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_001.png"));
            atk[2] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_002.png"));
            atk[3] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_003.png"));
            atk[4] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_004.png"));

            atk[5] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_005.png"));
            atk[6] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_006.png"));
            atk[7] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_007.png"));
            atk[8] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_008.png"));
            atk[9] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_01_Animation_009.png"));

        } catch (IOException e) {

        }


    }

    public void add(double x){

    }

}
