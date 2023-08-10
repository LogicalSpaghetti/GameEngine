package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.MoveBlock;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static MyFrame frame = new MyFrame("Creatively Named Game Engine");

    public static ArrayList<MoveBlock> blocks = new ArrayList<>();

    public static void main(String[] args) {

        blocks.add(new MoveBlock(0, 0, 200, 100, Color.gray));
        blocks.add(new MoveBlock(100, 50, 200, 100, Color.black));

        frame.add(blocks.get(0));
        frame.add(blocks.get(1));
        Main.frame.update(Main.frame.getGraphics());
    }
}