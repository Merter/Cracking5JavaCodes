
import java.util.*;


// CtCI5 11.6
public class SortedMatrix<T extends Comparable<T>> {

  public int[] findInMatrixBinary(T key, T[][] matrix) {
    if (key == null)
      return null;
    if (matrix == null)
      return null;
    if (matrix[0] == null)
      return null;
    return findInMatrixRange(key, matrix, 0, matrix[0].length-1, 0, matrix.length-1);
  }

  private int[] findInMatrixRange(T key, T[][] matrix, int beginCol, int endCol, int beginRow, int endRow) {
    if (beginCol > endCol)
      return null;
    if (beginRow > endRow)
      return null;
    int midCol = (beginCol+endCol) / 2;
    int comp = matrix[beginRow][midCol].compareTo(key);
    if (comp == 0)
      return new int[] {midCol, beginRow};
    if (comp < 0) {
      return findInMatrixRange(key, matrix, beginCol, midCol-1, beginRow, endRow);
    }
    int[] result = findInMatrixRange(key, matrix, midCol+1, endCol, beginRow, endRow);
    if (result != null)
      return result;
    return findInMatrixRange(key, matrix, beginCol, midCol, beginRow+1, endRow);
  }

  public int[] findInSortedMatrix(T key, T[][] matrix) {
    return findInSortedMatrixByRowColumnElimination(key, matrix, matrix.length-1, 0);
  }

  private int[] findInSortedMatrixByRowColumnElimination(T key, T[][]matrix, int row, int col) {
    if (row < 0)
      return null;
    if (col == matrix[row].length)
      return null;
    int cmp = key.compareTo(matrix[row][col]);
    if (cmp == 0)
      return new int[] {row, col};
    if (cmp < 0)
      return findInSortedMatrixByRowColumnElimination(key, matrix, row-1, col);
    return findInSortedMatrixByRowColumnElimination(key, matrix, row, col+1);
  }
}

