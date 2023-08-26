package main.me.spaghetti.main;

import main.me.spaghetti.main.constructors.FrameDecoration.FramePrimaryPanel;
import main.me.spaghetti.main.constructors.FrameDecoration.FrameTopBar;
import main.me.spaghetti.main.constructors.FrameDecoration.Panels.*;
import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.blocks.GhostBlock;
import main.me.spaghetti.main.constructors.blocks.CodeBlock;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<CodeBlock> blocks = new ArrayList<>();

    public static String currentType = "Motion";
    public static boolean isFullScreen = true;
    public static Dimension windowedSize = new Dimension(800, 800);
    public static Point windowedLocation = new Point(0, 0);
    public static MyFrame creativelyNamedGameEngineFrame = new MyFrame("Creatively Named Game Engine");
    public static FrameTopBar secondaryPanel = new FrameTopBar();
    public static FramePrimaryPanel primaryPanel = new FramePrimaryPanel();

    public static BlockAreaPanel blockArea = new BlockAreaPanel(350, 100, 750, 700, Color.lightGray);
    public static AddAndDeleteZonePanel addAndDeleteZone = new AddAndDeleteZonePanel(0, blockArea.getY(), blockArea.getX(), blockArea.getHeight(), Color.darkGray);

    public static StagePanel stage = new StagePanel(blockArea.getX() + blockArea.getWidth() + 10, blockArea.getY(), 480, 360, Color.blue);

    public static StageConfigPanel stageConfig = new StageConfigPanel(stage.getX() + stage.getWidth() - 80, stage.getY() + stage.getHeight() + 10, 80, 350, Color.green);
    public static SpriteConfigPanel spriteConfig = new SpriteConfigPanel(stage.getX(), stage.getY() + stage.getHeight() + 10, stage.getWidth() - stageConfig.getWidth() - 10, 100, Color.cyan);
    public static SpritesPanel sprites = new SpritesPanel(spriteConfig.getX(), stageConfig.getY(), spriteConfig.getWidth(), stageConfig.getHeight(), Color.magenta);

    public static GhostBlock gBlock = new GhostBlock();

    public static void main(String[] args) {
        MyFrame.refreshDisplay(creativelyNamedGameEngineFrame);
    }
}