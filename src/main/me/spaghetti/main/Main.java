package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.MoveBlock;

public class Main {

    public static MyFrame frame = new MyFrame("Creatively Named Game Engine");

    public static MoveBlock moveBlock = new MoveBlock();

    public static void main(String[] args) {
        frame.add(moveBlock);
        Main.frame.update(Main.frame.getGraphics());
    }
}