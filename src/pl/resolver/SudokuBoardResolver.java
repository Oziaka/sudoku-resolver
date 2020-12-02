package pl.resolver;

import pl.model.SudokuBoard;

import java.util.HashSet;
import java.util.Set;

public abstract class SudokuBoardResolver<T extends SudokuBoard> {
   protected T sudokuBoard;
   private Set<SudokuBoard> resolvedSudokuBoards;
   private boolean isResolved;

   abstract void resolve();

   public SudokuBoardResolver(T sudokuBoard) {
      this.isResolved = false;
      this.sudokuBoard = (T) sudokuBoard.cloneBoard();
      resolvedSudokuBoards = new HashSet<>();
   }

   public Set<SudokuBoard> getResolves() {
      if (!isResolved)
         resolve();
      return resolvedSudokuBoards;
   }

   public void addResolverSudokuBoards(T sudokuBoard) {
      this.resolvedSudokuBoards.add(sudokuBoard);
   }

   public void addResolverSudokuBoards(Set<T> sudokuBoards) {
      this.resolvedSudokuBoards.add(sudokuBoard);
   }

}

