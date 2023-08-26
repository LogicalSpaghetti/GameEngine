package main.me.spaghetti.main;

import main.me.spaghetti.main.Buttons.TabButton;
import main.me.spaghetti.main.constructors.FrameDecoration.FramePrimaryPanel;
import main.me.spaghetti.main.constructors.FrameDecoration.FrameTopBar;
import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.GhostBlock;
import main.me.spaghetti.main.constructors.blocks.MoveBlock;
import main.me.spaghetti.main.constructors.FrameDecoration.RegionPanel;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<MoveBlock> blocks = new ArrayList<>();

    public static String currentType = "Motion";
    public static boolean isFullScreen = true;
    public static Dimension windowedSize = new Dimension(800, 800);
    public static Point windowedLocation = new Point(0, 0);
    public static MyFrame creativelyNamedGameEngineFrame = new MyFrame("Creatively Named Game Engine");
    public static FrameTopBar secondaryPanel = new FrameTopBar();
    public static FramePrimaryPanel primaryPanel = new FramePrimaryPanel();

    public static RegionPanel blockArea =
        new RegionPanel(400, 100, 900, 630, Color.lightGray);
    public static RegionPanel addAndDeleteZone =
        new RegionPanel(50, 100, 350, 630, Color.darkGray);
            public static TabButton tabButton = new TabButton();
    public static GhostBlock gBlock = new GhostBlock();

    public static void main(String[] args) {

    }
}