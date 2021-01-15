package pl.resolver;

import pl.model.AdvanceSudokuBoard;
import pl.model.SudokuCoords;

public class OneTreadAdvanceSudokuBoardResolver extends SudokuBoardResolver<AdvanceSudokuBoard> {


   public OneTreadAdvanceSudokuBoardResolver(AdvanceSudokuBoard advanceSudokuBoard) {
      super(advanceSudokuBoard.cloneBoard());
   }

    void resolver(SudokuCoords currentCoords) {
      for (int value : sudokuBoard.getPossibleValues(currentCoords)) {
         sudokuBoard.set(currentCoords, value);
         SudokuCoords nextCoords = nextZeroCoords(currentCoords);
         if (nextCoords != null) {
            OneTreadAdvanceSudokuBoardResolver otasbr = new OneTreadAdvanceSudokuBoardResolver(sudokuBoard);
            otasbr.resolver(nextCoords);
            addResolverSudokuBoard(otasbr.getResolves());
         } else {
            addResolverSudokuBoard(sudokuBoard);
         }
      }
      isResolved = true;
   }


}
