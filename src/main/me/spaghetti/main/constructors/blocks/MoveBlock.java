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
    }

    private Color getColorOfType(String type) {
        return switch (type) {
            case "Motion" -> new Color(0x0071f3);
            case "Looks" -> new Color(0x9d00ff);
            default -> Color.black;
        };
    }

    private boolean isNotWithinBlockArea() {
        return !blockArea.getBounds().intersects(this.getBounds());
    }

    private boolean inTrash() {
        return addAndDeleteZone.getBounds().contains(this.getLocation());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isNotWithinBlockArea()) {
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
        if (isNotWithinBlockArea()) {
            setLocation(lastStableLocation);
        }
        if (isNotWithinBlockArea()) {
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
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
