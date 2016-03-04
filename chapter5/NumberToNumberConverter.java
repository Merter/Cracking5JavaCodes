
import java.util.*;


// CtCI5 5.5
public class NumberToNumberConverter {

  public int bitsRequiredToConvert(int A, int B) {
    int xor = A ^ B;
    int digitCounter = 0;
    int mask = 1;
    for (int i=0; i<Integer.SIZE; i++)
      if ((xor & mask) != 0) digitCounter++;
    mask <<= 1;
    return  digitCounter;
  }
}
