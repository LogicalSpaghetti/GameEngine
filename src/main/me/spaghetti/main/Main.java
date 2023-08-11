package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.MyButton;
import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.MoveBlock;

import java.util.ArrayList;

import static main.me.spaghetti.main.constructors.MyFrame.refreshDisplay;

public class Main {

    public static MyFrame frame = new MyFrame("Creatively Named Game Engine");


    public static ArrayList<MoveBlock> blocks = new ArrayList<>();

    public static MyButton button = new MyButton(200, 200, 200, 50, "Motion");
    public static MyButton button2 = new MyButton(200, 250, 200, 50, "Looks");

    public static void main(String[] args) {

        blocks.add(new MoveBlock(0, 0, 200, 100, "Motion"));
        blocks.add(new MoveBlock(100, 50, 200, 100, "Looks"));

        refreshDisplay(frame);
    }
}