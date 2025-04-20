
import java.util.Scanner;

public class BinarySort {
    public static int binarySearch(int[] arr, int item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == item)
                return mid + 1;
            else if (arr[mid] < item)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void binaryInsertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            int pos = binarySearch(arr, key, 0, j);
            
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        binaryInsertionSort(arr, size);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}
