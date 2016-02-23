
import java.util.*;


// CtCI5 2.5
public class LinkedListAdder {

  private Node head1;
  private Node head2;

  private class Node {
    private int digit;
    private Node next;
  }

  public Node addReverseOrderedLists() {
    Node headOfResult = null;
    Node currentResult = null;
    Node current1 = head1;
    Node current2 = head2;
    boolean carry = false;
    while (true) {
      int digitSum = 0;
      if (current1 != null) {
        digitSum += current1.digit;
        current1 = current1.next;
      }
      if (current2 != null) {
        digitSum += current2.digit;
        current2 = current2.next;
      }
      if (carry) digitSum++;
      if (digitSum == 0) break;
      if (digitSum > 9) carry = true;
      Node newDigit = new Node();
      newDigit.digit = digitSum%10;
      if (currentResult == null) {
        headOfResult = newDigit;
        currentResult = newDigit;
      } else {
        currentResult.next = newDigit;
        currentResult = newDigit;			
      }	
    }
    return headOfResult;
  }

  public Node addReversedOrderedListsRecursively() {
    return easyAdditionRecursive(null, null, head1, head2, false);
  }

  private Node easyAdditionRecursive(Node result, Node endOfResult, Node remainingList1, Node remainingList2, boolean carry) {
    Node resultDigit = new Node();
    int sum = 0;
    if (remainingList1 != null) {
      sum += remainingList1.digit;
      remainingList1 = remainingList1.next;
    }
    if (remainingList2 != null) {
      sum += remainingList2.digit;
      remainingList2 = remainingList2.next;
    }
    if (carry) sum++;
    if (sum == 0) return result;
    if (sum >= 10) carry = true;
    resultDigit.digit = sum % 10;
    if (endOfResult == null) {
      result = resultDigit;
      endOfResult = resultDigit;
    } else {
      endOfResult.next = resultDigit;
      endOfResult = resultDigit;
    }
    return easyAdditionRecursive(result, endOfResult, remainingList1, remainingList2, carry);
  }

  public Node addLists() {
    reverseLinkedList(head1);
    reverseLinkedList(head2);
    return addReverseOrderedLists();
  }

  private void reverseLinkedList(Node head) {
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    for (Node current=head; current!=null; current=current.next) {
      stack.push(current.digit);
    }
    Node current = head1;
    while (stack.size() > 0) {
      current.digit = stack.pop();
      current = current.next;
    }	
  }

  public Node addListsByIntegerConversion() {
    int value1 = integerValueOfLinkedList(head1);
    int value2 = integerValueOfLinkedList(head2);
    int result = value1 + value2;
    return convertIntegerToLinkedList(result);
  }

  private int integerValueOfLinkedList(Node head) {
    int value = 0;
    for (Node current=head; current!=null; current=current.next) {
      value *= 10;
      value += current.digit;
    }
    return value;
  }

  private Node convertIntegerToLinkedList(int result) {
    Node head = null;
    Node current = null;
    Node prev = null;
    int digitCount = (int)Math.floor(Math.log10(result)+1);
    for (int i=digitCount-1; i>=0; i--) {
      current = new Node();
      current.digit = result / (int)Math.pow(10, i);
      result %= Math.pow(10, i);
      if (prev == null) head = current;
      else prev.next = current;
      prev = current;
    }
    return head;
  }

  public Node addListsByBruteForce() {
    Node headOfResult = null;
    boolean carry = false;
    int i=0;
    Integer i1 = getKthToLast(head1, i);
    Integer i2 = getKthToLast(head2, i);		
    while (i1!=null || i2!=null) {
      int digitSum = 0;
      if (i1 != null) digitSum += i1;
      if (i2 != null) digitSum += i2;
      if (carry) digitSum++;
      if (digitSum >= 10) carry = true;
      Node node = new Node();
      node.digit = digitSum % 10;
      node.next = headOfResult;
      headOfResult = node;
      i++;
      i1 = getKthToLast(head1, i);
      i2 = getKthToLast(head2, i);			
    }
    if (carry) {
      Node node = new Node();
      node.digit = 1;
      node.next = headOfResult;
      headOfResult = node;
    }
    return headOfResult;
  }	

  private int getKthToLast(Node head, int k) {
    Node runner = head;
    for (int i=0; i<k+1; i++) {
      runner = runner.next;
    }
    Node current = head;
    while (runner != null) {
      current = current.next;
      runner = runner.next;
    }
    return current.digit;
  }	

  public Node addListsByRecursion() {
    int length1 = lengthOfList(head1);
    int length2 = lengthOfList(head2);
    Node paddedHead1 = head1;
    Node paddedHead2 = head2;
    if (length1 > length2) {
      paddedHead2 = padListWithZeros(head2, length1-length2);
    }
    if (length2 > length1) {
      paddedHead1 = padListWithZeros(head1, length2-length1);
    }
    SumInfo sumInfo = new SumInfo();
    addListsByRecursion(paddedHead1, paddedHead2, sumInfo);
    return sumInfo.headOfResult;
  }

  private int lengthOfList(Node begin) {
    int nodeCounter = 0;
    for (Node current=begin; current!=null; current=current.next) {
      nodeCounter++;
    }
    return nodeCounter;
  }

  private Node padListWithZeros(Node begin, int padCount) {
    Node paddedHead = null;
    Node current = null;
    for (int i=0; i<padCount; i++) {
      Node zero = new Node();
      if (paddedHead == null) {
        paddedHead = zero;
        current = zero;
      } else {
        current.next = zero;
        current = zero;
      }
    }
    current.next = begin;
    return paddedHead;
  }

  private class SumInfo {
    private Node headOfResult;
    private Node endOfResult;
    private boolean carry;
  }

  private void addListsByRecursion(Node remaining1, Node remaining2, SumInfo sumInfo) {
    if (remaining1 == null) {
      if (sumInfo.carry) {
        Node resultDigit = new Node();
        resultDigit.digit = 1;
        sumInfo.endOfResult.next = resultDigit;
        sumInfo.endOfResult = resultDigit;
        sumInfo.carry = false;			
      }	
      return;
    }
    addListsByRecursion(remaining2.next, remaining2.next, sumInfo);
    int sum = 0;
    sum += remaining1.digit;
    sum += remaining2.digit;
    if (sumInfo.carry) sum++;
    Node resultDigit = new Node();
    resultDigit.digit = sum % 10;
    if (sum >= 10) sumInfo.carry = true;
    if (sumInfo.endOfResult == null) {
      sumInfo.headOfResult = resultDigit;
      sumInfo.endOfResult = resultDigit;
    } else {
      sumInfo.endOfResult.next = resultDigit;
      sumInfo.endOfResult = resultDigit;
    }
  }

}
