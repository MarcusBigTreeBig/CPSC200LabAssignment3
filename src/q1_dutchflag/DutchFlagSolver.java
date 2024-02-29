package q1_dutchflag;

import utilities.Utilities;

public class DutchFlagSolver {
    public void solveMethod1 (RedWhiteBlue[] arr) {
        int n = arr.length;
        int w = 0, b = 0;
        for (int i = 0; i < n; i++) {
            /*
            Loop Invariant:
            [Red)[White)[Blue)[Unsorted)
            0    w      b     i         n
             */
            RedWhiteBlue_Implementation colour = getColour(arr[i]);
            switch (colour) {
                case Red:
                    Utilities.swap(arr, i, w);
                    w++;
                case White:
                    Utilities.swap(arr, i, b);
                    b++;
            }
        }
    }
    private RedWhiteBlue_Implementation getColour (RedWhiteBlue rwb) {
        if (rwb.isRed()) {
            return RedWhiteBlue_Implementation.Red;
        }
        if (rwb.isWhite()) {
            return RedWhiteBlue_Implementation.White;
        }
        return RedWhiteBlue_Implementation.Blue;
    }
    public void solveMethod2 (RedWhiteBlue[] arr) {
        int i = Utilities.partition(arr, 0, arr.length, obj -> !obj.isRed());
        Utilities.partition(arr, i, arr.length, obj -> !obj.isWhite());
    }
}
