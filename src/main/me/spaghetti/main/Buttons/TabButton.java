package main.me.spaghetti.main.Buttons;

import javax.swing.*;
import java.awt.*;

public class TabButton extends JPanel {
    public TabButton(JPanel zone) {
        this.setSize(new Dimension(60, zone.getHeight()));
        this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.setLocation(0, 0);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        zone.add(this);

        SwitchButton.createButtons(this);
    }
}
