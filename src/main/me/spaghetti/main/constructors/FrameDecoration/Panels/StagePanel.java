package main.me.spaghetti.main.constructors.FrameDecoration.Panels;

import javax.swing.*;
import java.awt.*;

public class StagePanel extends JPanel {
    public StagePanel(int x , int y, int width, int height, Color color) {
        DefineRegion.region(this, x , y, width, height, color);
    }
}
