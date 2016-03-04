
import java.util.*;


// CtCI5 2.3
public class DeleteGivenNode<T> {

  private class Node {
    private T item;
    private Node next;
  }

  public boolean deleteGivenNode(Node nodeToDelete) {
    if (nodeToDelete == null) {
      return false;
    }
    if (nodeToDelete.next == null) {
      nodeToDelete = null;
      return true;
    }
    nodeToDelete.item = nodeToDelete.next.item;
    nodeToDelete = nodeToDelete.next;
    return true;
  }
}
