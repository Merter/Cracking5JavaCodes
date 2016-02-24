
import java.util.*;


// CtCI5 3.2
public class AlternativeStackWithMin<T extends Comparable<T>> {

  private ArrayDeque<T> stack;
  private ArrayDeque<T> minStack;

  public boolean isEmpty() {
    return stack.size() == 0;
  }

  public T peek() {
    if (isEmpty()) return null;
    return stack.peek();
  }

  public void push(T item) {
    if (isEmpty()) {
      minStack.push(item);
    } else {
      if (item.compareTo(minStack.peek()) <= 0) {
        minStack.push(item);
      }
    }
    stack.push(item);
  }

  public T pop() {
    if (stack.isEmpty()) return null;
    T item = stack.pop();
    if (minStack.peek().compareTo(item) == 0)
      minStack.pop();
    return item;
  }

  public T min() {
    if (stack.isEmpty()) return null;
    return minStack.peek();		
  }

}
