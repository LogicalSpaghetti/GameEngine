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
        return new Color(r/colors.length, g/colors.length, b/colors.length);
    }
}
