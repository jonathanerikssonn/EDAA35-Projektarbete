package sort;

import java.util.Random;

public class Main {
    public static void main(String args[])
    {

        int[][] testData = {
            generateRandomArray(1000),   // liten
            generateRandomArray(10000),  // medium
            generateRandomArray(100000)  // stor
        };

        for (int[] arr : testData) {
            System.out.println("ArrSize: " + arr.length);
            testSortingAlgorithms(arr);
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

    static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
          System.out.print(arr[i] + " ");
        System.out.println();
      }
}
