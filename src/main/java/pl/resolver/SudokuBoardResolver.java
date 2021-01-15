package pl.resolver;

import pl.model.SudokuBoard;
import pl.model.SudokuCoords;

import java.util.HashSet;
import java.util.Set;

public abstract class SudokuBoardResolver<T extends SudokuBoard> {
   protected final SudokuCoords START_SUDOKU_COORDS = SudokuCoords.of(0, 0);
   protected T sudokuBoard;
   protected boolean isResolved;
   private Set<SudokuBoard> resolvedSudokuBoards;

   public SudokuBoardResolver(T sudokuBoard) {
      this.sudokuBoard = (T) sudokuBoard.cloneBoard();
      resolvedSudokuBoards = new HashSet<>();
      isResolved = false;
   }

   void resolve() {
      resolver(nextZeroCoords(START_SUDOKU_COORDS));
   }

   abstract void resolver(SudokuCoords sudokuCoords);

   public Set<SudokuBoard> getResolves() {
      if (!isResolved)
         resolve();
      return resolvedSudokuBoards;
   }

   public void addResolverSudokuBoard(SudokuBoard sudokuBoard) {
      isResolved = true;
      this.resolvedSudokuBoards.add(sudokuBoard);
   }

   public void addResolverSudokuBoard(Set<SudokuBoard> sudokuBoard) {
      isResolved = true;
      this.resolvedSudokuBoards.addAll(sudokuBoard);
   }

   protected SudokuCoords nextZeroCoords(SudokuCoords currentCoords) {
      for (int y = currentCoords.getY(); y < 9; y++)
         for (int x = (y == currentCoords.getY()) ? currentCoords.getX() : 0; x < 9; x++) {
            SudokuCoords pointerCoords = SudokuCoords.of(x, y);
            if (sudokuBoard.getValue(pointerCoords) == 0)
               return pointerCoords;
         }
      return null;
   }
}

