package game.entity;

import game.GamePanel;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;

/**
 * UserSelectionDialog , ui entity to select user for task
 * enables user to select a team member
 */
public class UserSelectionDialog extends Entity{

    private String title;
    private int taskId;
    private int assignedTo;
    private ImageButton closeBtn;

    public UserSelectionDialog(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 300;
        this.height = 180;


        closeBtn = new ImageButton(gp,kh,x+220,y+10,40,40);
        closeBtn.setBackgroundImage("/assets/back.png");

        closeBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.fillRect(x+4, y+4,width-8, height-8);

        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.setColor(Color.decode("#5F259F"));
        g.drawString(title,x+20,y+24);

        g.drawString("Select user ",x+20,y+64);



        closeBtn.draw(g);
    }


    @Override
    public void update() {

    }
}