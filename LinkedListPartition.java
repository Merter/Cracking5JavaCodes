
import java.util.*;


// CtCI5 2.4
public class LinkedListPartition<T extends Comparable<T>> {

  private class Node {
    private T item;
    private Node next;
  }

  private Node head;

  public void partitionAround(T x) {
    if (x == null) return;
    Node headForSmallers = null;
    Node endForSmallers = null;
    Node current = head;
    Node previous = null;
    while (current != null) {
      int comparisonResult = x.compareTo(current.item);
      if (comparisonResult < 0) {			
        current = removeNodeFromLinkedList(head, previous, current);
        if (endForSmallers == null) {
          headForSmallers = current;
        } else {
          endForSmallers.next = current;
        }
        endForSmallers = current;
      }
      current = current.next;
    }

    if (headForSmallers != null) {
      endForSmallers.next = head;
      head = headForSmallers;
    }
  }

  private Node removeNodeFromLinkedList(Node head, Node previous, Node nodeToRemove) {
    if (previous == null) {
      head = nodeToRemove.next;
    } else {
      previous.next = nodeToRemove.next;
    }
    nodeToRemove.next = null;
    return nodeToRemove;
  }

  public void partitionAroundAlt(T x) {
    if (x == null) return;
    Node headOfGreaters = null;
    Node previous = null;
    Node current = head;
    while (current != null) {
      int comparison = x.compareTo(current.item);
      if (comparison >= 0) {
        if (previous == null) {
          head = current.next;
        } else {
          previous.next = current.next;
        }
        current.next = headOfGreaters;
        headOfGreaters = current;
      } else {
        previous = current;
        current = current.next;
      }
    }
    if (previous == null) {
      head = headOfGreaters;
    } else {
      previous.next = headOfGreaters;
    }
  }

}


// 4 - 5 - 2 - 8 - 1 - 6
// x=3
// 2 - 1 - 4 - 5 - 8 - 6

// 1 - 2 - 1 - 1 - 2 - 1 - 2 - 0
// 5 - 6 - 4 - 3 - 9
