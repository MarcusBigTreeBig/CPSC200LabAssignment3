package q2_insertionsort;

import utilities.Utilities;

import java.util.Comparator;
import java.util.Random;

/**
 * Tests if all insertion sort algorithms from InsertionSorter are stable
 * Takes only a certain amount of possible values, so that many elements have same value
 * Stores the original order of each element to ensure remains the same after sort
 */

public class StabilityTesting {
    public static void main(String[] args) {

        int tests = 100;
        int size = 100;
        StabilityTestClass[] arr;
        int possibleValues = 3;
        int[] amountOfEach;//keeps track of original order of elements
        int correct;
        Random rand = new Random();
        Comparator<StabilityTestClass> stabilityOrder = new Comparator<StabilityTestClass>() {
            /**
             * If 2 objects have the same value, not compared
             * Compares the place of the objects, to ensure it has stayed the same
             *
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(StabilityTestClass o1, StabilityTestClass o2) {
                if (o1.value == o2.value) {
                    return o1.place - o2.place;
                }else{
                    return 0;
                }
            }
        };

        Comparator<StabilityTestClass> reverseOrder = new Comparator<StabilityTestClass>() {
            @Override
            public int compare(StabilityTestClass o1, StabilityTestClass o2) {
                return o2.value-o1.value;
            }
        };

        //testing stability for sort with no sentinel and no comparator
        correct = 0;
        for (int i = 0; i < tests; i++) {
            arr = new StabilityTestClass[size];
            amountOfEach = new int[possibleValues];
            for (int j = 0; j < size; j++) {
                int value = rand.nextInt(possibleValues);
                amountOfEach[value] = amountOfEach[value]+1;
                arr[j] = new StabilityTestClass(value, amountOfEach[value]);
            }
            InsertionSorter.sort(arr);
            if (Utilities.isSorted(arr, stabilityOrder)) {
                correct++;
            }
        }
        System.out.println("Do all tests for sort 1 result in stable sorting: " + (correct == tests));

        //testing stability for sort with no sentinel and a comparator
        correct = 0;
        for (int i = 0; i < tests; i++) {
            arr = new StabilityTestClass[size];
            amountOfEach = new int[possibleValues];
            for (int j = 0; j < size; j++) {
                int value = rand.nextInt(possibleValues);
                amountOfEach[value] = amountOfEach[value]+1;
                arr[j] = new StabilityTestClass(value, amountOfEach[value]);
            }
            InsertionSorter.sort(arr, reverseOrder);
            if (Utilities.isSorted(arr, stabilityOrder)) {
                correct++;
            }
        }
        System.out.println("Do all tests for sort 2 result in stable sorting: " + (correct == tests));

        //testing stability for sort with a sentinel and no comparator
        correct = 0;
        for (int i = 0; i < tests; i++) {
            arr = new StabilityTestClass[size];
            amountOfEach = new int[possibleValues];
            for (int j = 0; j < size; j++) {
                int value = rand.nextInt(possibleValues);
                amountOfEach[value] = amountOfEach[value]+1;
                arr[j] = new StabilityTestClass(value, amountOfEach[value]);
            }
            InsertionSorter.sortSentinel(arr);
            if (Utilities.isSorted(arr, stabilityOrder)) {
                correct++;
            }
        }
        System.out.println("Do all tests for sort 3 result in stable sorting: " + (correct == tests));

        //testing stability for sort with a sentinel and a comparator
        correct = 0;
        for (int i = 0; i < tests; i++) {
            arr = new StabilityTestClass[size];
            amountOfEach = new int[possibleValues];
            for (int j = 0; j < size; j++) {
                int value = rand.nextInt(possibleValues);
                amountOfEach[value] = amountOfEach[value]+1;
                arr[j] = new StabilityTestClass(value, amountOfEach[value]);
            }
            InsertionSorter.sortSentinel(arr, reverseOrder);
            if (Utilities.isSorted(arr, stabilityOrder)) {
                correct++;
            }
        }
        System.out.println("Do all tests for sort 4 result in stable sorting: " + (correct == tests));

    }

    /**
     * Class that can remember it's original order within it's value
     */
    private static class StabilityTestClass implements Comparable<StabilityTestClass> {
        private int value;
        private int place;//the original placement for its value

        /**
         * creates an element
         *
         * @param value
         * @param place
         */
        StabilityTestClass (int value, int place) {
            this.value = value;
            this.place = place;
        }

        /**
         * compares with value
         *
         * @param o the object to be compared.
         * @return
         */
        @Override
        public int compareTo(StabilityTestClass o) {
            return this.value-o.value;
        }
    }
}
