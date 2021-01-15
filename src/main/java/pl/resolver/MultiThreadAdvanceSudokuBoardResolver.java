package pl.resolver;

import pl.model.AdvanceSudokuBoard;
import pl.model.SudokuCoords;

public class MultiThreadAdvanceSudokuBoardResolver extends SudokuBoardResolver<AdvanceSudokuBoard> {

   private final int threadCount;

   public MultiThreadAdvanceSudokuBoardResolver(AdvanceSudokuBoard advanceSudokuBoard, int threadCount) {
      super(advanceSudokuBoard.cloneBoard());
      this.threadCount = threadCount;
   }

   @Override
   void resolver(SudokuCoords currentCoords) {
      for (int value : sudokuBoard.getPossibleValues(currentCoords)) {
         sudokuBoard.set(currentCoords, value);
         SudokuCoords nextCoords = nextZeroCoords(currentCoords);
         if (nextCoords != null) {
            MultiThreadAdvanceSudokuBoardResolver mtasbr = new MultiThreadAdvanceSudokuBoardResolver(sudokuBoard, threadCount - 1);
            if (threadCount > 0)
               new Thread(() -> mtasbr.resolver(nextCoords)).start();
            else
               mtasbr.resolver(nextCoords);
            addResolverSudokuBoard(mtasbr.getResolves());
         } else
            addResolverSudokuBoard(sudokuBoard);
      }
      isResolved = true;
   }
}
