
import java.util.*;


// CtCI5 9.2
public class PathForRobot {

  private static final Character OBSTRUCTED = 'O';
  private static final Character RIGHT = 'R';
  private static final Character DOWN = 'D';
  private Character[][] grid;
  private ArrayDeque<Character> path;

  public int numberOfPaths(Character[][] grid) {
    long result = 1;
    int X = grid.length;
    int Y = grid[0].length;
    for (int i=X; i<X+Y-1; i++)
      result *= i;
    for (int i=1; i<Y; i++)
      result /= i;
    return (int)result;
  }

  public ArrayDeque<Character> pathFinder(int X, int Y, Character[][] grid) {
    this.grid = grid;
    if (canGetFrom(0, 0))
      return path;
    return null;
  }

  private boolean canGetFrom(int beginX, int beginY) {
    if (grid[beginX][beginY] == OBSTRUCTED)
      return false;
    if (beginX==grid.length-1 && beginY==grid[0].length-1)
      return true;
    if (beginX==grid.length || beginY==grid[0].length)
      return false;
    path.addLast('R');
    if (canGetFrom(beginX+1, beginY))
      return true;
    path.removeLast();
    path.addLast('D');
    return canGetFrom(beginX, beginY+1);
  }
}

