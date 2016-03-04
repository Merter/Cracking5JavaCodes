
import java.util.*;


// CtCI5 9.1
public class HoppingChild {

  public int stepCount(int n) {
    if (n < 0)
      return 0;
    if (n == 0)
      return 1;
    return stepCount(n-1) + stepCount(n-2) + stepCount(n-3);
  }

  public int iterativeStepCount(int n) {
    if (n < 0)
      return 0;
    if (n == 0)
      return 1;
    int threePrev = 0;
    int twoPrev = 0;
    int onePrev = 1;
    for (int i=0; i<n; i++) {
      int allSum = onePrev + twoPrev + threePrev;
      threePrev = twoPrev;
      twoPrev = onePrev;
      onePrev = allSum;
    }
    return onePrev;
  }

}


// n=1	1=>1
// n=2	11	2=>2
// n=3	111 21 12 3=>4
// n=4	1111 121 211 112 13 31=>6
// n=5	11111 1121 1211 2111 1112 113 131 311 221 212 122 23 32=>13
