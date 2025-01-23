import java.util.*;

public class SelectionSort
{
   
   public static void Selectionsort(int[] sort)
   {
      int n = sort.length;

      for(int i = 0; i < n-1;i++ )
      {
         int min = i;// min = 0
         for(int j=i+1; j<n ; j++) // j=1
         {
            if(sort[j] < sort[min]) // sort[1] < min (0)
            {
               min = j;
            }

            
         }
         int temp = sort[min];
            sort[min] = sort[i];
            sort[i] = temp;
      }
   }

   public static void Print(int[] sort)
   {
      for(int i=0; i< sort.length;i++)
      {
         System.out.print(sort[i] + " ");
      }
      System.out.println();
   }
   
   public static void main(String[] args) 
   {
      Scanner A = new Scanner(System.in);

      System.out.println("$$$This is Selection Sort Program$$$");
      System.out.println("\nEnter the Number of Elements:");
      int n = A.nextInt();

      int[] sort = new int[n];

      System.out.println("Enter The list of Number:");
      for(int i = 0; i < n; i++)
      {
         sort[i] = A.nextInt();
      }

      Selectionsort(sort);
      Print(sort);

      A.close();
   }
}
