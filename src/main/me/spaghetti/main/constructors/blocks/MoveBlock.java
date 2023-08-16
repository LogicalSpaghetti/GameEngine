package main.me.spaghetti.main.constructors.blocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

    public MoveBlock(int x, int y, int width, int height, String type) {
        this.isWithinBlockArea = false;
        this.type = type;
        this.setBackground(Buttons.getColorOfType(type));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setBounds(x,y, width, height);
        this.setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setVisible(true);
        panel.add(this);
        getParent().setComponentZOrder(this, 0);
        refreshDisplay(frame);
        blocks.add(this);
        Buttons.setTopOrBottom(this);
    }

    private boolean isThisOutsideBlockArea() {
        return !blockArea.getBounds().intersects(this.getBounds());
    }
    private boolean isPointOutsideBlockArea(Point point) {
        if (point != null) {
            return !blockArea.getBounds().contains(point);
        } else {
            return false;
        }
    }

    private boolean inTrash() {
        return addAndDeleteZone.getBounds().contains(panel.getMousePosition());
    }

    private void fixIfOutside() {
        // deletes the block if it's within the deletion area
        if (inTrash()) {
            panel.remove(this);
            refreshDisplay(frame);
            return;
        }
        // if it's outside the blockArea it gets moved to its previous location
        if (isPointOutsideBlockArea(panel.getMousePosition())) {
            setLocation(lastLocation);
        }
        // if it's still outside the blockArea, then it's deleted
        if (isThisOutsideBlockArea()) {
            panel.remove(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isThisOutsideBlockArea()) {
            new MoveBlock(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.type);
        }

        getParent().setComponentZOrder(this, 0);
        initialClick = e.getPoint();
        lastLocation = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        fixIfOutside();
        this.isWithinBlockArea = true;

        if (gBlock.isVisible()) { // triggers if there's a valid place to snap to
            this.setLocation(gBlock.getLocation());
            if (gBlock.top) { // true if connecting to the top of a block
                gBlock.snapBlock.topBlock = this;
                this.bottomBlock = gBlock.snapBlock;
            } else { // connecting to the bottom of a block
                gBlock.snapBlock.bottomBlock = this;
                this.topBlock = gBlock.snapBlock;
            }
        }
        gBlock.setVisible(false);
        System.out.println("top = " + this.topBlock + "\nbottom = " + this.bottomBlock);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.topBlock != null) {
            this.topBlock.bottomBlock = null;
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.topBlock = null;
        }
        this.topBlock = null;
        this.bottomBlock = null;

        int deltaX = e.getX() - initialClick.x;
        int deltaY = e.getY() - initialClick.y;

        setLocation(getLocation().x + deltaX, getLocation().y + deltaY);

        // todo: for the stacking, just save the block on top and the block on bottom and it's done
        // todo: if the block has one above it, don't check for top
        for (MoveBlock block : blocks) {
            if (block.isWithinBlockArea && !block.equals(this)) {
                int xDiff = Math.abs(this.getX() - block.getX());
                int yDiffTop = Math.abs((this.getY() + this.getHeight()) - block.getY());
                int yDiffBottom = Math.abs(this.getY() - (block.getY() + block.getHeight()));

                boolean topValid = (yDiffTop <= 40 && !this.isBottom && !block.isTop);
                boolean bottomValid = (yDiffBottom <= 40 && !this.isTop && !block.isBottom);
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
