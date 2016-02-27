
import java.util.*;


// CtCI5 9.3
public class MagicIndex {

  public int getMagicIndexBruteForce(int[] numbers) {
    for (int i=0; i<numbers.length; i++) {
      if (i == numbers[i]) {
        return i;
      }
    }
    return -1; 
  }

  public int getMagicIndexFromDistinctSortedNumbers(int[] numbers) {
    int begin = 0;
    int end = numbers.length-1;
    while (begin < end) {
      int mid = begin + (end-begin)/2;
      if (numbers[mid] == mid)
        return mid;
      if (mid < numbers[mid])
        end = mid-1;
      else
        begin = mid+1;
    }
    return -1;
  }

  public int getMagicIndexFromNondistinctSortedNumbers(int[] numbers) {
    return getMagicIndexInRangeModified(numbers, 0, numbers.length-1);
  }

  private int getMagicIndexInRangeModified(int[] numbers, int begin, int end) {
    if (begin > end) {
      return -1;
    }
    int mid = begin + (end-begin)/2;
    if (numbers[mid] == mid) {
      return mid;
    }
    if (numbers[mid] < mid) {
      int index = getMagicIndexInRangeModified(numbers, mid+1, end);
      if (index >= 0) {
        return index;
      }
      return getMagicIndexInRangeModified(numbers, begin, numbers[mid]);
    }
    int index = getMagicIndexInRangeModified(numbers, begin, mid-1);
    if (index >= 0) {
      return index;
    }
    return getMagicIndexInRangeModified(numbers, numbers[mid], end);
  }

}
