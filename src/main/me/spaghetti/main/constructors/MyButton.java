package main.me.spaghetti.main.constructors;

import main.me.spaghetti.main.constructors.blocks.MoveBlock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static main.me.spaghetti.main.Main.blocks;
import static main.me.spaghetti.main.Main.frame;

public class MyButton extends JButton implements MouseListener {

    String type;

    public MyButton(int x, int y, int width, int height, String type) {
        this.type = type;
        setBounds(x, y, width, height);
        addMouseListener(this);
        frame.add(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        blocks.add(new MoveBlock(this.getX(), this.getY(), 200, 50, this.type));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        getParent().setComponentZOrder(this, frame.getComponentCount() - 1);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
