package main.me.spaghetti.main.Buttons;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.addAndDeleteZone;

public class TabButton extends JPanel {
    public TabButton() {
        this.setSize(new Dimension(60, addAndDeleteZone.getHeight()));
        this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.setLocation(0, 0);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        addAndDeleteZone.add(this);

        SwitchButton.createButtons(this);
    }
}
