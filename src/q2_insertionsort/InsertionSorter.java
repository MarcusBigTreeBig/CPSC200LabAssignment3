package q2_insertionsort;

import utilities.Utilities;

import java.util.Comparator;

/**
 * This class has 4 methods of implementing insertion sort
 */

public class InsertionSorter {

    /**
     * Implements insertion sort on data that extends comparable
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort (E[] data) {
        int n = data.length;
        E e;
        for (int i = 1; i < n; i++) {
            e = data[i];
            for (int j = i-1; j >= 0 && e.compareTo(data[j]) < 0; --j) {//insertion
                Utilities.swap(data, j , j+1);
            }
        }
    }

    /**
     * Implements insertion sort on data that has a provided comparator
     *
     * @param data
     * @param pred
     * @param <E>
     */
    public static <E> void sort (E[] data, Comparator<E> pred) {
        int n = data.length;
        E e;
        for (int i = 1; i < n; i++) {
            e = data[i];
            for (int j = i-1; j >= 0 && pred.compare(e, data[j]) < 0; --j) {//insertion
                Utilities.swap(data, j , j+1);
            }
        }
    }

    /**
     * Implements insertion sort on data that extends comparable
     * Uses sentinel values
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortSentinel (E[] data) {
        int n = data.length;
        E e;
        int smallestIndex = 0;
        for (int i = 1; i < n; i++) {
            if (data[smallestIndex].compareTo(data[i]) > 0) {
                smallestIndex = i;
            }
        }
        for (int j = smallestIndex; j > 0; j--) {
                Utilities.swap(data, smallestIndex,  smallestIndex-j);
        }
        for (int i = 1; i < n; i++) {
            e = data[i];
            for (int j = i-1; e.compareTo(data[j]) < 0; --j) {//insertion
                Utilities.swap(data, j , j+1);
            }
        }
    }

    /**
     * Implements insertion sort on data that has a provided comparator
     * Uses sentinel values
     *
     * @param data
     * @param pred
     * @param <E>
     */
    public static <E> void sortSentinel (E[] data, Comparator<E> pred) {
        int n = data.length;
        E e;
        int smallestIndex = 0;
        for (int i = 1; i < n; i++) {
            if (pred.compare(data[smallestIndex], data[i]) > 0) {
                smallestIndex = i;
            }
        }
        for (int j = smallestIndex; j > 0; j--) {
            Utilities.swap(data, smallestIndex,  smallestIndex-j);
        }
        for (int i = 1; i < n; i++) {
            e = data[i];
            for (int j = i-1; pred.compare(e, data[j]) < 0; --j) {//insertion
                Utilities.swap(data, j , j+1);
            }
        }
    }
}
