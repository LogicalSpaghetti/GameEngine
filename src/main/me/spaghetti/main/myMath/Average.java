package main.me.spaghetti.main.myMath;

import java.awt.*;

public class Average {
    public static Color color(Color[] colors) {

        int r = 0;
        int g = 0;
        int b = 0;
        for (Color color : colors) {
            r += color.getRed();
            g += color.getGreen();
            b += color.getBlue();
        }
        r = r/colors.length;
        g = g/colors.length;
        b = b/colors.length;

        return new Color(r, g, b);
    }
}
