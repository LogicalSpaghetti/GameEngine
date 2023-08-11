package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.MyButton;
import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.MoveBlock;
import main.me.spaghetti.main.constructors.blocks.RegionPanel;

import java.awt.*;
import java.util.ArrayList;

import static main.me.spaghetti.main.constructors.MyFrame.refreshDisplay;

public class Main {

    public static MyFrame frame = new MyFrame("Creatively Named Game Engine");

    public static RegionPanel blockArea = new RegionPanel(300, 100, 900, frame.getHeight() - 200, Color.lightGray);
    public static RegionPanel addAndDeleteZone = new RegionPanel(100, 100, 200, frame.getHeight()-200, Color.darkGray);

    public static ArrayList<MoveBlock> blocks = new ArrayList<>();

    public static MyButton button = new MyButton(0, 200, 200, 100, "Motion");
    public static MyButton button2 = new MyButton(0, 300, 200, 100, "Looks");

    public static void main(String[] args) {

        addAndDeleteZone.add(button);
        addAndDeleteZone.add(button2);

        blocks.add(new MoveBlock(0, 0, 200, 100, "Motion"));
        blocks.add(new MoveBlock(100, 50, 200, 100, "Looks"));

        refreshDisplay(frame);

        for (MoveBlock block : blocks) {

            block.getX();
        }
    }
}