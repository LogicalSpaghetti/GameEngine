package main.me.spaghetti.main.constructors.blocks;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.primaryPanel;

public  class GhostBlock extends JPanel {
    CodeBlock snapBlock;
    boolean top;
    public Point lastLocation = new Point(0, 0);
    public GhostBlock() {
        primaryPanel.add(this);
        this.setBackground(new Color(0x505050));
        this.setVisible(false);
        this.getParent().setComponentZOrder(this, 0);
    }

    public static void showGhostBlock(CodeBlock toBlock, CodeBlock toBePlacedBlock, boolean top, GhostBlock ghostBlock) {


        ghostBlock.snapBlock = toBlock;
        ghostBlock.top = top;
        // creates a ghost block to indicate where the block will be snapped to, should be removed when the block is placed
        ghostBlock.setSize(toBePlacedBlock.getSize());
        if (top) {
            ghostBlock.setLocation(new Point(toBlock.getX(), toBlock.getY() - toBePlacedBlock.getHeight()));
        } else {
            ghostBlock.setLocation(new Point(toBlock.getX(), toBlock.getY() + toBlock.getHeight()));
            CodeBlock.makeRoomForG(toBlock, new Point(ghostBlock.getX(), ghostBlock.getY() + ghostBlock.getHeight()));
            ghostBlock.lastLocation = ghostBlock.getLocation();
        }
        ghostBlock.setVisible(true);
    }
}
