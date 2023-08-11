package main.me.spaghetti.main.constructors.blocks;

import javax.swing.*;

import java.awt.*;

import static main.me.spaghetti.main.Main.frame;

public class RegionPanel extends JPanel {

    public RegionPanel(int x , int y, int width, int height, Color color) {
        setBounds(x, y, width, height);
        setVisible(true);
        setBackground(color);
        setLayout(null);
        frame.add(this);
        getParent().setComponentZOrder(this, getParent().getComponentCount() - 1);
    }
}
