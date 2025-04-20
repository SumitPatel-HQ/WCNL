// Time Complexity: O(n^2) in worst and average case, where n is the number of elements
// Best case is O(n) when array is already sorted
import java.util.*;

public class insertionsort  // the declared package "" does not match the ecpected package src 
{
   public static void insertion(int[] Sort)  //performs the Main insertion sort Algorithm
   {
      for(int i=1; i<Sort.length;i++)
      {
         int key = Sort[i];
         int j = i - 1;

         while(j >= 0 && Sort[j] > key)
         {
            Sort[j + 1] = Sort[j];
            j = j - 1;
            // Updated Aarry: [12, 12, 13, 5, 6].
         }
         Sort[j + 1] = key; // place the key at its right position
         // Updated Aarry: [11, 12, 13, 5, 6]. using "Sort[j + 1] = key"  
      }
   }

   public static void print(int[] Sort) 
   {
      System.out.println("Sorted Numbers");

      for(int i = 0; i < Sort.length;i++)
      {
         System.out.print(Sort[i] + " ");
      }

      System.out.println();
   }
   public static void main(String[] args) 
   {
      Scanner A = new Scanner(System.in);

      System.out.println("Insertion sort");
      System.out.println("Enter the Number of Elments:");
      int n = A.nextInt();
      
      int[] Sort = new int[n];

      System.out.println("Enter the Elements into Array");
      for(int i = 0; i < n; i++)
      {
         Sort[i] = A.nextInt();
      }
      insertion(Sort);
      print(Sort);
   }
}