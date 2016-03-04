
import java.util.*;


// CtCI5 5.3
public class NumberGeneratorWithSameNumberOfOnes {

  public int getNextSmallest(int number) {
    int mask = 1;
    int i = 0;
    while (i < Integer.SIZE) {
      if ((mask&number) == 1)
        break;
      mask <<= 1;
      i++;
    }

    int numberOfOnes = 0;
    while ((mask&number) == 1) {
      mask <<= 1;
      numberOfOnes++;
      i++;
    }
    number |= mask;

    mask = ~0;
    for (int j=0; j<=i; j++)
      mask <<= 1;
    number &= mask;

    mask = 0;
    for (int j=0; j<numberOfOnes-1; j++) {
      mask |= 1;
      mask <<= 1;
    }
    number |= mask;
    return number;
  }


  public int getPrevLargest(int number) {
    int mask = 1;
    int i = 0;
    while (i < Integer.SIZE) {
      if ((mask&number) == 1)
        break;
      mask <<= 1;
      i++;
    }

    int numberOfOnes = 0;
    while ((mask&number) == 1) {
      mask <<= 1;
      numberOfOnes++;
      i++;
    }
    number ^= (1<<(i-2));
    number ^= (1<<(i-numberOfOnes-1));
    return number;
  }
}
