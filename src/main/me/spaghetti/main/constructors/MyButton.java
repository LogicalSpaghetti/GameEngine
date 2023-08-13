package main.me.spaghetti.main.constructors;

import main.me.spaghetti.main.constructors.blocks.MoveBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

import static main.me.spaghetti.main.Main.*;

// replace with a MoveBlock that doesn't know it's outside its area and gets replaced when moved
public class MyButton extends JPanel implements MouseListener, MouseMotionListener {

    String type;

    public MyButton(int x, int y, int width, int height, String type) {
        this.type = type;
        setBounds(x, y, width, height);
        addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        blocks.add(new MoveBlock(getX() + getParent().getX(), getY() + getParent().getY(), 200, 100, type));
        blocks.get(blocks.size() - 1).grabFocus();
        Point mouseWhereOnButton = new Point(e.getX(), e.getY());
        Point clickPointRelativeToFrame = SwingUtilities.convertPoint(e.getComponent(), new Point(e.getX(), e.getY()), frame);

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                blocks.get(blocks.size() - 1).setLocation(frame.getMousePosition().x - mouseWhereOnButton.x - (frame.getWidth() - frame.getContentPane().getWidth()), frame.getMousePosition().y - mouseWhereOnButton.y - (frame.getHeight() - frame.getContentPane().getHeight())); // Center the panel under the cursor
            }
        });
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.removeMouseMotionListener(this.getMouseMotionListeners()[0]);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
