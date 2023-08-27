package main.me.spaghetti.main.constructors.thingsInBlocks.presetIcons.text;

import main.me.spaghetti.main.constructors.blocks.CodeBlock;
import main.me.spaghetti.main.myMath.Average;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BlockThings extends JPanel {
    public BlockThings(CodeBlock block, String type, String text) {
        // either a text display or an image

        JLabel label;
        if (Objects.equals(type, "text")) {
            label = new JLabel(text);
            if (Objects.equals(text, "↻") || Objects.equals(text, "↺")) {
                label.setFont(new Font("Serif", Font.PLAIN, 20));
            }
        } else {
            // only for whenClicked
            label = new JLabel(new ImageIcon("src/main/resources/blockIcons/flag.png"));
        }
        label.setForeground(Color.lightGray); // text color
        add(label);

        setBackground(block.getBackground());

        block.thingsInThis.add(this);
        block.add(this);
    }

    public BlockThings(CodeBlock block, String type) {
        // user inputs
        if (Objects.equals(type, "curvedInput")) {
            setBackground(Color.white);
            MyTextField textField = new MyTextField("");
            this.add(textField);

            block.thingsInThis.add(this);
            block.add(this);
        } else if (Objects.equals(type, "curvedDropdown")) {
            setBackground(Color.white);
        } else if (Objects.equals(type, "squareDropdown")) {
            setBackground(Average.color(new Color[] {block.getBackground(), Color.black}));
        } else {
            setBackground(Color.black);
        }
        block.thingsInThis.add(this);

        block.add(this);
    }

    public static void addMyThings(CodeBlock block) {
        switch (block.subType) {
            case "moveSteps" -> {
                new BlockThings(block, "text", "move");
                new BlockThings(block, "curvedInput");
                new BlockThings(block, "text", "steps");
            }
            case "turnRightDegrees" -> {
                new BlockThings(block, "text", "turn");
                new BlockThings(block, "text", "↻");
                new BlockThings(block, "curvedInput");
                new BlockThings(block, "text", "degrees");
            }

            case "sayForSeconds" -> {
                new BlockThings(block, "text", "say");
                new BlockThings(block, "curvedInput");
                new BlockThings(block, "text", "for");
                new BlockThings(block, "curvedInput");
                new BlockThings(block, "text", "seconds");
            }

            case "playSoundUntilDone" -> {
                new BlockThings(block, "text", "play sound");
                new BlockThings(block, "curvedDropdown");
                new BlockThings(block, "text", "until done");
            }

            case "whenFlagClicked" -> {
                new BlockThings(block, "text", "when");
                new BlockThings(block, "image", "flag.png");
                new BlockThings(block, "text", "clicked");
            }

            case "waitSeconds" -> {
                new BlockThings(block, "text", "wait");
                new BlockThings(block, "curvedInput");
                new BlockThings(block, "text", "seconds");
            }

            case "touching" -> {
                new BlockThings(block, "text", "touching");
                new BlockThings(block, "curvedDropdown");
                new BlockThings(block, "text", "?");
            }

            case "plus" -> {
                new BlockThings(block, "curvedInput");
                new BlockThings(block, "text", "+");
                new BlockThings(block, "curvedInput");
            }

            case "setTo" -> {
                new BlockThings(block, "text", "set");
                new BlockThings(block, "squareDropdown");
                new BlockThings(block, "text", "to");
                new BlockThings(block, "curvedInput");
            }
        }
    }
}
