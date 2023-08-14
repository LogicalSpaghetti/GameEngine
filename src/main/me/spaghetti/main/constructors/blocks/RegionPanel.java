package main.me.spaghetti.main.constructors.blocks;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static main.me.spaghetti.main.Main.panel;

public class RegionPanel extends JPanel implements MouseListener {

    public RegionPanel(int x , int y, int width, int height, Color color) {
        setBounds(x, y, width, height);
        setVisible(true);
        setBackground(color);
        setLayout(null);
        panel.add(this);
        getParent().setComponentZOrder(this, getParent().getComponentCount() - 1);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
}
