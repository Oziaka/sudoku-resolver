package pl.model;

import pl.exception.ValidationBoardException;

public class SudokuBoard implements Cloneable {
   private final int numberOfColumns = 9;
   private final int numberOfRows = 9;
   private int boardTab[][];

   public SudokuBoard(int[][] boardTab) {
      validBoard(boardTab);
      this.boardTab = boardTab;
   }

   public int getValue(SudokuCoords sudokuCoords) {
      return boardTab[sudokuCoords.getY()][sudokuCoords.getX()];
   }

   public void set(SudokuCoords sudokuCoords, int newValue) {
      boardTab[sudokuCoords.getY()][sudokuCoords.getX()] = newValue;
   }

   private void validBoard(int[][] boardTab) {
      if (boardTab.length != numberOfRows)
         throw new ValidationBoardException("Board should have 9 rows and 9 columns");
      for (int[] rows : boardTab)
         if (rows.length != numberOfColumns)
            throw new ValidationBoardException("Board should have 9 rows and 9 columns");
   }

   @Override
   protected Object clone() {
      int[][] newBoardTab = new int[numberOfRows][numberOfColumns];
      for (int y = 0; y < numberOfColumns; y++) {
         newBoardTab[y] = boardTab[y].clone();
      }
      return new SudokuBoard(newBoardTab);
   }

   public SudokuBoard cloneBoard() {
      return (SudokuBoard) this.clone();
   }

   public String toString() {
      StringBuilder board = new StringBuilder(9 * 2 * 9);
      for (int y = 0; y < boardTab.length; y++) {
         for (int x = 0; x < boardTab[y].length; x++) {
            board.append(boardTab[y][x]).append(" ").append((x - 2) % 3 == 0 && x < 8 ? "| " : "");
         }
         board.append("\n").append((y - 2) % 3 == 0 && y < 8 ? "---------------------\n" : "");
      }
      return board.toString();
   }

   public void print() {
      System.out.println(this.toString());
   }

   public int[] getRow(SudokuCoord y) {
      return boardTab[y.getCoord()];
   }

   public int[] getColumn(SudokuCoord x) {
      int column[] = new int[9];
      for (int y = 0; y < 9; y++) {
         column[y] = boardTab[y][x.getCoord()];
      }
      return column;
   }

   public int[][] getSquare(SudokuCoords sudokuCoords) {
      int boardTabSmallSquare[][] = new int[3][3];
      int xSqure = sudokuCoords.getX() / 3;
      int ySqure = sudokuCoords.getY() / 3;
      for (int y = ySqure * 3, ySquareFill = 0; y < (ySqure * 3) + 3; y++, ySquareFill++) {
         for (int x = xSqure * 3, xSquareFill = 0; x < (xSqure * 3) + 3; x++, xSquareFill++) {
            boardTabSmallSquare[ySquareFill][xSquareFill] = boardTab[y][x];
         }
      }
      return boardTabSmallSquare;
   }
}
