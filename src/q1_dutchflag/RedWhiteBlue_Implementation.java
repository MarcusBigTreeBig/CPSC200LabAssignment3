package q1_dutchflag;

/**
 * Obtained from decompiling .jar file provided by Dr. Casperson
 *
 * Enum determining red, white, or blue for the Dutch Flag problem
 */

enum RedWhiteBlue_Implementation {
    Red,
    White,
    Blue;

    private RedWhiteBlue_Implementation() {
    }

    public boolean isRed() {
        return this == Red;
    }

    public boolean isWhite() {
        return this == White;
    }

    public boolean isBlue() {
        return this == Blue;
    }
}
