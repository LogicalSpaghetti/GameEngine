package main.me.spaghetti.main.constructors.blocks;

import javax.swing.*;

// "move" int "pixels"
public class MoveBlock extends JPanel {
    public MoveBlock() {
        System.out.println("happened!");
        CodeBlock.basicStates(this);
    }
}
