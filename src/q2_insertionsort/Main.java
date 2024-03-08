package q2_insertionsort;

import utilities.StopWatch;
import utilities.Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Random;

/**
 * Tests all insertion sort algorithms in InsertionSorter
 * Times all algorithms to observe asymptotic complexity.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        FileWriter sort1File = new FileWriter("sort1times.txt");//no sentinel and no comparator
        FileWriter sort2File = new FileWriter("sort2times.txt");//no sentinel and comparator
        FileWriter sort3File = new FileWriter("sort3times.txt");//sentinel and no comparator
        FileWriter sort4File = new FileWriter("sort4times.txt");//sentinel and comparator

        int timings = 100;
        int increment = 100;
        int trials = 100;
        int correct;
        Integer[] arr;
        StopWatch clock = new StopWatch();

        Comparator<Integer> reverseOrder = new Comparator<Integer>() {
            /**
             * Compares Integer objects in reverse order to test sorting with a comparator
             *
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*o1.compareTo(o2);
            }
        };

        //test and time sort with no sentinel and no comparator
        correct = 0;
        for (int i = increment; i < timings*increment; i += increment) {
            clock.reset();
            for (int j = 0; j < trials; j++) {
                arr = new Integer[i];
                for (int k = 0; k < i; k++) {
                    arr[k] = rand.nextInt(i);
                }
                Utilities.shuffle(rand, arr);
                clock.start();
                InsertionSorter.sort(arr);
                clock.stop();
                if (Utilities.isSorted(arr)) {
                    correct++;
                }else{
                    printArr(arr);
                }
            }
            sort1File.write(i + " , " + clock.elapsed() + "\n");
            sort1File.flush();
        }
        sort1File.write("Do all tests succeed: " + (correct == (timings-1)*trials));
        sort1File.flush();

        //test and time sort with no sentinel, but a comparator
        correct = 0;
        for (int i = increment; i < timings*increment; i += increment) {
            clock.reset();
            for (int j = 0; j < trials; j++) {
                arr = new Integer[i];
                for (int k = 0; k < i; k++) {
                    arr[k] = rand.nextInt(i);
                }
                Utilities.shuffle(rand, arr);
                clock.start();
                InsertionSorter.sort(arr, reverseOrder);
                clock.stop();
                if (Utilities.isSorted(arr, reverseOrder)) {
                    correct++;
                }else{
                    printArr(arr);
                }
            }
            sort2File.write(i + " , " + clock.elapsed() + "\n");
            sort1File.flush();
        }
        sort2File.write("Do all tests succeed: " + (correct == (timings-1)*trials));
        sort2File.flush();

        //test and time sort with a sentinel, but no comparator
        correct = 0;
        for (int i = increment; i < timings*increment; i += increment) {
            clock.reset();
            for (int j = 0; j < trials; j++) {
                arr = new Integer[i];
                for (int k = 0; k < i; k++) {
                    arr[k] = rand.nextInt(i);
                }
                Utilities.shuffle(rand, arr);
                clock.start();
                InsertionSorter.sortSentinel(arr);
                clock.stop();
                if (Utilities.isSorted(arr)) {
                    correct++;
                }else{
                    printArr(arr);
                }
            }
            sort3File.write(i + " , " + clock.elapsed() + "\n");
            sort3File.flush();
        }
        sort3File.write("Do all tests succeed: " + (correct == (timings-1)*trials));
        sort3File.flush();

        //test and time sort with both a sentinel and a comparator
        correct = 0;
        for (int i = increment; i < timings*increment; i += increment) {
            clock.reset();
            for (int j = 0; j < trials; j++) {
                arr = new Integer[i];
                for (int k = 0; k < i; k++) {
                    arr[k] = rand.nextInt(i);
                }
                Utilities.shuffle(rand, arr);
                clock.start();
                InsertionSorter.sortSentinel(arr, reverseOrder);
                clock.stop();
                if (Utilities.isSorted(arr, reverseOrder)) {
                    correct++;
                }else{
                    printArr(arr);
                }
            }
            sort4File.write(i + " , " + clock.elapsed() + "\n");
            sort1File.flush();
        }
        sort4File.write("Do all tests succeed: " + (correct == (timings-1)*trials));
        sort4File.flush();
    }


    public static <E> void printArr (E[] arr) {
        for (E e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
