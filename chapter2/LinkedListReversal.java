
import java.util.*;


public class LinkedListReversal<T> {

  private class Node {
    private T item;
    private Node next;
  }

  private class BeginAndEnd {
    private Node begin;
    private Node end;

    public BeginAndEnd(Node begin, Node end) {
      this.begin = begin;
      this.end = end;
    }
  }

  private Node head;
  private Node current;

  public static void main(String[] args) {
    LinkedListReversal<Integer> llr = new LinkedListReversal<Integer>();
    for (int i=9; i>=0; i--) {
      llr.current = llr.new Node();
      llr.current.item = i;
      if (llr.head == null) llr.head = llr.current;
      else {
        llr.current.next = llr.head;
        llr.head = llr.current;
      }
    }
    llr.reverse();
    for (llr.current=llr.head; llr.current!=null; llr.current=llr.current.next) {
      System.out.println(llr.current.item);
    }
  }

  public void reverse() {
    if (head==null || head.next==null) return;
    // head = recurse(head).begin;
    head = alternativeRecurse(head).begin;
  }

  private BeginAndEnd recurse(Node previousNode) {
    if (previousNode.next.next == null) {
      previousNode.next.next = previousNode;
      Node head = previousNode.next;
      previousNode.next = null;
      return new BeginAndEnd(head, head.next);
    }
    BeginAndEnd be = recurse(previousNode.next);
    previousNode.next = null;
    be.end.next = previousNode;
    be.end = previousNode;
    return be;
  }

  private BeginAndEnd alternativeRecurse(Node node) {
    if (node.next == null)
      return new BeginAndEnd(node, node);
    BeginAndEnd be = alternativeRecurse(node.next);
    be.end.next = node;
    be.end = node;
    node.next = null;
    return be;
  }
}
