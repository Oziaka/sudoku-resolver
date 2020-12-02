package pl.resolver;

import pl.model.AdvanceSudokuBoard;
import pl.model.SudokuCoords;

public class OneTreadSimpleSudokuBoardResolver extends SudokuBoardResolver<AdvanceSudokuBoard> {

   public static final SudokuCoords START_SUDOKU_COORDS = SudokuCoords.of(0, 0);

   public OneTreadSimpleSudokuBoardResolver(AdvanceSudokuBoard advanceSudokuBoard) {
      super(advanceSudokuBoard);
   }

   @Override
   void resolve() {
      resolver(firstZeroCoords(START_SUDOKU_COORDS));
   }

   private void resolver(SudokuCoords currentCoords) {
      for (int value : sudokuBoard.getPossibleValues(currentCoords)) {
         System.out.println(value);
      }
   }

   private SudokuCoords firstZeroCoords(SudokuCoords currentCoords) {
      if (currentCoords.getY() == 8)
         System.out.println(sudokuBoard);
      for (int y = currentCoords.getY(); y < 9; y++) {
         for (int x = (y == currentCoords.getY()) ? currentCoords.getX() : 0; x < 9; x++) {
            SudokuCoords pointerCoords = SudokuCoords.of(x, y);
            if (sudokuBoard.getValue(pointerCoords) == 0)
               return pointerCoords;
         }
      }
      return null;
   }

}
