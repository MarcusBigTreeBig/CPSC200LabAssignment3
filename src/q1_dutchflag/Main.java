package q1_dutchflag;

import utilities.Utilities;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        DutchFlagSolver dfs = new DutchFlagSolver();

        RedWhiteBlue[] arr1 = RedWhiteBlue.makeRWBArray(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
        Utilities.shuffle(rand, arr1);
        printArr(arr1);
        dfs.solveMethod1(arr1);
        printArr(arr1);

        RedWhiteBlue[] arr2 = RedWhiteBlue.makeRWBArray(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
        Utilities.shuffle(rand, arr2);
        printArr(arr2);
        dfs.solveMethod2(arr2);
        printArr(arr2);
    }
    public static <E> void printArr (E[] arr) {
        for (E e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
