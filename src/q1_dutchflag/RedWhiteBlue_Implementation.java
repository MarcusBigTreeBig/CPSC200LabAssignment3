package q1_dutchflag;

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
