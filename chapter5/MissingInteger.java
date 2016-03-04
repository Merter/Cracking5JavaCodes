
import java.util.*;

// CtCI5 5.7
public class MissingInteger {

  private static final int[] numbers = {2,1,6,5,4,7,9,8,0};

  public int findMissingIntegerBitByBit() {
    int xorResult = 0;
    for (int i=0; i<=numbers.length; i++) {
      xorResult ^= i;
    }
    for (int j=0; j<Integer.SIZE; j++) {
      int xorBits = 0;
      for (int i=0; i<numbers.length; i++) {
        xorBits ^= fetch(j, i);
      }
      xorResult ^= (xorBits<<j);
    }
    return xorResult;
  }

  private int fetch(int j, int i) {
    if (i>numbers.length || i<0)
      return -1;
    if (j>Integer.SIZE-1 || j<0)
      return -1;
    return numbers[i] & (1<<j);
  }

  public int findMissingIntegerByCounting() {
    List<Integer> arrayIndicesWithMissingNumber = new LinkedList<Integer>();
    for (int i=0; i<numbers.length; i++) {
      arrayIndicesWithMissingNumber.add(i);
    }
    int missingNumber = 0;
    int mask = 1;
    for (int j=0; j<Integer.SIZE; j++) {
      List<Integer> forZeros = new LinkedList<Integer>();
      List<Integer> forOnes = new LinkedList<Integer>();
      for (int i : arrayIndicesWithMissingNumber) {
        if (fetch(j, i) == 0)
          forZeros.add(i);
        else
          forOnes.add(i);
      }
      if (forOnes.size() > forZeros.size()) {
        arrayIndicesWithMissingNumber = forZeros;
      } else {
        missingNumber |= mask;
        arrayIndicesWithMissingNumber = forOnes;
      }
      mask <<= 1;
    }
    return missingNumber;	
  }

}
