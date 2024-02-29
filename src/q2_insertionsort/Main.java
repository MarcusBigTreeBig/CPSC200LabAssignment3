package q2_insertionsort;

import utilities.Utilities;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 20;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Utilities.shuffle(rand, arr);
        printArr(arr);
        InsertionSorter.sort(arr);
        printArr(arr);
    }
    public static <E> void printArr (E[] arr) {
        for (E e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
