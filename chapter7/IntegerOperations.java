
// CtCI5 7.4

public class IntegerOperations {

	public int subtract(int from, int n) {
		return from+negate(n);
	}
	
	private int negate(int n) {
		int neg = 0;
		if (n <= 0) {
			for (int i=n; i<0; i++)
				neg += 1;
		} else {
			for (int i=0; i<n; i++)
				neg += -1;
		}
		return neg;
	}

	public int multiply(int first, int second) {
		boolean isResultPositive = ((first>=0 && second>=0) || (first<0 && second<0));
		first = abs(first);
		second = abs(second);
		if (second > first) {
			int temp = first;
			first = second;
			second = temp;
		}
		int mult = 0;
		for (int i=0; i<second; i++)
			mult += first;
		return isResultPositive ? mult : negate(mult);
	}
	
	private int abs(int n) {
		int abs = n;
		if (n < 0) {
			for (int i=n; i<0; i++)
				abs += 1;
		}
		return abs;
	}

	public int divide(int divident, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		boolean isResultPositive = divisor > 0;
		divident = abs(divident);
		divisor = abs(divisor);
		int quo = 0;
		while (divident >= divisor) {
			quo++;
			divident = subtract(divident, divisor);
		}
		return isResultPositive ? quo : negate(quo);
	}

}
