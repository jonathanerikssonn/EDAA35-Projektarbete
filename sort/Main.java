package sort;

import java.util.Random;


public class Main {
    public static void main(String args[])
    {

        int[][] testData = {
            generateRandomArray(1000, DataCharacteristics.RANDOM),   // small, random data
            generateRandomArray(1000, DataCharacteristics.SORTED_ASC),  // small, ascending
            generateRandomArray(1000, DataCharacteristics.REVERSE_SORTED),  // small, descending
            generateRandomArray(1000, DataCharacteristics.RANDOM_DUPLICATES)  // small, random (duplicates)
        };

       for (int[] arr : testData) {
           System.out.println("ArrSize: " + arr.length);
           testSortingAlgorithms(arr,10000);
           System.out.println();
       }
    }

    static void testSortingAlgorithms(int[] arr) {
        long startTime, endTime;

        // Bubble Sort
        startTime = System.nanoTime();
        bubbleSort.sort(arr.clone(), arr.length); 
        endTime = System.nanoTime();
        System.out.println("Bubble Sort: " + (endTime - startTime) + " ns");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort.sort(arr.clone(),0, arr.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort: " + (endTime - startTime) + " ns");

        // Heap Sort
        startTime = System.nanoTime();
        heapSort.sort(arr.clone());
        endTime = System.nanoTime();
        System.out.println("Heap Sort: " + (endTime - startTime) + " ns");

        // Quick Sort
        startTime = System.nanoTime();
        quickSort.sort(arr.clone(), 0, arr.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort: " + (endTime - startTime) + " ns");
    }

    static void testSortingAlgorithms(int[] arr, int runs) {
        long totalTimeBubble = 0;
        long totalTimeMerge = 0;
        long totalTimeHeap = 0;
        long totalTimeQuick = 0;
    
        for (int i = 0; i < runs; i++) {
            // Bubble Sort
            long startTime = System.nanoTime();
            bubbleSort.sort(arr.clone(), arr.length); 
            long endTime = System.nanoTime();
            totalTimeBubble += (endTime - startTime);
    
            // Merge Sort
            startTime = System.nanoTime();
            mergeSort.sort(arr.clone(), 0, arr.length - 1);
            endTime = System.nanoTime();
            totalTimeMerge += (endTime - startTime);
    
            // Heap Sort
            startTime = System.nanoTime();
            heapSort.sort(arr.clone());
            endTime = System.nanoTime();
            totalTimeHeap += (endTime - startTime);
    
            // Quick Sort
            startTime = System.nanoTime();
            quickSort.sort(arr.clone(), 0, arr.length - 1);
            endTime = System.nanoTime();
            totalTimeQuick += (endTime - startTime);
        }
    
        // Calculate averages
        long averageTimeBubble = totalTimeBubble / runs;
        long averageTimeMerge = totalTimeMerge / runs;
        long averageTimeHeap = totalTimeHeap / runs;
        long averageTimeQuick = totalTimeQuick / runs;
    
        // Print results
       System.out.println("Bubble Sort (Average): " + averageTimeBubble + " ns");
       System.out.println("Merge Sort (Average): " + averageTimeMerge + " ns");
       System.out.println("Heap Sort (Average): " + averageTimeHeap + " ns");
       System.out.println("Quick Sort (Average): " + averageTimeQuick + " ns");
    }

    static int[] generateRandomArray(int size, DataCharacteristics characteristics) {
        Random random = new Random();
        int[] arr = new int[size];

        switch (characteristics) {
            case RANDOM:
                for (int i = 0; i < size; i++) {
                    arr[i] = random.nextInt();
                }
                break;
            case SORTED_ASC:
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
                break;
            case REVERSE_SORTED:
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                break;
            case RANDOM_DUPLICATES:
                for (int i = 0; i < size; i++) {
                    arr[i] = random.nextInt(size / 2); // Introduce duplicates
                }
                break;
        }

        return arr;
    }

    enum DataCharacteristics {
        RANDOM,
        SORTED_ASC,
        REVERSE_SORTED,
        RANDOM_DUPLICATES
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
          System.out.print(arr[i] + " ");
        System.out.println();
      }
}


