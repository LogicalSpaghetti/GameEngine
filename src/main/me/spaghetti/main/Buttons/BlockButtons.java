package main.me.spaghetti.main.Buttons;

import main.me.spaghetti.main.constructors.blocks.MoveBlock;

import java.awt.*;

// replace with a MoveBlock that doesn't know it's outside its area and gets replaced when moved
public class BlockButtons {
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

