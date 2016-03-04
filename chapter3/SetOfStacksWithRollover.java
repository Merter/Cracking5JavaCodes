
import java.util.*;


// CtCI5 3.3
public class SetOfStacksWithRollover<T> {

  private static final int THRESHOLD = 20;
  private ArrayList<ArrayDeque<T>> stacks;
  private int numberOfElements;
  private int endStack;

  public SetOfStacksWithRollover() {
    stacks = new ArrayList<ArrayDeque<T>>();
    stacks.add(new ArrayDeque<T>());
  }

  public boolean isEmpty() {
    return numberOfElements == 0;
  }

  public T peek() {
    return stacks.get(endStack).peekLast();
  }

  public T pop() {
    ArrayDeque<T> stackToPop = stacks.get(endStack);
    T item = stackToPop.pop();
    numberOfElements--;
    if (stackToPop.size() == 0) {
      if (endStack > 0) {
        stacks.remove(endStack--);
      }		
    }
    return item;
  }

  public void push(T item) {
    ArrayDeque stackToPush = stacks.get(endStack); 
    if (stackToPush.size() == THRESHOLD) {
      stacks.add(new ArrayDeque<T>());
      endStack++;
      stacks.get(endStack).push(item);		
    } else {
      stackToPush.push(item);
    }
    numberOfElements++;
  }

  public T popAt(int index) {
    if (index>endStack || index<0) return null;
    T topOfIndexStack = stacks.get(index).pop();
    while (index < endStack) {
      ArrayDeque<T> stackAux = new ArrayDeque<T>();
      index++;
      transferStacks(stacks.get(index), stackAux);
      stacks.get(index-1).push(stackAux.pop());
      transferStacks(stackAux, stacks.get(index));
    }
    if (stacks.get(endStack).size() == 0) endStack--;
    numberOfElements--;
    return topOfIndexStack;
  }

  private void transferStacks(ArrayDeque<T> from, ArrayDeque<T> to) {
    while (from.size() > 0) {
      to.push(from.pop());
    }
  }

}

// qr
// abc
// xyz
// de*
// feg
