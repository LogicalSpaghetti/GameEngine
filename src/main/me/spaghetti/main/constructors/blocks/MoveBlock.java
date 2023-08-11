package main.me.spaghetti.main.constructors.blocks;

import main.me.spaghetti.main.constructors.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static main.me.spaghetti.main.Main.frame;
import static main.me.spaghetti.main.constructors.MyFrame.refreshDisplay;

// "move" int "pixels"
public class MoveBlock extends JPanel implements MouseListener, MouseMotionListener {

    private Point initialClick;

    public MoveBlock(int x, int y, int width, int height, String type) {

        this.setBackground(getColorOfType(type));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setBounds(x,y, width, height);
        this.setSize(width, height);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setVisible(true);
        frame.add(this);
        getParent().setComponentZOrder(this, 0);
        refreshDisplay(frame);
    }

    private Color getColorOfType(String type) {
        Color color = new Color(0x000000);
        switch (type) {
            case "Motion" -> color = new Color(0x0071f3);
            case "Looks" -> color = new Color(0x9d00ff);
        }
        return color;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        getParent().setComponentZOrder(this, 0);
        initialClick = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
