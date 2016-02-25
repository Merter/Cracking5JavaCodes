
import java.util.*;


// CtCI5 11.1
public class ArrayMerging<T extends Comparable<T>> {

  public void merge(T[] A, T[] B, int lastA, int lastB) {
    int indexA = lastA-1;
    int indexB = lastB-1;
    for (int fullIndex=lastA+lastB-1; fullIndex>indexA; fullIndex--) {
      if (indexB < 0)
        return;
      if (indexA < 0) {
        A[fullIndex] = B[indexB--];
        continue;
      }
      int comp = A[indexA].compareTo(B[indexB]);
      if (comp >= 0)
        A[fullIndex] = A[indexA--];
      else
        A[fullIndex] = B[indexB--];
    }
  }

  public void altMerge(T[] A, T[] B, int lastA, int lastB) {
    int indexA = lastA-1;
    int indexB = lastB-1;
    int fullIndex = lastA+lastB-1;
    while (indexA>=0 && fullIndex>indexA) {
      int comp = A[indexA].compareTo(B[indexB]);
      if (comp >= 0)
        A[fullIndex--] = A[indexA--];
      else
        A[fullIndex--] = B[indexB--];
    }
    while (indexB >= 0)
      A[fullIndex--] = B[indexB--];
  }
}
