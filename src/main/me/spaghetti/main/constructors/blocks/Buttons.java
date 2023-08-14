package main.me.spaghetti.main.constructors.blocks;

// replace with a MoveBlock that doesn't know it's outside its area and gets replaced when moved
public class Buttons {
    public static void createButtons() {
        new MoveBlock(150, 150, 200, 100, "Motion");
        new MoveBlock(150, 300, 200, 100, "Looks");
    }
}
