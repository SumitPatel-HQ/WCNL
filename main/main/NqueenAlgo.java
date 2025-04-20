
/**
 * N-Queens Algorithm implementation.
 * This class solves the N-Queens problem using backtracking.
 * The problem is to place N queens on an N×N chessboard so that no queens attack each other.
 * 
 * Time Complexity: O(N!), where N is the board size. The algorithm tries all possible placements
 * in the worst case, resulting in exponential time complexity.
 * 
 * Space Complexity: O(N²) for the board representation and O(N) for the recursion stack.
 */
public class NqueenAlgo {
   static final int N = 4; 
   static int solutionCount = 0;

   static void printSolution(char board[][]) 
   {     
       solutionCount++;
       System.out.println("Solution #" + solutionCount + ":");
       
       System.out.print("    ");
       for (int j = 0; j < N; j++) {
           System.out.print(j + "   ");
       }
       System.out.println();
       
       System.out.print("  +");
       for (int j = 0; j < N; j++) {
           System.out.print("---+");
       }
       System.out.println();
       
       for (int i = 0; i < N; i++) {
           System.out.print(i + " |");
           for (int j = 0; j < N; j++) {
               System.out.print(board[i][j] == 'Q' ? " Q |" : "   |");
           }
           System.out.println();
           
           System.out.print("  +");
           for (int j = 0; j < N; j++) {
               System.out.print("---+");
           }
           System.out.println();
       }
       System.out.println();
   }

   static boolean isSafe(char board[][], int row, int col) {
       for (int i = 0; i < row; i++) {
           if (board[i][col] == 'Q') {
               return false;
           }
       }

       for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
           if (board[i][j] == 'Q') {
               return false;
           }
       }

       for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
           if (board[i][j] == 'Q') {
               return false;
           }
       }

       return true;
   }

   static void solveNQueens(char board[][], int row) {
       if (row == N) {
           printSolution(board);
           return;
       }

       for (int col = 0; col < N; col++) {
           if (isSafe(board, row, col)) {
               board[row][col] = 'Q';
               solveNQueens(board, row + 1); 
               board[row][col] = '-';
           }
       }
   }

   public static void main(String[] args) {
       char board[][] = new char[N][N];
       
       for (int i = 0; i < N; i++) 
       {
           for (int j = 0; j < N; j++) 
           {
               board[i][j] = '-';
           }
       }
       
       solveNQueens(board, 0);
   }
}
