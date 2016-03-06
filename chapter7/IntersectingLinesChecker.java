

// CtCI5 7.3

public class IntersectingLinesChecker {

	private class Line {
		private static final double ERROR = 0.000001;
	
		double yCoeff;
		double xCoeff;
		double intersect;
		
		Line (double yCoeff, double xCoeff, double intersect) {
			this.yCoeff = yCoeff;
			this.xCoeff = xCoeff;
			this.intersect = intersect;		
		}
		
		boolean doesIntersectWith(Line other) {
			if (this.yCoeff == 0) {
				if (other.yCoeff != 0)
					return false;
				if (this.xCoeff == 0) {
					if (other.xCoeff != 0)
						return false;
					return Math.abs(this.intersect - other.intersect) < ERROR;
				}
				if (other.xCoeff == 0)
					return false;
				return Math.abs(this.intersect/this.xCoeff - other.intersect/other.xCoeff) < ERROR;
			}
			if (other.yCoeff == 0)
				return false;
			if (this.xCoeff == 0) {
				if (other.xCoeff != 0)
					return false;
				return Math.abs(this.intersect/this.yCoeff - other.intersect/other.yCoeff) < ERROR;
			}
			if (other.xCoeff == 0)
				return false;
			return ((Math.abs(this.xCoeff/this.yCoeff - other.xCoeff/other.yCoeff) > ERROR) || 
				(Math.abs(this.intersect/this.yCoeff - other.intersect/other.yCoeff) < ERROR));
		}		
	}
	
	public boolean doesIntersect(double y1, double x1, double i1, double y2, double x2, double i2) {
		return (new Line(y1, x1, i1)).doesIntersectWith(new Line(y2, x2, i2));
	}
}
