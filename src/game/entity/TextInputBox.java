package game.entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.GamePanel;
import game.event.KeyHandler;

public class TextInputBox extends Entity {
    private final JTextField textField;
    private String inputText;

    public TextInputBox(GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        textField = new JTextField(20);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputText = textField.getText();
            }
        });
        textField.setBounds(600, 500, 500, 60);
    }

    public String getCapturedText() {
        return inputText;
    }

    @Override
    public void draw(Graphics2D g) {
        gp.add(textField);

    }

    @Override
    public void update() {
    }
}
