import java.util.*;

public class insertionsort {

   public static void insertion(int[] Sort) {
      for(int i=1; i<Sort.length;i++)
      {
         int key = Sort[i];
         int j = i - 1;

         while(j >= 0 && Sort[j] > key)
         {
            Sort[j + 1] = Sort[j];
            j = j - 1;
            
         }
         Sort[j + 1] = key; 
      }
   }

   public static void print(int[] Sort) {
      System.out.println("Sorted Numbers");
      for(int i = 0; i < Sort.length;i++)
      {
         System.out.print(Sort[i] + " ");
      }
      System.out.println();
   }
   public static void main(String[] args) {
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
