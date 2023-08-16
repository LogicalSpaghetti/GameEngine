package main.me.spaghetti.main.constructors.blocks;

import javax.swing.*;
import java.awt.*;

import static main.me.spaghetti.main.Main.primaryPanel;

//todo: if it's in the middle of a stack, the stack needs to be shifted down by the size of the inserted block, but the blocks they think they're connected to should remain unchanged until the block is dropped
public class GhostBlock extends JPanel {
    MoveBlock snapBlock;
    boolean top;
    public GhostBlock() {
        primaryPanel.add(this);
        this.setBackground(new Color(0x505050));
        this.setVisible(false);
        this.getParent().setComponentZOrder(this, 0);
    }

    public static void showGhostBlock(MoveBlock toBlock, MoveBlock toBePlacedBlock, boolean top, GhostBlock ghostBlock) {
        ghostBlock.snapBlock = toBlock;
        ghostBlock.top = top;
        //creates a ghost block to indicate where the block will be snapped to, should be removed when the block is placed
        ghostBlock.setSize(toBePlacedBlock.getSize());
        if (top) {
            ghostBlock.setLocation(new Point(toBlock.getX(), toBlock.getY() - toBePlacedBlock.getHeight()));
        } else {
            ghostBlock.setLocation(new Point(toBlock.getX(), toBlock.getY() + toBlock.getHeight()));
        }
        ghostBlock.setVisible(true);
        // ghostBlock.getParent().setComponentZOrder(ghostBlock, 0);
    }
}
