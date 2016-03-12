
// CtCI5 7.5

public class HalvingSquares {

	private static final double ERROR = 0.00001;

	private class Square {
		Point lowerLeft;
		double side;
		
		@Override
		public boolean equals(Object other) {
			if (this == other)
				return true;
				
			if (!(other instanceof Square))
				return false;
				
			Square otherSquare = (Square)other;
			if (!this.lowerLeft.equals(otherSquare.lowerLeft))
				return false;
			if (Math.abs(this.side - otherSquare.side) > ERROR)
				return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = result * 31 + lowerLeft.hashCode();
			long doubleHash = Double.doubleToLongBits(side);
			result = result * 31 + (int) (doubleHash ^ (doubleHash >>> 32));
			return result;
		}	
		
		public Point center() {
			Point center = new Point();
			center.x = lowerLeft.x+(side/2.0);
			center.y = lowerLeft.y+(side/2.0);
			return center;
		}
	}
	
	private class Point {
		double x;
		double y;
		
		@Override
		public boolean equals(Object other) {
			if (this == other)
				return true;
				
			if (!(other instanceof Point))
				return false;
				
			Point otherPoint = (Point)other;
			if (Math.abs(this.x - otherPoint.x) > ERROR)
				return false;
			if (Math.abs(this.y - otherPoint.y) > ERROR)
				return false;
			return true;	
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			long doubleHash = Double.doubleToLongBits(x);
			result = result * 31 + (int) (doubleHash ^ (doubleHash >>> 32));
			doubleHash = Double.doubleToLongBits(y);
			result = result * 31 + (int) (doubleHash ^ (doubleHash >>> 32));
			return result;
		}	
	}

	private class Line {
		double yCoeff;
		double xCoeff;
		double intersect;
		
		public Line(Point p1, Point p2) {
			if (p1.equals(p2) || (Math.abs(p1.y-p2.y) < ERROR)) {
				this.yCoeff = 1;
				this.xCoeff = 0;
				this.intersect = p1.y;
				return;
			}
			if (Math.abs(p1.x-p2.x) < ERROR) {
				this.yCoeff = 0;
				this.xCoeff = 1;
				this.intersect = p1.x;
				return;
			}
			this.yCoeff = 1;
			this.xCoeff = (p2.y-p1.y) / (p2.x-p1.x);
			this.intersect = p1.x * (p2.y-p1.y) / (p2.x-p1.x) + p1.y;
		}
	}

	public Line halvingLine(Square sq1, Square sq2) {
		return new Line(sq1.center(), sq2.center());
	}
	
}
