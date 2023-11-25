package game.entity;

import game.GamePanel;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * RadioGroup entity, provides radio buttons to select one answer among the given choices.
 */
public class RadioGroup extends Entity{

    private ArrayList<CustomRadioButton> buttons;
    public RadioGroup(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        width = height = 0;
        buttons = new ArrayList<CustomRadioButton>();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

//        g.setColor(Color.white);
//        g.fillRect(x+4, y+4,width-8, height-8);

        buttons.forEach(new Consumer<CustomRadioButton>() {
            @Override
            public void accept(CustomRadioButton customRadioButton) {
                customRadioButton.draw(g);
            }
        });
    }

    @Override
    public void update() {

    }

    public void addOption(String title){
        CustomRadioButton radioButton = new CustomRadioButton(gp, kh, x, y+buttons.size()*60, title);
        buttons.add(radioButton);
        if(width < radioButton.getTitleWidth()){
            width  = radioButton.getTitleWidth();
        }
        height += 60;
        radioButton.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                System.out.println();
            }
        });
    }
}
