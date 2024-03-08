package q2_insertionsort;

import utilities.Utilities;

import java.util.Comparator;
import java.util.Random;

public class StabilityTesting {
    public static void main(String[] args) {

        int tests = 100;
        int size = 100;
        StabilityTestClass[] arr;
        int possibleValues = 3;
        int[] amountOfEach;
        int correct;
        Random rand = new Random();
        Comparator<StabilityTestClass> stabilityOrder = new Comparator<StabilityTestClass>() {
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

        //testing stability for sort 1
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

        //testing stability for sort 2
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

        //testing stability for sort 3
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

        //testing stability for sort 4
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
    private static class StabilityTestClass implements Comparable<StabilityTestClass> {
        private int value;
        private int place;
        StabilityTestClass (int value, int place) {
            this.value = value;
            this.place = place;
        }

        @Override
        public int compareTo(StabilityTestClass o) {
            return this.value-o.value;
        }
    }
}
