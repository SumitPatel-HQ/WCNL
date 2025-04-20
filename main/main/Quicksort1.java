/**
 * Implementation of Quicksort algorithm using the first element as pivot.
 * Time Complexity: O(n log n) average and best case, O(n²) worst case when array is already sorted.
 * Space Complexity: O(log n) for recursion stack.
 */
// This program takes 1st Element As Pivot

import java.util.*;

public class Quicksort1 {

   public static void quicksort(int[] sort, int low, int high) 
   {
      if (low < high) {
         int pi = Partition(sort, low, high);
         quicksort(sort, low, pi - 1);
         quicksort(sort, pi + 1, high);
      }
   }

   public static int Partition(int[] sort, int low, int high) 
   {
      int pivot = sort[low]; // First element as pivot
      int i = low; 

      for (int j = low + 1; j <= high; j++) {
         if (sort[j] < pivot) {
            i++;
            swap(sort, i, j);
         }
      }
      swap(sort, low, i); // Swap pivot with correct position
      return i;
   }

   public static void swap(int[] sort, int i, int j) 
   {
      int temp = sort[i];
      sort[i] = sort[j];
      sort[j] = temp;
   }

   public static void Print(int[] sort) 
   {
      for (int num : sort) {
         System.out.print(num + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) 
   {
      Scanner A = new Scanner(System.in);

      System.out.println("$$$This is Quicksort Algorithm Program$$$");
      System.out.println("\nEnter the Number of Elements:");
      int n = A.nextInt();

      int[] sort = new int[n];

      System.out.println("Enter The list of Numbers:");
      for (int i = 0; i < n; i++) {
         sort[i] = A.nextInt();
      }

      quicksort(sort, 0, n - 1);
      System.out.println("Sorted List:");
      Print(sort);

      A.close();
   }
}
