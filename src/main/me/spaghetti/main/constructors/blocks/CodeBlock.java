package main.me.spaghetti.main.constructors.blocks;

import main.me.spaghetti.main.constructors.MyFrame;
import main.me.spaghetti.main.constructors.thingsInBlocks.presetIcons.text.BlockThings;
import main.me.spaghetti.main.myMath.Average;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;

import static main.me.spaghetti.main.Main.*;
import static main.me.spaghetti.main.constructors.MyFrame.refreshDisplay;

public class CodeBlock extends JPanel implements MouseListener, MouseMotionListener {

    private Point initialClick;
    private Point lastLocation;
    public String type;
    public String subType;
    public boolean isTop = false;
    public boolean isBottom = false;
    private boolean isWithinBlockArea = false;

    public CodeBlock parentBlock;
    public CodeBlock childBlock;

    public ArrayList<BlockThings> thingsInThis = new ArrayList<>();

    public CodeBlock(int x, int y, int width, int height, String inSubType) {
        subType = inSubType;
        type = colorBlocks.subTypeToType(inSubType);

        setBackground(colorBlocks.getColorOfType(type));
        setBorder(BorderFactory.createLineBorder(border(this.getBackground()), 1));
        setBounds(x,y, width, height);
        setSize(width, height);
        addMouseListener(this);
        addMouseMotionListener(this);
        if (CodeBlock.isBlockOutsideBlockArea(this)) {
            setVisible(Objects.equals(type, currentType));
        }
        primaryPanel.add(this);
        getParent().setComponentZOrder(this, 0);
        refreshDisplay(creativelyNamedGameEngineFrame);
        blocks.add(this);
        setTopOrBottom();
        BlockThings.addMyThings(this);
    }

    private void setTopOrBottom() {
        switch (type) {
            case "Events" -> isTop = true;
            case "Control" -> isBottom = true;
        }
    }

    private Color border(Color color) {
        // returns the color for a border, which is two parts the original color, and one part gray.
        return Average.color(new Color[]{color, color, Color.gray});
    }


    public static boolean isBlockOutsideBlockArea(CodeBlock block) {
        return !blockArea.getBounds().intersects(block.getBounds());
    }
    private boolean isPointOutsideBlockArea(Point point) {
        if (point != null) {
            return !blockArea.getBounds().contains(point);
        } else {
            return false;
        }
    }

    private boolean inTrash() {
        return addAndDeleteZone.getBounds().contains(primaryPanel.getMousePosition());
    }

    private void fixIfOutside() {
        // deletes the block if it's within the deletion area
        if (inTrash()) {
            deleteChain(this);
            refreshDisplay(creativelyNamedGameEngineFrame);
            return;
        }
        // if it's outside the blockArea it gets moved to its previous location
        if (isPointOutsideBlockArea(primaryPanel.getMousePosition())) {
            snapBackChain(this);
        }
        // if it's still outside the blockArea, then it's deleted
        if (isBlockOutsideBlockArea(this)) {
            deleteChain(this);
        }
        refreshDisplay(creativelyNamedGameEngineFrame);
    }

    private void saveLocationInChain(CodeBlock block) {
        while (block.childBlock != null) {
            block.lastLocation = block.getLocation();
            block = block.childBlock;
        }
        block.lastLocation = block.getLocation();
    }

    private static void moveInChain(CodeBlock block, int newX, int newY) {
        block.setLocation(newX, newY);

        if (block.childBlock != null) {
            moveInChain(block.childBlock, newX , newY + block.getHeight());
        }
    }

    private void deleteChain(CodeBlock block) {
        // if the top block should be deleted, delete all its children
        if (block.childBlock != null) {
            deleteChain(block.childBlock);
        }
        primaryPanel.remove(block);
        blocks.remove(block);
    }

    private void snapBackChain(CodeBlock block) {
        // if the top block is dropped outside the area, snap back all its children too
        block.setLocation(block.lastLocation);
        if (block.childBlock != null) {
            // repeat with the bottomBlock at the location below block
            snapBackChain(block.childBlock);
        }
    }

    private CodeBlock getBottomBlock(CodeBlock block) {
        while (block.childBlock != null) {
            block = block.childBlock;
        }
        return block;
    }

    public static void makeRoomForG(CodeBlock top, Point location) {
        if (top.childBlock != null) {
            moveInChain(top.childBlock, location.x, location.y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (isBlockOutsideBlockArea(this)) {
            new CodeBlock(getX(), getY(), getWidth(), getHeight(), subType);
            MyFrame.refreshDisplay(creativelyNamedGameEngineFrame);
        }

        getParent().setComponentZOrder(this, 0);
        initialClick = e.getPoint();
        saveLocationInChain(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // to do: take some deep breaths
        if (parentBlock != null) {
            parentBlock.childBlock = null;
            parentBlock = null;
        }

        int deltaX = e.getX() - initialClick.x;
        int deltaY = e.getY() - initialClick.y;
        int newX = deltaX + getLocation().x;
        int newY = deltaY + getLocation().y;

        moveInChain(this, newX, newY);

        for (CodeBlock block : blocks) {
            boolean isChild = childBlock == block;
            if (block.isWithinBlockArea && !block.equals(this) && !isChild) {
                int xDiff = Math.abs(getX() - block.getX());
                int yDiffTop = Math.abs((getY() + getHeight()) - block.getY());
                int yDiffBottom = Math.abs(getY() - (block.getY() + block.getHeight()));

                boolean topValid = (yDiffTop <= 40 && !isBottom && !block.isTop && block.parentBlock == null);
                boolean bottomValid = (yDiffBottom <= 40 && !isTop && !block.isBottom) && !(isBottom && block.childBlock != null);
                boolean validConnection = xDiff <= 40 && (topValid || bottomValid);

                if (validConnection) {
                    GhostBlock.showGhostBlock(block, this, topValid, gBlock);
                    return;
                } else {
                    gBlock.setVisible(false);
                    if (gBlock.snapBlock != null) {
                        makeRoomForG (
                                gBlock.snapBlock,
                                new Point(gBlock.snapBlock.getX(), gBlock.snapBlock.getY() + gBlock.snapBlock.getHeight())
                        );
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        fixIfOutside();
        isWithinBlockArea = true;
        if (gBlock.isVisible()) { // triggers if there's a valid place to snap to
            CodeBlock destBlock = gBlock.snapBlock;
            //moveInChain(this, gBlock.getX(), gBlock.getY());

            CodeBlock base = getBottomBlock(this);
            if (gBlock.top) { // true if connecting to the top of a block
                destBlock.parentBlock = base;
                base.childBlock = destBlock;
            } else { // connecting to the bottom of a block
                if (destBlock.childBlock != null) {
                    if (base.isBottom) {
                        destBlock.childBlock.parentBlock = null;
                        destBlock.childBlock.setLocation(base.getX() + (base.getWidth()/2), base.getY() + (base.getHeight()));
                    } else {
                        destBlock.childBlock.parentBlock = base;
                        base.childBlock = destBlock.childBlock;
                    }

                }
                destBlock.childBlock = this;
                parentBlock = destBlock;
            }
            moveInChain(this, gBlock.getX(), gBlock.getY());
        }
        gBlock.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}