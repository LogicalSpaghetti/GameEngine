package main.me.spaghetti.main.imageMod;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

// rescales an image to a desired size
public class RescaleImage {

    // rescales an ImageIcon to tileSize by tileSize and returns it as a BufferedImage
    public static BufferedImage imageIcon(ImageIcon icon, int width, int height) {

        // rescale
        Image startImage = icon.getImage(); // transform it
        Image newImg = startImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon.setImage(newImg); // transform it back

        // transform to BufferedImage
        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        // paint the Icon to the BufferedImage.
        icon.paintIcon(null, g, 0,0);
        g.dispose();

        return bi;
    }
}
