
import java.util.*;


public class MostPointsOnLine {

	private static final double ERROR = 0.00001;

	private static final double floorToNearestErrorMargin(double d) {
		int r = (int) (d / ERROR);
		return ((double) r) * ERROR;
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
				this.intersect = floorToNearestErrorMargin(p1.y);
				return;
			}
			if (Math.abs(p1.x-p2.x) < ERROR) {
				this.yCoeff = 0;
				this.xCoeff = 1;
				this.intersect = floorToNearestErrorMargin(p1.x);
				return;
			}
			this.yCoeff = 1;
			this.xCoeff = floorToNearestErrorMargin((p2.y-p1.y) / (p2.x-p1.x));
			this.intersect = floorToNearestErrorMargin(p1.x * (p2.y-p1.y) / (p2.x-p1.x) + p1.y);
		}
		
		@Override
		public boolean equals(Object other) {
			if (this == other)
				return true;
				
			if (!(other instanceof Line))
				return false;
				
			Line otherLine = (Line)other;
			if (Math.abs(this.xCoeff - otherLine.xCoeff) > ERROR)
				return false;
			if (Math.abs(this.yCoeff - otherLine.yCoeff) > ERROR)
				return false;
			if (Math.abs(this.intersect - otherLine.intersect) > ERROR)
				return false;
			return true;	
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			long doubleHash = Double.doubleToLongBits(xCoeff);
			result = result * 31 + (int) (doubleHash ^ (doubleHash >>> 32));
			doubleHash = Double.doubleToLongBits(yCoeff);
			result = result * 31 + (int) (doubleHash ^ (doubleHash >>> 32));
			doubleHash = Double.doubleToLongBits(intersect);
			result = result * 31 + (int) (doubleHash ^ (doubleHash >>> 32));
			return result;
		}
		
		public boolean satisfy(Point p) {
			return (yCoeff*p.y - xCoeff*p.x - intersect) < ERROR;
		}
	}

	public Line theLineWithMostPoints(Point[] points) {
		Map<Line, Integer> lineMap = new HashMap<Line, Integer>();
		for (int i=0; i<points.length; i++) {
			for (int j=i+1; j<points.length; j++) {
				Line line = new Line(points[i], points[j]);
				if (lineMap.get(line) != null)
					continue;
				int count = 2;
				for (int k=0; k<points.length; k++) {
					if (k!=i && k!=j) {
						if (line.satisfy(points[k])) {
							count++;
						}
					}
				}
				lineMap.put(line, count);
			}
		}
		
		int max = Integer.MIN_VALUE;
		Line maxLine = null;
		for (Line line : lineMap.keySet()) {
			int count = lineMap.get(line);
			if (count > max) {
				max = count;
				maxLine = line;
			}
		}
		return maxLine;
	}
}
