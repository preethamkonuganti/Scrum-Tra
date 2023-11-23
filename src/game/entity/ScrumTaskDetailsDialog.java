package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

/**
 * ScrumTaskDetailsDialog , ui entity to show details of a scrum task on task board
 * enables user to assign task to a team member
 * enables user to change the task status
 */
public class ScrumTaskDetailsDialog extends Entity{


    public ScrumTaskDetailsDialog(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setScrumTaskDetails(){

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.fillRect(x+4, y+4,width-8, height-8);
    }

    @Override
    public void update() {

    }
}