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
    private int selectedIndex = -1;
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
        g.fillRect(x-10, y-10, width, height);

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
        CustomRadioButton radioButton = new CustomRadioButton(gp, kh, x, y+buttons.size()*60, title, buttons.size());
        buttons.add(radioButton);
        if(width < radioButton.getTitleWidth()+60){
            width  = radioButton.getTitleWidth()+60;
        }
        height += 60;

        radioButton.setOnClickListener(new MouseClickInterface() {
            final int id = buttons.size();
            @Override
            public void onClicked() {
//                System.out.println("clicked "+id);
                selectedIndex = id-1;

                for(int i=0;i< buttons.size();i++){
                    if(i != selectedIndex){
                        buttons.get(i).setChecked(false);
                    }
                }

                System.out.println("Selected  : "+getSelected());
            }
        });
    }

    public String getSelected(){
        if(selectedIndex == -1) {
            return "";
        }
        return buttons.get(selectedIndex).getTitle();
    }

    public int getSelectedIndex(){
        return selectedIndex;
    }

    public void setSelected(int index){
        selectedIndex = index;
        buttons.get(index).setChecked(true);
    }

    @Override
    public void pauseObserver() {
        buttons.forEach(new Consumer<CustomRadioButton>() {
            @Override
            public void accept(CustomRadioButton customRadioButton) {
                customRadioButton.pauseObserver();
            }
        });

        super.pauseObserver();
    }
}