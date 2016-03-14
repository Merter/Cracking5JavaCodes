
// CtCI5 9.11
import java.util.*;

public class ExpressionParantheser {

	private Map<ExpressionAndResult, Integer> resMap = new HashMap<ExpressionAndResult, Integer>();

	private class ExpressionAndResult {
		String expr;
		boolean result;
		
		@Override
		public boolean equals(Object other) {
			if (this == other)
				return true;
			if (!(other instanceof ExpressionAndResult))
				return false;
			ExpressionAndResult xnr = (ExpressionAndResult) other;
			if (!this.expr.equals(xnr.expr))
				return false;
			return this.result==xnr.result;
		}

		@Override		
		public int hashCode() {
			int hc = 17;
			hc = hc*31 + expr.hashCode();
			hc = hc*31 + (new Boolean(result)).hashCode();
			return hc;
		}
	}

	public int numberOfWays(String expr, boolean result) {
		return recursiveNumberOfWays(expr, result, 0, expr.length()-1);
	}
	
	private int recursiveNumberOfWays(String expr, boolean result, int begin, int end) {
		if (begin == end) {
			if (result) {
				if (expr.charAt(begin)=='1') {
					return 1;
				}
			} else {
				if (expr.charAt(begin)=='0') {
					return 1;
				}			
			}
			return 0;
		}
		ExpressionAndResult xnr = new ExpressionAndResult();
		xnr.expr = expr;
		xnr.result = result;
		Integer fromMap = resMap.get(xnr);
		if (fromMap != null)
			return fromMap;
		
		int totalCount = 0;
		for (int i=begin+1; i<end; i+=2) {
			char operator = expr.charAt(i);
			if (operator == '|') {
				if (result) {
					totalCount += recursiveNumberOfWays(expr, true, begin, i-1) * recursiveNumberOfWays(expr, true, i+1, end);
					totalCount += recursiveNumberOfWays(expr, true, begin, i-1) * recursiveNumberOfWays(expr, false, i+1, end);
					totalCount += recursiveNumberOfWays(expr, false, begin, i-1) * recursiveNumberOfWays(expr, true, i+1, end);
				} else {
					totalCount += recursiveNumberOfWays(expr, false, begin, i-1) * recursiveNumberOfWays(expr, false, i+1, end);
				}
			} else if (operator == '&') {
				if (result) {
					totalCount += recursiveNumberOfWays(expr, true, begin, i-1) * recursiveNumberOfWays(expr, true, i+1, end);
				} else {					
					totalCount += recursiveNumberOfWays(expr, false, begin, i-1) * recursiveNumberOfWays(expr, false, i+1, end);
					totalCount += recursiveNumberOfWays(expr, true, begin, i-1) * recursiveNumberOfWays(expr, false, i+1, end);
					totalCount += recursiveNumberOfWays(expr, false, begin, i-1) * recursiveNumberOfWays(expr, true, i+1, end);
				}
			} else if (operator == '^') {
				if (result) {
					totalCount += recursiveNumberOfWays(expr, true, begin, i-1) * recursiveNumberOfWays(expr, false, i+1, end);
					totalCount += recursiveNumberOfWays(expr, false, begin, i-1) * recursiveNumberOfWays(expr, true, i+1, end);
				} else {					
					totalCount += recursiveNumberOfWays(expr, false, begin, i-1) * recursiveNumberOfWays(expr, false, i+1, end);
					totalCount += recursiveNumberOfWays(expr, true, begin, i-1) * recursiveNumberOfWays(expr, true, i+1, end);
				}
			}
		}
		resMap.put(xnr, totalCount);
		return totalCount;
	}
}
