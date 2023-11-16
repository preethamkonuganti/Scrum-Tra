package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationCardView extends Entity{

    private String cardTitle = "";
    private String description = "";
    private String createdBy = "";
    private int ratings = 0; //star rating out of 5

    private List<String> descToRender;

    public SimulationCardView(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 140;
        this.height = 160;
        descToRender = new ArrayList<>();
    }

    public void setCardTitle(String cardTitle){
        this.cardTitle = cardTitle;
    }

    public void setDescription(String description){
        this.description = description;
        splitDescription();
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x,y,width,height);

        g.setColor(Color.white);
        g.fillRect(x+8, y+8,width-16, height-16);

        g.setColor(Color.blue);
        g.drawString(cardTitle,x+12,y+20);
        int ty = 40;
        for(String d : descToRender){
            g.drawString(d,x+10,y+ty);
            ty += 20;
        }

    }

    @Override
    public void update() {

    }

    private void splitDescription(){
        System.out.println("Len : "+description.length());
        if(description.length() > 17) {
            int dCount = 0;
            String _x = "";
           for(char dc : description.toCharArray()){
               _x += dc;
               dCount += 1;
               if(dCount % 17 == 0){
                   descToRender.add(_x);
                   _x = "";
                   dCount = 0;
               }
           }
           if(!_x.isEmpty())
               descToRender.add(_x);
        }
    }
}
