
import java.util.*;


// CtCI5 2.2
public class KthToLast<T> {

  private class Node {
    private T item;
    private Node next;
  }

  private Node head;

  public T getKthToLast(int k) {
    // a-b-c   1:c   2:b   3:a
    NodeInfo result = new NodeInfo();
    searchForRecursively(head, k, result);
    Node kthToLastNode = result.node;
    if (kthToLastNode == null) {
      return null;
    }
    return kthToLastNode.item;
  }

  private class NodeInfo {
    private Node node;
    private int pos;
  }

  private void searchForRecursively(Node current, int k, NodeInfo result) {
    if (current == null) {
      return;
    }
    searchForRecursively(current.next, k, result);
    result.pos++;
    if (result.pos == k) {
      result.node = current;
    }
  }

  public T getKthToLastIterative(int k) {
    Node runner = head;
    for (int i=0; i<k-1; i++) {
      if (runner == null) return null;
      runner = runner.next;
    }
    if (runner == null) return null;
    Node current = head;
    while (runner.next != null) {
      current = current.next;
      runner = runner.next;
    }
    return current.item;
  }

}
