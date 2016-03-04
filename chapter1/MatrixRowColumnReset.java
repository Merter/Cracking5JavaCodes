
import java.util.*;


// CtCI5 1.7
public class MatrixRowColumnReset {

  public void resetElementsOfMatrix(int[][] matrix) {
    List<Integer> rowsToReset = new LinkedList<Integer>();
    List<Integer> columnsToReset = new LinkedList<Integer>();
    int rowSize = matrix.length;
    int columnSize = matrix[0].length;
    for (int row=0; row<rowSize; row++) {
      for (int column=0; column<columnSize; column++) {
        if (matrix[row][column] == 0) {
          rowsToReset.add(row);
          columnsToReset.add(column);
        }
      }
    }
    resetRowsAndColumns(matrix, rowsToReset, columnsToReset);
  }

  private void resetRowsAndColumns(int[][] matrix, List<Integer> rowsToReset, List<Integer> columnsToReset) {
    int rowSize = matrix.length;
    int columnSize = matrix[0].length;
    for (int row : rowsToReset) {
      for (int column=0; column<columnSize; column++) {
        matrix[row][column] = 0;
      }
    }
    for (int column : columnsToReset) {
      for (int row=0; row<rowSize; row++) {
        matrix[row][column] = 0;
      }
    }
  }
}
