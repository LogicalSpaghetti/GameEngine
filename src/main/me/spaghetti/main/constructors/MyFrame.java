package main.me.spaghetti.main.constructors;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;

import static main.me.spaghetti.main.Main.*;

public class MyFrame extends JFrame {
	
	// this will create a full screen frame
	public MyFrame(String title) {
        setTitle(title);
        setSize(500,500);
        setFullScreen(this);
        BasicFrame();
    }

    private void BasicFrame() {
        setIconImage(new ImageIcon("src/main/resources/logos/conquest_logo.jpg").getImage());
        setLayout(new BorderLayout()); // makes it easier to position the custom top bar
        setUndecorated(true); //removes the default top bar
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

    public static void refreshDisplay(MyFrame frame) {
        frame.revalidate();
        frame.repaint();
    }

    public static void setWindowed(MyFrame frame) {
        frame.setSize(windowedSize.width, windowedSize.height);
        frame.setLocation(windowedLocation);
        frame.setResizable(true);
    }
}