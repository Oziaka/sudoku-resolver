package pl.validator;

import pl.model.SudokuBoard;
import pl.model.SudokuCoord;
import pl.model.SudokuCoords;

public class SudokuBoardValidator {
   private SudokuBoard sudokuBoard;

   public SudokuBoardValidator(SudokuBoard sudokuBoard) {
      this.sudokuBoard = sudokuBoard;
   }

   public boolean valid(SudokuCoords sudokuCoords) {
      return validColumn(sudokuCoords.getSudokuCoordX()) && validRow(sudokuCoords.getSudokuCoordY()) && validSquare(sudokuCoords);
   }

   private boolean validColumn(SudokuCoord x) {
      int[] column = sudokuBoard.getColumn(x);
      for (int i = 0; i < column.length; i++) {
         if (column[i] == 0) continue;
         for (int j = i + 1; j < column.length; j++)
            if (column[i] == column[j])
               return false;
      }
      return true;
   }

   private boolean validRow(SudokuCoord y) {
      int[] row = sudokuBoard.getRow(y);
      for (int i = 0; i < row.length; i++) {
         if (row[i] == 0) continue;
         for (int j = i + 1; j < row.length; j++)
            if (row[i] == row[j])
               return false;
      }
      return true;
   }

   private boolean validSquare(SudokuCoords sudokuCoords) {
      int[][] square = sudokuBoard.getSquare(sudokuCoords);
      for (int y = 0; y < square.length; y++)
         for (int x = 0; x < square[y].length; x++) {
            if (square[y][x] == 0) continue;
            for (int j = y + 1; j < square.length; j++)
               for (int i = x + 1; i < square[y].length; i++)
                  if (square[y][x] == square[j][i])
                     return false;
         }
      return true;
   }
}
