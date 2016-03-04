
import java.util.*;


// CtCI5 2.6
public class LoopDetection {

  private class Node {
    private Object item;
    private Node next;
  }

  private Node linkedList;

  public boolean hasLoop() {
    Node movesByOne = linkedList;
    Node movesByTwo = linkedList;
    while (movesByOne != movesByTwo) {
      if (movesByOne == null) return false;
      if (movesByTwo == null) return false;
      movesByOne = movesByOne.next;
      movesByTwo = movesByTwo.next;
      if (movesByTwo != null) movesByTwo = movesByTwo.next;
      else return false;		
    }
    return true;
  }

  public Node findStartOfLoop() {
    Node movesByOne = linkedList;
    Node movesByTwo = linkedList;
    while (movesByOne != movesByTwo) {
      if (movesByOne == null) return null;
      if (movesByTwo == null) return null;
      movesByOne = movesByOne.next;
      movesByTwo = movesByTwo.next;
      if (movesByTwo != null) movesByTwo = movesByTwo.next;
      else return null;
    }
    // return the movesByOne to head and move both of them one by one
    movesByOne = linkedList;
    while (movesByOne != movesByTwo) {
      movesByOne = movesByOne.next;
      movesByTwo = movesByTwo.next;
    }
    return movesByOne;
  }
}
