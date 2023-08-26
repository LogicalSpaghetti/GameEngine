package main.me.spaghetti.main.constructors.FrameDecoration.Panels;

import javax.swing.*;

import java.awt.*;

import static main.me.spaghetti.main.Main.primaryPanel;

public class DefineRegion {
    public static void region(JPanel panel, int x , int y, int width, int height, Color color) {
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setLayout(null);
        primaryPanel.add(panel);
    }
}
