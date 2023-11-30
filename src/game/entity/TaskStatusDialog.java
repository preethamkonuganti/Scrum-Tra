package game.entity;

import game.GamePanel;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;

/**
 * TaskStatusDialog , ui entity to select task status
 * enables user to change the task status
 */
public class TaskStatusDialog extends Entity {

    private String title;
    private int taskId;
    private int assignedTo;
    private ImageButton closeBtn;

    public TaskStatusDialog(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 300;
        this.height = 180;

        closeBtn = new ImageButton(gp, kh, x + 220, y + 10, 40, 40);
        closeBtn.setBackgroundImage("/assets/back.png");

        closeBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });
    }

    public void setScrumTaskDetails(String title, int taskId, int assignedTo) {
        this.title = title;
        this.taskId = taskId;
        this.assignedTo = assignedTo;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.fillRect(x + 4, y + 4, width - 8, height - 8);

        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.setColor(Color.decode("#5F259F"));
        g.drawString(title, x + 20, y + 24);

        g.drawString("Task status ", x + 20, y + 64);

        closeBtn.draw(g);
    }

    @Override
    public void update() {

    }
}