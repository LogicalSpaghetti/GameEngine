package main.me.spaghetti.main.constructors.FrameDecoration.Panels;

import main.me.spaghetti.main.Buttons.TabButton;

import javax.swing.*;
import java.awt.*;

public class AddAndDeleteZonePanel extends JPanel {
    public AddAndDeleteZonePanel(int x , int y, int width, int height, Color color) {
        DefineRegion.region(this, x , y, width, height, color);
        new TabButton(this);
    }
}
