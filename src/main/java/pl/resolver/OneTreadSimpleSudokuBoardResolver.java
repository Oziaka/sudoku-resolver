package pl.resolver;

import pl.model.SudokuBoard;
import pl.model.SudokuCoords;
import pl.validator.SudokuBoardValidator;

//TODO From time to time do not work properly, but i do not known how
public class OneTreadSimpleSudokuBoardResolver extends SudokuBoardResolver<SudokuBoard> {


   public OneTreadSimpleSudokuBoardResolver(SudokuBoard sudokuBoard) {
      super(sudokuBoard.cloneBoard());
   }


   void resolver(SudokuCoords currentCoords) {
      for (int value = 1; value < 10; value++) {
         sudokuBoard.set(currentCoords, value);
         if (new SudokuBoardValidator(sudokuBoard).valid(currentCoords)) {
            SudokuCoords nextCoords = nextZeroCoords(currentCoords);
            if (nextCoords != null) {
               OneTreadSimpleSudokuBoardResolver otssbr = new OneTreadSimpleSudokuBoardResolver(sudokuBoard);
               otssbr.resolver(nextCoords);
               addResolverSudokuBoard(otssbr.getResolves());
            } else {
               addResolverSudokuBoard(sudokuBoard);
            }
         }
      }
      isResolved = true;
   }

}
