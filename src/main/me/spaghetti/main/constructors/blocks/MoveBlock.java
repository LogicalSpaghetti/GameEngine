package main.me.spaghetti.main.constructors.blocks;

import main.me.spaghetti.main.Buttons.BlockButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

import static main.me.spaghetti.main.Main.*;
import static main.me.spaghetti.main.constructors.MyFrame.refreshDisplay;

// "move" int "pixels"
public class MoveBlock extends JPanel implements MouseListener, MouseMotionListener {

    private Point initialClick;
    private Point lastLocation;
    public String type;
    public boolean isTop;
    public boolean isBottom;
    private boolean isWithinBlockArea;

    private MoveBlock topBlock;
    private MoveBlock bottomBlock;

    public MoveBlock(int x, int y, int width, int height, String blockType) {
        isWithinBlockArea = false;
        this.type = blockType;
        setBackground(BlockButtons.getColorOfType(type));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setBounds(x,y, width, height);
        setSize(width, height);
        addMouseListener(this);
        addMouseMotionListener(this);
        if (MoveBlock.isBlockOutsideBlockArea(this)) {
            setVisible(Objects.equals(type, "Motion"));
        }
        primaryPanel.add(this);
        getParent().setComponentZOrder(this, 0);
        refreshDisplay(creativelyNamedGameEngineFrame);
        blocks.add(this);
        BlockButtons.setTopOrBottom(this);
    }

    public static boolean isBlockOutsideBlockArea(MoveBlock block) {
        return !blockArea.getBounds().intersects(block.getBounds());
    }
    private boolean isPointOutsideBlockArea(Point point) {
        if (point != null) {
            return !blockArea.getBounds().contains(point);
        } else {
            return false;
        }
    }

    private boolean inTrash() {
        return addAndDeleteZone.getBounds().contains(primaryPanel.getMousePosition());
    }

    private void fixIfOutside() {
        // deletes the block if it's within the deletion area
        if (inTrash()) {
            deleteChain(this);
            refreshDisplay(creativelyNamedGameEngineFrame);
            return;
        }
        // if it's outside the blockArea it gets moved to its previous location
        if (isPointOutsideBlockArea(primaryPanel.getMousePosition())) {
            snapBackChain(this);
        }
        // if it's still outside the blockArea, then it's deleted
        if (isBlockOutsideBlockArea(this)) {
            deleteChain(this);
        }
        refreshDisplay(creativelyNamedGameEngineFrame);
    }

    private void saveLocationInChain(MoveBlock block) {
        block.lastLocation = block.getLocation();

        if (block.bottomBlock != null) {
            saveLocationInChain(block.bottomBlock);
        }
    }

    private void moveInChain(MoveBlock block, int newX, int newY) {
        block.setLocation(newX, newY);

        if (block.bottomBlock != null) {
            moveInChain(block.bottomBlock, newX , newY + block.getHeight());
        }
    }

    private void deleteChain(MoveBlock block) {
        // if the top block should be deleted, delete all its children
        if (block.bottomBlock != null) {
            deleteChain(block.bottomBlock);
        }
        primaryPanel.remove(block);
        blocks.remove(block);
    }

    // todo: fix this by remembering all previous locations of child blocks
    private void snapBackChain(MoveBlock block) {
        // if the top block is dropped outside the area, snap back all its children too
        block.setLocation(block.lastLocation);
        if (block.bottomBlock != null) {
            //repeat with the bottomBlock at the location below block
            snapBackChain(block.bottomBlock);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isBlockOutsideBlockArea(this)) {
            new MoveBlock(getX(), getY(), getWidth(), getHeight(), type);
        }

        getParent().setComponentZOrder(this, 0);
        initialClick = e.getPoint();
        saveLocationInChain(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        fixIfOutside();
        isWithinBlockArea = true;

        if (gBlock.isVisible()) { // triggers if there's a valid place to snap to
            setLocation(gBlock.getLocation());
            if (gBlock.top) { // true if connecting to the top of a block
                gBlock.snapBlock.topBlock = this;
                bottomBlock = gBlock.snapBlock;
            } else { // connecting to the bottom of a block
                gBlock.snapBlock.bottomBlock = this;
                topBlock = gBlock.snapBlock;
            }
        }
        gBlock.setVisible(false);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // todo: take some deep breaths
        if (topBlock != null) {
            topBlock.bottomBlock = null;
        }
        topBlock = null;

        int deltaX = e.getX() - initialClick.x;
        int deltaY = e.getY() - initialClick.y;
        int newX = deltaX + getLocation().x;
        int newY = deltaY + getLocation().y;

        moveInChain(this, newX, newY);

        for (MoveBlock block : blocks) {
            boolean isChild = bottomBlock == block;
            if (block.isWithinBlockArea && !block.equals(this) && !isChild) {
                int xDiff = Math.abs(getX() - block.getX());
                int yDiffTop = Math.abs((getY() + getHeight()) - block.getY());
                int yDiffBottom = Math.abs(getY() - (block.getY() + block.getHeight()));

                boolean topValid = (yDiffTop <= 40 && !isBottom && !block.isTop);
                boolean bottomValid = (yDiffBottom <= 40 && !isTop && !block.isBottom);
                boolean validConnection = xDiff <= 40 && (topValid || bottomValid);

                if (validConnection) {
                    GhostBlock.showGhostBlock(block, this, topValid, gBlock);
                    return;
                } else {
                    gBlock.setVisible(false);
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
