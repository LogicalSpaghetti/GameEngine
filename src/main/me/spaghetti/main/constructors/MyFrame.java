package main.me.spaghetti.main.constructors;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.me.spaghetti.main.Main.*;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

    public MyFrame(String title, int width, int height) {
        setTitle(title);
        sizeAndCenter(width, height);
        BasicFrame();
    }
	
	// this will create a full screen frame
	public MyFrame(String title) {
        setTitle(title);
        this.setSize(500,500);

        setFullScreen(this);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        BasicFrame();
    }

    private void BasicFrame() {
        decorateFrame();
        addInputDetection();
        setVisible(true);
    }

    public static void setFullScreen(MyFrame frame) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreenDevice = graphicsEnvironment.getDefaultScreenDevice();
        Rectangle bounds = defaultScreenDevice.getDefaultConfiguration().getBounds();

        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(defaultScreenDevice.getDefaultConfiguration());
        bounds.height -= screenInsets.bottom;

        frame.setBounds(bounds);
    }

    // all code for decorating the top bar and widget of a frame, as well as the background
    private void decorateFrame() {
        setIcon();
        getContentPane().setBackground(new Color(0xFFFFFF));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setUndecorated(true);
    }

    private void setIcon() {
        ImageIcon image = new ImageIcon("src/main/resources/logos/conquest_logo.jpg");
        setIconImage(image.getImage());
    }


    private void sizeAndCenter(int width, int height) {
        sizeFrame(width, height);
        centerFrame(width, height);
    }

    private void sizeFrame(int width, int height) {
        setSize(width, height); // Add 30 to account for the frame title bar I think
        setResizable(true);
    }

    private void centerFrame(int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (int) ((screenSize.getWidth() - width) / 2); // accounts for the size of the window when centering it
        int locY = (int) (((screenSize.getHeight() - height) / 2));
        setLocation(locX, locY);
    }

    private void addInputDetection() {
        addKeyListener(this);
        setFocusable(true);
    }

    public static void refreshDisplay(MyFrame frame) {
        frame.revalidate();
        frame.repaint();
    }

    public static void setWindowed(MyFrame frame) {
        frame.setSize(windowedSize.width, windowedSize.height);
        frame.setLocation(windowedLocation);
        frame.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}