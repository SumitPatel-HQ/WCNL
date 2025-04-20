/**
 * Implementation of the Quicksort algorithm using the last element as pivot.
 * Time Complexity: Best/Average case O(n log n), Worst case O(n²) when array is already sorted.
 * Space Complexity: O(log n) for recursive call stack.
 */
// This program takes Last Element As Pivot

import java.util.*;

class Quicksort {

   public static void quicksort(int[] sort, int low, int high)   // Recurrsive function
   {
      if(low < high){
         int pi = Partition(sort, low, high);
         quicksort(sort, low, pi - 1);
         quicksort(sort, pi + 1, high);
      }
   }

   public static int Partition(int[] sort, int low, int high) 
   {
      int pivot = sort[high];
      int i = low - 1;

      for (int j = low ; j <= high -1; j++)
      {
         if (sort[j] < pivot)
         {
            i++;
            swap(sort, i, j);
         }
      }
      swap(sort,i + 1 ,high);

      return i+1; 
   }

   public static void swap(int[] sort ,int i,int j) 
   {
      int temp = sort[i];
      sort[i]=sort[j];
      sort[j]= temp;
   }

   public static void Print(int[] sort) 
   {
      for( int num : sort)
      {
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

      int[] sort = new int[n];  //array declaration

      System.out.println("Enter The list of Number:");
      for(int i = 0; i < n; i++)
      {
         sort[i] = A.nextInt();
      }

      quicksort(sort,0, n - 1);
      System.out.println("Sorted List");
      Print(sort);

      A.close();
   }
}
