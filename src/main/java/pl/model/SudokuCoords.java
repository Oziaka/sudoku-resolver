package pl.model;

import java.util.Objects;

public class SudokuCoords {

   private SudokuCoord x;
   private SudokuCoord y;

   public SudokuCoords(SudokuCoord x, SudokuCoord y) {
      this.x = x;
      this.y = y;
   }

   public static SudokuCoords of(int x, int y) {
      return new SudokuCoords(new SudokuCoord(x), new SudokuCoord(y));
   }

   public int getX() {
      return x.getCoord();
   }

   @Override
   public String toString() {
      return "SudokuCoords{" +
         "x=" + x +
         ", y=" + y +
         '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SudokuCoords that = (SudokuCoords) o;
      return Objects.equals(x, that.x) &&
         Objects.equals(y, that.y);
   }

   @Override
   public int hashCode() {
      return Objects.hash(x, y);
   }

   public int getY() {
      return y.getCoord();
   }

   public SudokuCoord getSudokuCoordX() {
      return x;
   }

   public SudokuCoord getSudokuCoordY() {
      return y;
   }
}
