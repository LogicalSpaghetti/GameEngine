package main.me.spaghetti.main.constructors.FrameDecoration;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.creativelyNamedGameEngineFrame;
import static main.me.spaghetti.main.Main.secondaryPanel;

public class FramePrimaryPanel extends JPanel {
    public FramePrimaryPanel() {
        setPreferredSize(new Dimension(creativelyNamedGameEngineFrame.getWidth(), creativelyNamedGameEngineFrame.getHeight()- secondaryPanel.getPreferredSize().height));
        setLayout(null);
        creativelyNamedGameEngineFrame.add(this, BorderLayout.CENTER);
    }
}
