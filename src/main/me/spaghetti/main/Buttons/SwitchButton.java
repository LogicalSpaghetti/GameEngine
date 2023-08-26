package main.me.spaghetti.main.Buttons;

import main.me.spaghetti.main.constructors.blocks.colorBlocks;
import main.me.spaghetti.main.constructors.blocks.CodeBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static main.me.spaghetti.main.Main.*;

public class SwitchButton extends JPanel implements MouseListener {
    public String type;
    public SwitchButton(String type, JPanel panel) {
        this.type = type;
        setPreferredSize(new Dimension(50, 50));
        setBackground(colorBlocks.getColorOfType(type));
        addMouseListener(this);
        panel.add(this);
    }
    public static void createButtons(JPanel panel) {
        new SwitchButton("Motion", panel);
            new CodeBlock(150, 125, 200, 50, "moveSteps");
            new CodeBlock(150, 200, 220, 50, "turnRightDegrees");
        new SwitchButton("Looks", panel);
            new CodeBlock(150, 125, 200, 50, "sayForSeconds");
        new SwitchButton("Sound", panel);
            new CodeBlock(150, 125, 200, 50, "playSoundUntilDone");
        new SwitchButton("Events", panel);
            new CodeBlock(150, 125, 200, 50, "whenFlagClicked");
        new SwitchButton("Control", panel);
            new CodeBlock(150, 125, 200, 50, "waitSeconds");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentType = type;
        for (CodeBlock block : blocks) {
            if (CodeBlock.isBlockOutsideBlockArea(block)) {
                block.setVisible(Objects.equals(block.type, this.type));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
