
import java.util.*;


// CtCI5 3.5
public class MyQueue<T> {

  private ArrayDeque<T> stackMain = new ArrayDeque<T>();
  private ArrayDeque<T> stackAux = new ArrayDeque<T>();	

  public boolean isEmpty() {
    return stackMain.size() == 0;
  }

  public int size() {
    return stackMain.size();
  }

  public void enqueue(T item) {
    fillStackWithOther(stackMain, stackAux);
    stackMain.push(item);
    fillStackWithOther(stackAux, stackMain);
  }

  private void fillStackWithOther(ArrayDeque<T> from, ArrayDeque<T> to) {
    while (!from.isEmpty()) {
      to.push(from.pop());
    }	
  }

  public T dequeue() {
    return stackMain.pop();
  }

  public T peek() {
    return stackMain.peekLast();
  }

}
