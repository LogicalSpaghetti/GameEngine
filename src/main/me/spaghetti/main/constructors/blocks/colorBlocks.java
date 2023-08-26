package main.me.spaghetti.main.constructors.blocks;

import java.awt.*;

import static main.me.spaghetti.main.myMath.Contains.arrayContains;

// replace with a MoveBlock that doesn't know it's outside its area and gets replaced when moved
public class colorBlocks {
    public static Color getColorOfType(String type) {
        return switch (type) {
            case "Motion" -> new Color(0x0080ff);
            case "Looks" -> new Color(0x8000ff);
            case "Sound" -> new Color(0xff00ff);
            case "Events" -> new Color(0xffff00);
            case "Control" -> new Color(0xff8000);
            default -> Color.black;
        };
    }

    public static String subTypeToType(String subType) {
        // add an array and an if-else for every block type
        String[][] arrays = new String[9][];
        arrays[0] = new String[] {
                "moveSteps", "turnRightDegrees"
        };
        arrays[1] = new String[] {
                "sayForSeconds"
        };
        arrays[2] = new String[] {
                "playSoundUntilDone"
        };
        arrays[3] = new String[] {
                "whenFlagClicked"
        };
        arrays[4] = new String[] {
                "waitSeconds"
        };
        arrays[5] = new String[] {
                "touching"
        };
        arrays[6] = new String[] {
                "plus"
        };
        arrays[7] = new String[] {
                "setTo"
        };
        arrays[8] = new String[] {
                "myBlock"
        };

        int whatType = -1;
        for (int i = 0; i < arrays.length; i++) {
            if (arrayContains(arrays[i], subType)) {
                whatType = i;
            }
        }

        return switch (whatType) {
            case 0 -> "Motion";
            case 1 -> "Looks";
            case 2 -> "Sound";
            case 3 -> "Events";
            case 4 -> "Control";
            case 5 -> "Sensing";
            case 6 -> "Operators";
            case 7 -> "Variables";
            case 8 -> "MyBlocks";
            default -> null;
        };
    }
}

