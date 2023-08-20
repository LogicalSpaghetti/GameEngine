package main.me.spaghetti.main.Buttons;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.addAndDeleteZone;

public class TabButton extends JPanel {
    public TabButton() {
        setSize(new Dimension(60, addAndDeleteZone.getHeight()));
        setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        setLocation(0, 0);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        addAndDeleteZone.add(this);

        SwitchButton.createButtons(this);
    }
}
