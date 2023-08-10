package main.me.spaghetti.main.constructors.blocks;

import main.me.spaghetti.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// "move" int "pixels"
public class MoveBlock extends JPanel implements MouseListener, MouseMotionListener {

    private Point initialClick;

    public MoveBlock(int x, int y, int width, int height, Color color) {

        this.setBackground(color);
        this.setBounds(x,y, width, height);
        this.setSize(width, height);
        System.out.println("happened!");
        CodeBlock.basicStates(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        getParent().setComponentZOrder(this, 0); // Bring the clicked panel to the front
        System.out.println("Happened!!");
        Main.frame.update(Main.frame.getGraphics());

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
