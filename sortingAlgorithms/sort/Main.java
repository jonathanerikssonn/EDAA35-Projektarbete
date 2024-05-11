package sort;

public class Main {
    public static void main(String args[])
    {

        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        
        //bubble
        bubbleSort.sort(arr, arr.length);

        //merge
        mergeSort merge = new mergeSort();
        merge.sort(arr, 0, arr.length - 1);
        

        //heap
        heapSort heap = new heapSort();
        heap.sort(arr);

        //quick
        quickSort.sort(arr, 0, arr.length - 1);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
          System.out.print(arr[i] + " ");
        System.out.println();
      }
}
