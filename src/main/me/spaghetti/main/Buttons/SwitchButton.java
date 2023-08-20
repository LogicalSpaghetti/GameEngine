package main.me.spaghetti.main.Buttons;

import main.me.spaghetti.main.constructors.blocks.MoveBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static main.me.spaghetti.main.Main.blocks;

public class SwitchButton extends JPanel implements MouseListener {
    public String type;
    public SwitchButton(String type, JPanel panel) {
        this.type = type;
        setPreferredSize(new Dimension(50, 50));
        setBackground(BlockButtons.getColorOfType(type));
        addMouseListener(this);
        panel.add(this);
    }
    public static void createButtons(JPanel panel) {
        SwitchButton button1 = new SwitchButton("Motion", panel);
            new MoveBlock(150, 150, 200, 50, "Motion");
        SwitchButton button2 = new SwitchButton("Looks", panel);
            new MoveBlock(150, 150, 200, 50, "Looks");
        SwitchButton button3 = new SwitchButton("Sound", panel);
            new MoveBlock(150, 150, 200, 50, "Sound");
        SwitchButton button4 = new SwitchButton("Start", panel);
            new MoveBlock(150, 150, 200, 50, "Start");
        SwitchButton button5 = new SwitchButton("Control", panel);
            new MoveBlock(150, 150, 200, 50, "Control");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (MoveBlock block : blocks) {
            if (MoveBlock.isBlockOutsideBlockArea(block)) {
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