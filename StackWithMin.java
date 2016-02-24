
import java.util.*;


// CtCI5 3.2
public class StackWithMin<T extends Comparable<T>> {

  private class Node {
    private T item;
    private Node minWhenMeAtTop;
  }

  private ArrayDeque<Node> stack;

  public boolean isEmpty() {
    return stack.size() == 0;
  }

  public T peek() {
    if (isEmpty()) return null;
    return stack.peekLast().item;
  }

  public void push(T item) {
    Node newTop = new Node();
    newTop.item = item;
    if (isEmpty()) {
      newTop.minWhenMeAtTop = newTop;
    } else {
      if (item.compareTo(stack.peekLast().minWhenMeAtTop.item) < 0) {
        newTop.minWhenMeAtTop = newTop;
      } else {
        newTop.minWhenMeAtTop = stack.peekLast().minWhenMeAtTop;
      }
    }
    stack.push(newTop);
  }

  public T pop() {
    if (stack.isEmpty()) return null;
    return stack.pop().item;
  }

  public T min() {
    if (stack.isEmpty()) return null;
    return stack.peekLast().minWhenMeAtTop.item;		
  }

}
