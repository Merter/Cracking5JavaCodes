
import java.util.*;


// CtCI5 5.6
public class OddAndEvenBitSwapper {

  public int swapBits(int value) {
    int mask = 0;
    for (int i=1; i<Integer.MAX_VALUE; i*=4) mask += i;
    return (((value & mask) << 1) | ((value & (~mask)) >>> 1));
  }

}
