package main.me.spaghetti.main.constructors.blocks;

import main.me.spaghetti.main.imageMod.RescaleImage;

import javax.swing.*;

import java.awt.*;

public class CodeBlock {

    // todo: draw the block by hand as a png, keep the border and inside as separate images for color, and segment them into their curves
    // just a simple search and replace will handle recoloring, and just save every model (one folder per block) before hand
    // make a separate project for replacing every pixel of a certain color in a set of inputted images with a different color

    // for the equation bubbles, just create four circles and two rectangles

    // add a toggle in settings for accurate language, which turns number into double, text into string, etcetera

    // a block needs a color, inputs for variables, text to explain things, and dropdowns for prebuilt blocks
    // for constructor blocks they need names for each input
    // every tower of code should run with a one frame delay, configurable by right click which will affect the entire tower

    // all pre-defined blocks will have their own constructor but should share similar code

    // also add hover tooltips like in intellij

    // labels need a class too, and the size of a block should depend on it,
    // with height being constant unless it's a top, bottom, or loop block

    // Thread.sleep(/*milliseconds*/);

    public static void basicStates(JPanel panel) {
        System.out.println("happened!");
        // size of each segment (1px gap between each), width = 176, 2, 16; height = 32, 2, 48
        panel.setVisible(true);
    }

}
