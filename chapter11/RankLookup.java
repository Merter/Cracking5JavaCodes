
import java.util.*;


// CtCI5 11.8
public class RankLookup {
  private class TreeNode {
    private int value;
    private int leftCount;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
      this.value = value;
    }
  }           

  TreeNode root;

  public void track(int x) {
    track(x, root);
  }

  private void track(int x, TreeNode node) {
    if (node == null) {
      node = new TreeNode(x);
      return;
    }
    if (node.value == x) {
      node.leftCount++;
      return;
    }
    if (x > node.value) {
      track(x, node.right);
      return;
    }
    node.leftCount++;
    track(x, node.left);
  }

  public int getRankOfNumber(int x) {
    return getRankOfNumber(x, 0, root);
  }

  private int getRankOfNumber(int x, int count, TreeNode node) {
    if (node == null)
      return count;
    if (node.value == x)
      return node.leftCount+count;
    if (x > node.value)
      return getRankOfNumber(x, node.leftCount+1+count, node.right);
    return getRankOfNumber(x, count, node.left);
  }
}

