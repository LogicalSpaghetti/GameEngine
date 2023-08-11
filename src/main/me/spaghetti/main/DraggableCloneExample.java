package main.me.spaghetti.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraggableCloneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Draggable Clone Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setPreferredSize(new Dimension(400, 400));
            frame.add(mainPanel);

            mainPanel.addMouseListener(new MouseAdapter() {
                private JPanel clonedPanel;
                private Point offset;

                @Override
                public void mousePressed(MouseEvent e) {
                    JPanel clickedPanel = (JPanel) e.getSource();
                    clonedPanel = new JPanel();
                    clonedPanel.setBounds(clickedPanel.getBounds());
                    clonedPanel.setBackground(Color.BLUE);
                    clonedPanel.setLayout(null);  // Allow manual positioning

                    offset = e.getPoint(); // Calculate the offset

                    mainPanel.add(clonedPanel);
                    mainPanel.revalidate();

                    clonedPanel.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            if (clonedPanel != null) {
                                clonedPanel.setLocation(e.getX() - offset.x, e.getY() - offset.y);
                                mainPanel.repaint();
                            }
                        }
                    });
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    mainPanel.remove(clonedPanel);
                    clonedPanel = null;
                    offset = null;
                    mainPanel.repaint();
                }
            });

            JPanel redPanel = new JPanel();
            redPanel.setBounds(50, 50, 100, 100);
            redPanel.setBackground(Color.RED);
            redPanel.addMouseListener(mainPanel.getMouseListeners()[0]); // Share the listener

            mainPanel.add(redPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}