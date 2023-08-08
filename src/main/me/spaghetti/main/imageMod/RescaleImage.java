package main.me.spaghetti.main.imageMod;

import javax.swing.ImageIcon;
import java.awt.*;

// rescales an image to a desired size
public class RescaleImage {

    // rescales an ImageIcon to tileSize by tileSize and returns it as a BufferedImage
    public static ImageIcon imageIcon(ImageIcon icon, int width, int height) {

        Image startImage = icon.getImage(); // transform it
        Image newImg = startImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon.setImage(newImg); // transform it back

        return icon;
    }
}
