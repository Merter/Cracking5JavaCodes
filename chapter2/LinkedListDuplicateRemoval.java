
import java.util.*;


// CtCI5 2.1
public class LinkedListDuplicateRemoval<U extends Comparable<U>> {

  public <T extends Comparable<T>> LinkedList<T> removeDuplicates(LinkedList<T> list) {
    LinkedList<T> uniqueList = new LinkedList<T>();
    // LinkedHashSet is used to preserve the initial ordering of the elements
    Set<T> set = new LinkedHashSet<T>();
    for (T item : list) {
      if (!set.contains(item)) {
        set.add(item);
      }
    }
    for (T item : set) {
      uniqueList.add(item);
    }
    return uniqueList;
  }

  private class Node {
    private U item;
    private Node next;
  }

  private class MyLinkedList {
    private Node head;
    private int size;
  }

  public void removeDuplicatesWithSet(MyLinkedList list) {
    Set<U> set = new HashSet<U>();
    Node prev = null;
    for (Node curr = list.head; curr!=null; curr=curr.next) {
      if (set.contains(curr.item)) {
        prev.next = curr.next;			
      } else {
        set.add(curr.item);
        prev = curr;			
      }
    }
  }

  public void removeDuplicates(MyLinkedList list) {
    for (Node curr=list.head; curr.next!=null; curr=curr.next) {
      Node prev = curr;
      for (Node runner=curr.next; runner!=null; runner=runner.next) {
        if (curr.item.compareTo(runner.item) == 0) {
          prev.next = runner.next;
        } else {
          prev = runner;
        }
      }
    }
  }	
}
