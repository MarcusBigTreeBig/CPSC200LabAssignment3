package q1_dutchflag;

import utilities.Utilities;

/**
 * This class has 2 methods of solving the Dutch Flag Problem
 *
 * The problem is if you have an unsorted array of objects that are either red, white, or blue,
 * to organise the array so that all reds are first, and all blues are last, with the whites in the middle.
 */

public class DutchFlagSolver {
    /**
     * O(n) time
     * Each iteration does between 0 and 2 inclusive swaps to ensure the most recent
     * read element is in the right place.
     *
     * @param arr
     */
    public void solveMethod1 (RedWhiteBlue[] arr) {
        int n = arr.length;
        int w = 0, b = 0;
        for (int i = 0; i < n; i++) {
            /*
            Loop Invariant:
            [Red)[White)[Blue)[Unsorted)
            0    w      b     i         n
             */
            if (arr[i].isRed()) {
                Utilities.swap(arr, i, w);
                if (w == b) {
                    b++;
                }
                w++;
            }
            if (arr[i].isWhite()) {
                Utilities.swap(arr, i, b);
                b++;
            }
        }
    }

    /**
     *
     * @param rwb
     * @return the enum value stored by the RedWhiteBlue object
     */
    private RedWhiteBlue_Implementation getColour (RedWhiteBlue rwb) {
        if (rwb.isRed()) {
            return RedWhiteBlue_Implementation.Red;
        }
        if (rwb.isWhite()) {
            return RedWhiteBlue_Implementation.White;
        }
        return RedWhiteBlue_Implementation.Blue;
    }

    /**
     * O(n) time
     * Partitions the red elements to the left
     * Without looking at the red elements, then partitions the white elements to the left
     *
     * @param arr
     */
    public void solveMethod2 (RedWhiteBlue[] arr) {
        int i = Utilities.partition(arr, 0, arr.length, obj -> !obj.isRed());
        Utilities.partition(arr, i, arr.length, obj -> !obj.isWhite());
    }
}
