
import java.util.*;


// CtCI5 3.5
public class MyOtherQueue<T> {

  private ArrayDeque<T> stackMain = new ArrayDeque<T>();
  private ArrayDeque<T> stackAux = new ArrayDeque<T>();	

  public boolean isEmpty() {
    return stackMain.size()==0 && stackAux.size()==0;
  }

  public int size() {
    return stackMain.size() + stackAux.size();
  }

  public void enqueue(T item) {
    stackMain.push(item);
  }

  public T dequeue() {
    if (isEmpty()) return null;
    if (stackAux.size() > 0) return stackAux.pop();
    fillStackWithOther(stackMain, stackAux);
    return stackAux.pop();
  }

  private void fillStackWithOther(ArrayDeque<T> from, ArrayDeque<T> to) {
    while (!from.isEmpty()) {
      to.push(from.pop());
    }	
  }

  public T peek() {
    if (isEmpty()) return null;
    if (stackAux.size() > 0) return stackAux.peekLast();
    fillStackWithOther(stackMain, stackAux);
    return stackAux.peekLast();
  }

}
