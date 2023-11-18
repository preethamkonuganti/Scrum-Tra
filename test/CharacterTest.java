import game.entity.Character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class CharacterTest {

    Character character;
    @BeforeEach
    public void setup(){
         character = new Character(null, null,
                100,100,100,100,"/characterTests/test.txt");
    }

    @Test
    public void getAttackImagesTest(){
        BufferedImage atks[] = new BufferedImage[3];
        try {
            atks[0] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_03_Animation_000.png"));
            atks[1] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_03_Animation_001.png"));
            atks[2] = ImageIO.read(getClass().getResourceAsStream("/seller/Seller_03_Animation_002.png"));


            for(int i=0;i<character.getSpriteImages().length;i++){
                BufferedImage img = character.getSpriteImages()[i];
                Assertions.assertArrayEquals(((DataBufferByte) atks[i].getData().getDataBuffer()).getData(),
                        ((DataBufferByte) img.getData().getDataBuffer()).getData());
            }


        } catch (IOException e) {
            fail("Failed to load image");
        }
    }
}
