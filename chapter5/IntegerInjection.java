
import java.util.*;


// CtCI5 5.1
public class IntegerInjection {

  public int injectInBetween(int M, int N, int i, int j) {
    M <<= i;
    N = cleanBitsBetween(N, i, j);
    return N | M;
  }

  private int cleanBitsBetween(int N, int begin, int end) {
    int mask = getMaskToCleanBitsBetween(begin, end);
    N &= mask;		
    return N;
  }

  private int getMaskToCleanBitsBetween(int begin, int end) {
    int mask = 1 << begin;
    for (int i=begin; i<end; i++) {
      mask = mask | mask<<1;
    }
    return ~mask;
  }

}
