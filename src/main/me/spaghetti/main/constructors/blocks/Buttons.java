package main.me.spaghetti.main.constructors.blocks;

import java.awt.*;

import static main.me.spaghetti.main.Main.frame;
import static main.me.spaghetti.main.constructors.MyFrame.refreshDisplay;

// replace with a MoveBlock that doesn't know it's outside its area and gets replaced when moved
public class Buttons {
    public static void createButtons() {
        new MoveBlock(150, 150, 200, 50, "Motion");
        new MoveBlock(150, 250, 200, 50, "Looks");
        new MoveBlock(150, 350, 200, 50, "Sound");
        new MoveBlock(150, 450, 200, 50, "Start");
        new MoveBlock(150, 550, 200, 50, "Control");
        refreshDisplay(frame);
    }
    public static Color getColorOfType(String type) {
        return switch (type) {
            case "Motion" -> new Color(0x0080ff);
            case "Looks" -> new Color(0x8000ff);
            case "Sound" -> new Color(0xff00ff);
            case "Start" -> new Color(0xffff00);
            case "Control" -> new Color(0xff8000);
            default -> Color.black;
        };
    }

    public static void setTopOrBottom(MoveBlock block) {
        block.isTop = false;
        block.isBottom = false;
        switch (block.type) {
            case "Start" -> block.isTop = true;
            case "Control" -> block.isBottom = true;
        }
    }
}
