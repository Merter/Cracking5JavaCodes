
import java.util.*;


// CtCI5 11.5
public class EmptyStrings {

  public int findKeyIn(String key, String[] content) {
    return findKeyInRange(key, content, 0, content.length-1);
  }

  private int findKeyInRange(String key, String[] content, int begin, int end) {
    if (begin > end)
      return -1;
    int mid = begin + (end-begin)/2;
    if (content[mid].equals(key))
      return mid;
    if (!(content[mid].equals(""))) {
      if (key.compareTo(content[mid]) > 0) {
        return findKeyInRange(key, content, mid+1, end);
      } else {
        return findKeyInRange(key, content, begin, mid-1);
      }
    }
    int realMid = mid;
    while (content[mid].equals("")) {
      if (mid > end) {
        return findKeyInRange(key, content, begin, realMid-1);
      }
      mid++;
    }
    if (content[mid].equals(key))
      return mid;
    if (key.compareTo(content[mid]) > 0) {
      return findKeyInRange(key, content, mid+1, end);
    } else {
      return findKeyInRange(key, content, begin, mid-1);
    }
  }

}
