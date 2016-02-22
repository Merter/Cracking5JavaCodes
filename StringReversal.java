
import java.util.*;


// CtCI5 1.2
public class StringReversal {

  private static final int END_NOT_FOUND = -1;

  public void reverse(char[] str) {
    int endPosition = findEnd(str);
    for (int i=0; i<endPosition/2; i++) {
      swap(str, i, endPosition-i-1);
    }
  }

  private int findEnd(char[] str) {
    for (int i=0; i<str.length; i++) {
      if (str[i] == '\0') {
        return i;
      }
    }
    return END_NOT_FOUND;
  }

  private void swap(char[] str, int from, int to) {
    char temp = str[from];
    str[from] = str[to];
    str[to] = temp;
  }

  public void recursiveReverse(char[] str) {
    int endPosition = findEnd(str);
    reverse(str, 0, endPosition-1);
  }

  private void reverse(char[] str, int pos, int end) {
    if (pos >= end) 
      return;
    swap(str, pos++, end--);
    reverse(str, pos, end);
  }

  public void reverseWithStack(char[] str) {
    int endPosition = findEnd(str);
    if (endPosition == END_NOT_FOUND)
      return;
    ArrayDeque<Character> stack = new ArrayDeque<Character>(endPosition);
    for (int i=0; i<endPosition; i++) {
      stack.push(str[i]);
    }
    for (int i=0; !stack.isEmpty(); i++) {
      str[i] = stack.pop();
    }
  }
}
