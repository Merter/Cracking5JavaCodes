
import java.util.*;


// CtCI5 3.3
public class SetOfStacksWithoutRollover<T> {

  private static final int THRESHOLD = 20;
  private ArrayList<ArrayDeque<T>> stacks;
  private int numberOfElements;
  private int endStack;

  public SetOfStacksWithoutRollover() {
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
    while (endStack>0 && stacks.get(endStack).size()==0) endStack--;
    return item;
  }

  public void push(T item) {
    ArrayDeque<T> stackToPush = stacks.get(endStack); 
    if (stackToPush.size() == THRESHOLD) {
      endStack++;
      if (stacks.size() == endStack)
        stacks.add(new ArrayDeque<T>());
      stacks.get(endStack).push(item);		
    } else {
      stackToPush.push(item);
    }
    numberOfElements++;
  }

  public T popAt(int index) {
    if (index>endStack || index<0) return null;
    if (stacks.get(index).size() == 0) return null;
    T topOfIndexStack = stacks.get(index).pop();
    while (endStack>0 && stacks.get(endStack).size()==0) endStack--;
    numberOfElements--;
    return topOfIndexStack;		
  }

}
