package q1_dutchflag;

import utilities.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Random;

/**
 * Tests that both methods of solving the dutch flag problem works
 * Times both methods at various sizes to observe the asymptotic complexity
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        DutchFlagSolver dfs = new DutchFlagSolver();
        FileWriter method1File = new FileWriter("method1times.txt");
        FileWriter method2File = new FileWriter("method2times.txt");

        Comparator<RedWhiteBlue> comp = new Comparator<RedWhiteBlue>() {
            /**
             * Compares in order of red, white, blue
             *
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(RedWhiteBlue o1, RedWhiteBlue o2) {
                if (o1.isRed() || o2.isBlue()) {
                    return -1;
                }
                if (o2.isWhite() && o1.isWhite()) {
                    return 0;
                }
                return 1;
            }
        };

        int timings = 100;
        int increment = 1000;
        int trials = 100;
        RedWhiteBlue[] arr;
        StopWatch clock = new StopWatch();

        //test and time method 1
        int correct = 0;
        for (int i = 0; i < timings*increment; i += increment) {
            clock.reset();
            for (int j = 0; j < trials; j++) {
                arr = RedWhiteBlue.makeRWBArray(i, i, i);
                Utilities.shuffle(rand, arr);
                clock.start();
                dfs.solveMethod1(arr);
                clock.stop();
                if (Utilities.isSorted(arr, comp)) {
                    correct++;
                }else{
                    printArr(arr);
                }
            }
            method1File.write(i + " , " + clock.elapsed() + "\n");
            method1File.flush();
        }
        method1File.write("Do all tests succeed: " + (correct == timings*trials));
        method1File.flush();

        //test and time method 2
        correct = 0;
        for (int i = 0; i < timings*increment; i += increment) {
            clock.reset();
            for (int j = 0; j < trials; j++) {
                arr = RedWhiteBlue.makeRWBArray(i, i, i);
                Utilities.shuffle(rand, arr);
                clock.start();
                dfs.solveMethod2(arr);
                clock.stop();
                if (Utilities.isSorted(arr, comp)) {
                    correct++;
                }else{
                    printArr(arr);
                }
            }
            method2File.write(i + " , " + clock.elapsed() + "\n");
            method2File.flush();
        }
        method2File.write("Do all tests succeed: " + (correct == timings*trials));
        method2File.flush();
    }

    /**
     * Prints out the elements of an array
     *
     * @param arr
     * @param <E>
     */
    public static <E> void printArr (E[] arr) {
        for (E e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
