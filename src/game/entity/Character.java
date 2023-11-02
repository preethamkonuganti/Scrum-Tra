package game.entity;

import game.util.SpriteParser;
import game.event.KeyHandler;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class Character extends Entity {

    int spriteMax = 0;

    public Character(GamePanel gp, KeyHandler kh, int x, int y, String spritePath) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        atk = new BufferedImage[10];
        getAttackImgs(spritePath);
    }

    public Character(GamePanel gp, KeyHandler kh, int x, int y, int width, int height, String spritePath) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        getAttackImgs(spritePath);
    }

    @Override
    public void update() {

        spriteCounter += 1;
        if (spriteCounter > spriteMax) {
            spriteIndex += 1;
            if (spriteIndex > spriteMax - 1) {
                spriteIndex = 0;
            }
            spriteCounter = 0;
        }
    }

    @Override
    public void draw(Graphics2D g) {

        g.drawImage(atk[spriteIndex], x, y, width, height, null);
    }

    private void getAttackImgs(String spritePath) {
        try {

            SpriteParser parser = SpriteParser.getInstance();
            List<String> paths = parser.parseFileIntoSequence(spritePath);
            spriteMax = paths.size();

            atk = new BufferedImage[paths.size()];
            int i = 0;
            for (String s : paths) {
                atk[i] = ImageIO.read(getClass().getResourceAsStream(s));
                i++;
            }

            if (this.height == 0 && this.width == 0) {
                this.width = atk[0].getWidth() / 8;
                this.height = atk[0].getHeight() / 8;
            }

            System.out.println("WIDTH = " + width);

        } catch (IOException e) {

        }

    }

}