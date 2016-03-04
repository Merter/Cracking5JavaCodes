
import java.util.*;

// CtCI5 3.1
public class ThreeStacks<E> {

  private ArrayList<E> array = new ArrayList<E>();
  private static final int STACK_COUNT = 3;
  private int[] tops = new int[STACK_COUNT];

  public ThreeStacks() {
    for (int i=0; i<STACK_COUNT; i++) {
      tops[i] = i-STACK_COUNT;
    }
  }

  public void push(E item, int stack) {
    if (stack<0 || stack>2) return;
    tops[stack] += STACK_COUNT;
    array.add(tops[stack], item);
  }

  public E pop(int stack) {
    if (isEmpty(stack)) return null;
    E item = array.get(tops[stack]);
    array.add(tops[stack], null);
    tops[stack] -= STACK_COUNT;
    return item;
  }
  
  public E peek(int stack) {
    if (isEmpty(stack)) return null;
    return array.get(tops[stack]);
  }

  public boolean isEmpty(int stack) {
    if (tops[stack] < 0) return true;
    return false;
  }
}
