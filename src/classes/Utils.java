package classes;

public class Utils {
    public static int dice() {
        final int MAX = 3;
        final int MIN = 1;
        final int RANGE = MAX - MIN + 1;
        return (int) (Math.random() * RANGE) + MIN;
    }
}