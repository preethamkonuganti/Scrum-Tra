package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationCardView extends Entity {

    private String cardTitle = "";
    private String description = "";
    private String createdBy = "";
    private int ratings = 0; // Star rating out of 5

    private List<String> descToRender;

    public SimulationCardView(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 140;
        this.height = 160;
        descToRender = new ArrayList<>();
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public void setDescription(String description) {
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
        g.fillRect(x, y, width, height);

        g.setColor(Color.black);
        g.fillRect(x + 8, y + 8, width - 16, height - 16);

        g.setColor(Color.white);
        g.drawString(cardTitle, x + 12, y + 28);
        int ty = 48;
        for (String d : descToRender) {
            g.drawString(d, x + 10, y + ty);
            ty += 20;
        }
    }

    @Override
    public void update() {
        // Currently, there's no update logic needed for this class
    }

    private void splitDescription() {
        System.out.println("Len : " + description.length());
        if (description.length() > 17) {
            int dCount = 0;
            String currentString = ""; // Renamed _x to currentString
            for (char dc : description.toCharArray()) {
                currentString += dc;
                dCount += 1;
                if (dCount % 17 == 0) {
                    descToRender.add(currentString);
                    currentString = "";
                    dCount = 0;
                }
            }
            if (!currentString.isEmpty()) {
                descToRender.add(currentString);
            }
        }
    }
}
