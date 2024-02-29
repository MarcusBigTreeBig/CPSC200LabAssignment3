package q1_dutchflag;

/**
 * Obtained from decompiling .jar file provided by Dr. Casperson
 *
 * RedWhiteBlue class used for the Dutch Flag problem
 */

public class RedWhiteBlue implements Comparable<RedWhiteBlue> {
    private RedWhiteBlue_Implementation value;
    private static final RedWhiteBlue red;
    private static final RedWhiteBlue white;
    private static final RedWhiteBlue blue;

    private RedWhiteBlue(RedWhiteBlue_Implementation var1) {
        this.value = var1;
    }

    private RedWhiteBlue(RedWhiteBlue var1) {
        this.value = var1.value;
    }

    public int compareTo(RedWhiteBlue var1) {
        return this.value.compareTo(var1.value);
    }

    public String toString() {
        return this.value.toString();
    }

    public boolean equals(Object var1) {
        return !(var1 instanceof RedWhiteBlue) ? false : ((RedWhiteBlue)var1).equals(this);
    }

    public boolean equals(RedWhiteBlue var1) {
        return var1 != null && var1.value == this.value;
    }

    public static RedWhiteBlue[] makeRWBArray(int var0, int var1, int var2) {
        RedWhiteBlue[] var3 = new RedWhiteBlue[var0 + var1 + var2];
        int var4 = 0;

        int var5;
        for(var5 = 0; var5 < var0; ++var5) {
            var3[var4++] = new RedWhiteBlue(red);
        }

        for(var5 = 0; var5 < var1; ++var5) {
            var3[var4++] = new RedWhiteBlue(white);
        }

        for(var5 = 0; var5 < var2; ++var5) {
            var3[var4++] = new RedWhiteBlue(blue);
        }

        return var3;
    }

    public boolean isRed() {
        return this.value.isRed();
    }

    public boolean isWhite() {
        return this.value.isWhite();
    }

    public boolean isBlue() {
        return this.value.isBlue();
    }

    static {
        red = new RedWhiteBlue(RedWhiteBlue_Implementation.Red);
        white = new RedWhiteBlue(RedWhiteBlue_Implementation.White);
        blue = new RedWhiteBlue(RedWhiteBlue_Implementation.Blue);
    }
}
