package pl.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvanceSudokuBoard extends SudokuBoard {

   public AdvanceSudokuBoard(int[][] boardTab) {
      super(boardTab);
   }

   public int[] getPossibleValues(SudokuCoords sudokuCoords) {
      List<Integer> possibleValues = IntStream.iterate(1, k -> k + 1).limit(10).mapToObj(k->k).collect(Collectors.toList());
      List<Integer> column = Arrays.stream(super.getColumn(sudokuCoords.getSudokuCoordX())).mapToObj(k->k).collect(Collectors.toList());
      List<Integer> rows = Arrays.stream(super.getRow(sudokuCoords.getSudokuCoordY())).mapToObj(k->k).collect(Collectors.toList());
      List<Integer> smallSquare = Arrays.stream(super.getSquare(sudokuCoords)).flatMapToInt(Arrays::stream).mapToObj(k->k).collect(Collectors.toList());
      Set<Integer> notPossibleValues = new HashSet<>();
      notPossibleValues.addAll(column);
      notPossibleValues.addAll(rows);
      notPossibleValues.addAll(smallSquare);
      return possibleValues.stream().filter(pv->notPossibleValues.stream().anyMatch(npv->npv.equals(pv))).mapToInt(k->k).toArray();
   }

}
