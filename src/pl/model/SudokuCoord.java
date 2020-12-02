package pl.model;

import pl.exception.ValidationSudokuCoordException;

public class SudokuCoord {
   private final int min = 0;
   private final int max = 8;
   private int coord;

   public SudokuCoord(int coord) {
      validCoord(coord);
      this.coord = coord;
   }

   public int getCoord() {
      return coord;
   }

   private void validCoord(int coord) {
      if (coord < min || coord > max)
         throw new ValidationSudokuCoordException("Coords should be beetween " + min + " and " + max);
   }

   @Override
   public String toString() {
      return String.valueOf(coord);
   }
}
