package main.me.spaghetti.main.constructors.FrameDecoration;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.frame;
import static main.me.spaghetti.main.Main.topBar;

public class FramePrimaryPanel extends JPanel {
    public FramePrimaryPanel() {
        setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()-topBar.getPreferredSize().height));
        setLayout(null);
        frame.add(this, BorderLayout.CENTER);
    }
}
