
import java.util.*;


// CtCI5 9.8
public class CentRepresentation {

  private static final Map<Integer, Integer> COINS = new HashMap<Integer, Integer>();
  static {
    COINS.put(25, 10);
    COINS.put(10, 5);
    COINS.put(5, 1);
  }

  public int waysToCountCents(int n, int coin) {
    if (coin == 1)
      return 1;

    int ways = 0;
    for (int i=0; i*coin<=n; i++) {
      ways += waysToCountCents(n-i*coin, COINS.get(coin));
    }
    return ways;
  }

}

// for 10
// q=0
// d->	for 0
//		1
// ni->	for 5
//		2
// 4

// for 15
// q=0
// d->	for 5
//		2
// ni->	for 10
//		4
// 7
// 10 5
// 10 11111
// 5 5 5
// 5 5 11111
// 5 1111111111
// 111111111111111
