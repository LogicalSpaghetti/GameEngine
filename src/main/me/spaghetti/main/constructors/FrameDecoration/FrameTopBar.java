package main.me.spaghetti.main.constructors.FrameDecoration;

import main.me.spaghetti.main.constructors.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static main.me.spaghetti.main.Main.*;

public class FrameTopBar extends JPanel implements MouseListener, MouseMotionListener {

    private Point initialClick;
    private Point initialFramePos;

    public FrameTopBar() {
        setPreferredSize(new Dimension(creativelyNamedGameEngineFrame.getWidth(), 30));
        setLayout(new FlowLayout());
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        ((FlowLayout) getLayout()).setAlignment(FlowLayout.RIGHT);
        ((FlowLayout) getLayout()).setHgap(0);
        ((FlowLayout) getLayout()).setVgap(0);
        setBackground(new Color(0x808080));
        creativelyNamedGameEngineFrame.add(this, BorderLayout.NORTH);
        addMouseListener(this);
        addMouseMotionListener(this);

        minimizeButton();
        maximizeButton();
        closeWindow();
    }

    private void minimizeButton() {
        JPanel min = new JPanel();
        min.setBackground(this.getBackground());
        // add a label with an icon of its symbol
        min.setPreferredSize(new Dimension(40, 30));
        min.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creativelyNamedGameEngineFrame.setState(Frame.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                min.setBackground(new Color(0x404040));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                min.setBackground(new Color(0x808080));
            }
        });
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/main/resources/min.png"));
        min.add(label);
        this.add(min);
    }

    private void maximizeButton() {
        JPanel max = new JPanel();
        max.setBackground(this.getBackground());
        max.setPreferredSize(new Dimension(40, 30));
        max.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                max.remove(max.getComponent(0));
                if (isFullScreen) {
                    MyFrame.setWindowed(creativelyNamedGameEngineFrame);
                    JLabel label = new JLabel();
                    label.setIcon(new ImageIcon("src/main/resources/full.png"));
                    max.add(label);
                } else {
                    windowedSize.width = creativelyNamedGameEngineFrame.getWidth();
                    windowedSize.height = creativelyNamedGameEngineFrame.getHeight();
                    windowedLocation = creativelyNamedGameEngineFrame.getLocation();
                    MyFrame.setFullScreen(creativelyNamedGameEngineFrame);
                    JLabel label = new JLabel();
                    label.setIcon(new ImageIcon("src/main/resources/shrink.png"));
                    max.add(label);
                }
                isFullScreen = !isFullScreen;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                max.setBackground(new Color(0x404040));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                max.setBackground(new Color(0x808080));
            }
        });
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/main/resources/shrink.png"));
        max.add(label);
        this.add(max);
    }

    private void closeWindow() {
        JPanel end = new JPanel();
        end.setBackground(this.getBackground());
        end.setPreferredSize(new Dimension(40, 30));
        end.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creativelyNamedGameEngineFrame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                end.setBackground(new Color(0xff0000));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                end.setBackground(new Color(0x808080));
            }
        });
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/main/resources/x.png"));
        end.add(label);
        this.add(end);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        initialClick = MouseInfo.getPointerInfo().getLocation();
        initialFramePos = creativelyNamedGameEngineFrame.getLocation();
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
        int deltaX = MouseInfo.getPointerInfo().getLocation().x - initialClick.x;
        int deltaY = MouseInfo.getPointerInfo().getLocation().y - initialClick.y;

        if(isFullScreen) {
            MyFrame.setWindowed(creativelyNamedGameEngineFrame);
        }
        creativelyNamedGameEngineFrame.setLocation(initialFramePos.x + deltaX, initialFramePos.y + deltaY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}