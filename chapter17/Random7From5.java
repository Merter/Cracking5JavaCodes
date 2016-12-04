
import java.util.*;

// CTCI5 17.11
public class Random7From5 {

	public int rand7() {
		while (true) {
			int roll1 = rand5();
			int roll2 = rand5();
			if ((roll1==1 && roll2==3) || (roll1==2 && roll2==1) || (roll1==2 && roll2==2) ||(roll1==2 && roll2==3)) continue;
			return (roll1+roll2) % 7;
		}
	}

	private int rand5() {
		return new Random().nextInt(5);
	}

}