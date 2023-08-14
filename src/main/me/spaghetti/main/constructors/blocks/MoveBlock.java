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
    private Point lastStableLocation;
    public String type;
    public boolean isTop;
    public boolean isBottom;

    public MoveBlock(int x, int y, int width, int height, String type) {

        this.type = type;
        this.setBackground(getColorOfType(type));
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
        setTopOrBottom(type);
    }

    private Color getColorOfType(String type) {
        return switch (type) {
            case "Motion" -> new Color(0x0071f3);
            case "Looks" -> new Color(0x9d00ff);
            case "Start" -> new Color(0xffff00);
            case "Control" -> new Color(0xff7f27);
            default -> Color.black;
        };
    }

    private void setTopOrBottom(String type) {
        this.isTop = false;
        this.isBottom = false;
        switch (type) {
            case "Start" -> this.isTop = true;
            case "Control" -> this.isBottom = true;
        }
    }

    private boolean isThisOutsideBlockArea() {
        return !blockArea.getBounds().intersects(this.getBounds());
    }
    private boolean isPointOutsideBlockArea(Point point) {
        return !blockArea.getBounds().contains(point);
    }

    private boolean inTrash() {
        return addAndDeleteZone.getBounds().contains(this.getLocation());
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
        lastStableLocation = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (inTrash()) {
            panel.remove(this);
            refreshDisplay(frame);
            return;
        }
        if (isPointOutsideBlockArea(panel.getMousePosition())) {
            setLocation(lastStableLocation);
        }
        if (isThisOutsideBlockArea()) {
            panel.remove(this);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int deltaX = e.getX() - initialClick.x;
        int deltaY = e.getY() - initialClick.y;

        setLocation(getLocation().x + deltaX, getLocation().y + deltaY);

        // loop through every panel and if it's inside blockArea then generate two rectangles relative to its top and bottom left corners,
        // and if the top left corner of the panel being dragged is within that rectangle then create a ghost outline the size of the dragged block,
        // and stop checking so there's only one
        // remove the ghost block at the beginning of each mouseDragged()
        // if there's a ghost when mouseReleased(), snap the panel to that coordinate,
        // and add it to the ArrayList associated with the tower it snapped to.
        // for blocks within a tower that aren't the top, only check for the bottom rectangle.
        // remember to also ignore the top or bottom check if it's an isTop or isBottom.

        // for tomorrow, just get the ghosts and snapping working, save the ArrayLists for later.
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
