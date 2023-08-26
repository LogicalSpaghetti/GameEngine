package main.me.spaghetti.main.constructors.FrameDecoration.Panels;

import javax.swing.*;
import java.awt.*;

public class SpriteConfigPanel extends JPanel {
    public SpriteConfigPanel(int x , int y, int width, int height, Color color) {
        DefineRegion.region(this, x , y, width, height, color);
    }
}
