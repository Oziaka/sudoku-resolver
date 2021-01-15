package pl;

import pl.model.SudokuBoard;
import pl.resolver.OneTreadSimpleSudokuBoardResolver;
import pl.resolver.SudokuBoardResolver;

public class Main {

   public static void main(String[] args) {

      int[][][] boards = {
         {
            {0, 0, 6, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 8, 7, 0, 6, 0, 9},
            {0, 0, 1, 0, 5, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 4, 0, 0, 0},
            {0, 7, 9, 0, 0, 2, 5, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0},
            {0, 1, 0, 0, 0, 0, 0, 6, 0},
            {0, 8, 0, 0, 1, 0, 0, 0, 3},
            {0, 0, 4, 0, 0, 3, 0, 9, 0}
         },
         {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
         }
      };
      timeCounter(() -> resolerRunnder(new OneTreadSimpleSudokuBoardResolver(new SudokuBoard(boards[1]))));
   }

   static void timeCounter(Runnable runnable) {
      long start = System.currentTimeMillis();
      runnable.run();
      System.out.println(System.currentTimeMillis() - start + "ms");
   }

   static void resolerRunnder(SudokuBoardResolver sudokuResolver) {
      System.out.println(sudokuResolver.getResolves().size());
      System.out.println(sudokuResolver.getResolves());
   }


}
