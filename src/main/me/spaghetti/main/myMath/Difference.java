package main.me.spaghetti.main.myMath;

import java.awt.*;

public class Difference {
    public static Point point(Point first, Point last) {
        return new Point(first.x - last.x, first.y - last.y);
    }
}
