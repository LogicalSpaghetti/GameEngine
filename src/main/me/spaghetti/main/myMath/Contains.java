package main.me.spaghetti.main.myMath;

import java.util.Objects;

public class Contains {
    public static boolean arrayContains(String[] array, String value) {
        for (String s : array) {
            if (Objects.equals(s, value)) {
                return true;
            }
        }
        return false;
    }
}
