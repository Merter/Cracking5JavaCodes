
import java.util.*;


// CtCI5 11.3
public class SearchingInRotatedArray {

  private static final int NOT_FOUND = -1;

    public int findKeyIn(int key, int[] rotated) {
      return findKeyRecursivelyIn(key, rotated, 0, rotated.length);
    }

  private int findKeyRecursivelyIn(int key, int[] rotated, int begin, int end) {
    if (begin > end)
      return NOT_FOUND;

    int mid = begin + (end-begin)/2;  // not to overflow if the array is too big
    if (rotated[mid] == key)
      return mid;

    boolean leftIsSorted = false;
    // if left half is sorted or right half is unsorted
    if (rotated[begin]<rotated[mid] || rotated[end]<rotated[mid])
      leftIsSorted = true;
    boolean rightIsSorted = false;
    // if right half is sorted or left half is unsorted
    if (rotated[mid]<rotated[end] || rotated[mid]<rotated[begin])
      rightIsSorted = true;

    if (leftIsSorted) {
      if (rotated[begin]<=key && key<=rotated[mid])
        return findKeyRecursivelyIn(key, rotated, begin, mid-1);
      return findKeyRecursivelyIn(key, rotated, mid+1, end);
    }
    if (rightIsSorted) {
      if (rotated[mid]<=key && key<=rotated[end])
        return findKeyRecursivelyIn(key, rotated, mid+1, end);
      return findKeyRecursivelyIn(key, rotated, begin, mid-1);
    }
    // values of begin, mid and end are all the same
    // do not decide on which half is sorted
    // search for the key in left then right
    int foundIn = findKeyRecursivelyIn(key, rotated, begin, mid-1);
    if (foundIn == NOT_FOUND)
      return findKeyRecursivelyIn(key, rotated, mid+1, end);
    return foundIn;
  }
}

