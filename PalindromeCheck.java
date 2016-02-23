
import java.util.*;


// CtCI5 2.7
public class PalindromeCheck <T extends Comparable<T>> {

  private class Node {
    private T item;
    private Node next;
  }

  private Node head;

  public boolean isPalindrome() {
    if (head == null) return true;
    Node current = head;
    int k = 0;
    Node mirrorOfCurrent = getKthToLast(k);
    while (mirrorOfCurrent != current) {
      if (current.item.compareTo(mirrorOfCurrent.item) != 0) return false;
      current = current.next;
      k++;
      mirrorOfCurrent = getKthToLast(k);
    }
    return true;
  }

  private Node getKthToLast(int k) {
    Node runner = head;
    for (int i=0; i<k+1; i++) {
      runner = runner.next;
    }
    Node current = head;
    while (runner != null) {
      current = current.next;
      runner = runner.next;
    }
    return current;
  }

  public boolean isPalindromeByReversing() {
    if (head == null) return true;
    Node reversed = reverse(head);
    Node current = head;
    Node currentReversed = reversed;
    while (current != null) {
      if (current.item.compareTo(currentReversed.item) != 0) return false;
      current = current.next;
      currentReversed = currentReversed.next;
    }
    return true;
  }

  private Node reverse(Node head) {
    ArrayDeque<Node> stack = new ArrayDeque<Node>();
    for (Node current=head; current!=null; current=current.next) {
      stack.push(current);
    }
    Node reverseHead = null;
    Node endOfReverse = null;
    while (stack.size() > 0) {
      Node current = stack.pop();
      if (endOfReverse == null) {
        reverseHead = current;
      } else {
        endOfReverse.next = current;
      }
      endOfReverse = current;
    }
    return reverseHead;
  }

  public boolean isPalindromeBySlowFastRunners() {
    if (head == null) return true;
    Node movesByOne = head;
    Node movesByTwo = head;
    boolean oddElements = true;
    ArrayDeque<Node> stack = new ArrayDeque<Node>();
    while (true) {
      stack.push(movesByOne);
      movesByOne = movesByOne.next;
      movesByTwo = movesByTwo.next;
      if (movesByTwo == null) break;
      movesByTwo = movesByTwo.next;
      if (movesByTwo == null) {
        oddElements = false;
        break;
      }
    }
    if (oddElements) stack.pop();
    while (movesByOne != null) {
      Node stackNode = stack.pop();
      if (movesByOne.item.compareTo(stackNode.item) != 0) return false;
      movesByOne = movesByOne.next;
    }
    return true;
  }

  public boolean isPalindromeRecursive() {
    int lengthOfList = length()-1;
    ArrayDeque<Node> stack = recurse(head, lengthOfList);
    if (stack == null) return false;
    return true;
  }

  private int length() {
    int lengthOfList = 0;
    for (Node current=head; current!=null; current=current.next) lengthOfList++;
    return lengthOfList;
  }

  private ArrayDeque<Node> recurse(Node node, int length) {
    if (length==0 || length==1) {
      ArrayDeque<Node> stack = new ArrayDeque<Node>();
      if (length == 1) {
        node = node.next;
      }
      while (node != null) {
        stack.push(node);
        node = node.next; 
      }
      return stack;
    }
    ArrayDeque<Node> stack = recurse(node.next, length-2);
    if (stack == null) return null;
    Node stackNode = stack.pop();
    if (stackNode.item.compareTo(node.item) != 0) return null;
    return stack;
  }
}


// a b f b a
// a b f f b a
// 
