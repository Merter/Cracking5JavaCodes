
// CtCI5 17.3
public class ZerosInFactorial {

	public int trailingZeroCount(int n) {
		int factor = 5;
		int result = 0;
		while (factor <= n) {
			result += n/factor;
			factor *= 5;
		}
		return result;
	}

	public int trailingZeroCountByDivision(int n) {
		int result = 0;
		while (n >= 5) {
			n /= 5;
			result += n;
		}
		return result;
	}
}
