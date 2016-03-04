
import java.util.*;


// CtCI5 9.7
public class PaintFill {

  private class ColoredPoint {
    private int x;
    private int y;
    private int color;
  }

  private static final int resX = 1680;
  private static final int resY = 1050;

  private ColoredPoint[][] screen;

  public void fillWithColor(int x, int y, int oldColor, int newColor) {
    ColoredPoint point = screen[y][x];
    if (point.color == newColor)
      return;
    point.color = newColor;
    ArrayList<ColoredPoint> neighs = findNeighborsWithSameColor(point, oldColor);
    for (ColoredPoint n : neighs) {
      fillWithColor(n.x, n.y, oldColor, newColor);
    }
  }

  private ArrayList<ColoredPoint> findNeighborsWithSameColor(ColoredPoint point, int oldColor) {
    int minX = Math.min(0, point.x-1);
    int maxX = Math.min(point.x+1, resX);
    int minY = Math.min(0, point.y-1);
    int maxY = Math.min(point.y+1, resY);
    ArrayList<ColoredPoint> neighs = new ArrayList<ColoredPoint>();
    for (int x=minX; x<=maxX; x++) {
      for (int y=minY; y<=maxY; y++) {
        if ((screen[y][x]).color == oldColor)
          neighs.add(screen[y][x]);
      }
    }
    return neighs;
  }

}
