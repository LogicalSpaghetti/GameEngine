package main.me.spaghetti.main.constructors.FrameDecoration;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.primaryPanel;

public class RegionPanel extends JPanel {
    public RegionPanel(int x , int y, int width, int height, Color color) {
        setBounds(x, y, width, height);
        setBackground(color);
        setLayout(null);
        primaryPanel.add(this);
    }
}
