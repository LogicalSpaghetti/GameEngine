package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.FrameDecoration.FramePrimaryPanel;
import main.me.spaghetti.main.constructors.FrameDecoration.FrameTopBar;
import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.Buttons;
import main.me.spaghetti.main.constructors.blocks.GhostBlock;
import main.me.spaghetti.main.constructors.blocks.MoveBlock;
import main.me.spaghetti.main.constructors.blocks.RegionPanel;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static boolean isFullScreen = true;
    public static Dimension windowedSize = new Dimension(800, 800);
    public static Point windowedLocation = new Point(0, 0);
    public static MyFrame frame = new MyFrame("Creatively Named Game Engine");
    public static FrameTopBar topBar = new FrameTopBar();
    public static FramePrimaryPanel panel = new FramePrimaryPanel();

    public static RegionPanel blockArea = new RegionPanel(400, 100, 900, frame.getHeight() - 200, Color.lightGray);
    public static RegionPanel addAndDeleteZone = new RegionPanel(100, 100, 300, frame.getHeight()-200, Color.darkGray);

    public static GhostBlock gBlock = new GhostBlock();
    public static ArrayList<MoveBlock> blocks = new ArrayList<>();

    public static void main(String[] args) {
        Buttons.createButtons();
        /*
        todo: take some deep breaths
         */
    }
}