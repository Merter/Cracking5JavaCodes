
import java.util.*;


// CtCI5 4.2
public class DirectedGraphConnectivity {

  private class DirectedGraph {
    private int[] vertices;
    private ArrayList<Integer>[] edges;
  }

  private boolean[] isVisited;

  private DirectedGraph dGraph;

  public boolean existsRoute(int v1, int v2) {
    if (dfs(v1, v2))
      return true;
    return dfs(v2, v1);
  }

  private boolean dfs(int from, int to) {
    for (int neighbour : dGraph.edges[from]) {
      if (neighbour == to)
        return true;
      if (!isVisited[neighbour]) {
        isVisited[neighbour] = true;
        boolean found = dfs(neighbour, to);
        if (found)
          return true;
      }
    }
    return false;
  }

}
