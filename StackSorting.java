
import java.util.*;


// CtCI5 3.6
public class StackSorting<T extends Comparable<T>> {

  private ArrayDeque<T> auxStack = new ArrayDeque<T>();

  public void sortStack(ArrayDeque<T> mainStack) {
    while (mainStack.size() > 0) {
      T current = mainStack.pop();
      if (auxStack.size() == 0) auxStack.push(current);
      else {
        T auxItem = auxStack.peekLast();
        int compResult = auxItem.compareTo(current);
        if (compResult > 0) auxStack.push(current);
        else putIntoItsPlace(current, mainStack);
      }		
    }
    mainStack = auxStack;
  }

  private void putIntoItsPlace(T current, ArrayDeque<T> mainStack) {
    while (true) {
      if (auxStack.size() == 0) {
        auxStack.push(current);
        break;			
      }
      if (auxStack.peekLast().compareTo(current) >= 0) {
        auxStack.push(current);
        break;
      }
      mainStack.push(auxStack.pop());
    }	
  }

}
