package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class SimulationCardView extends Entity{

    private String cardTitle;
    private String description;
    private String createdBy;

    private int ratings; //star rating out of 5

    public SimulationCardView(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setCardTitle(String cardTitle){
        this.cardTitle = cardTitle;
    }

    public void setDescription(String description){
        this.description = description;
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
        g.fillRect(x+16, y+16,width-32, height-32);

        g.setColor(Color.blue);
        g.drawString(cardTitle,x+20,y+20);
        g.drawString(description,x+18,y+44);

    }

    @Override
    public void update() {

    }
}
