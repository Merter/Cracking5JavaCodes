
import java.util.*;


// CtCI5 4.4
public class NodesOfDepth<T> {

  private class TreeNode {
    private T value;
    private TreeNode left;
    private TreeNode right;
  }

  private TreeNode root;

  public ArrayList<LinkedList<TreeNode>> getListOfDepthByBfs() {
    ArrayList<LinkedList<TreeNode>> levels = new ArrayList<LinkedList<TreeNode>>();
    ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
    ArrayDeque<Integer> levelQueue = new ArrayDeque<Integer>();
    int level = 0;
    queue.add(root);
    levelQueue.add(level);
    while (queue.size() > 0) {
      TreeNode current = queue.poll();
      level = levelQueue.poll();
      if (levels.size() > level) {
        LinkedList<TreeNode> levelList = levels.get(level);
        levelList.add(current);
      } else {
        LinkedList<TreeNode> levelList = new LinkedList<TreeNode>();
        levelList.add(current);
        levels.add(levelList);			
      }
      putIntoQueues(current.left, queue, level, levelQueue);
      putIntoQueues(current.right, queue, level, levelQueue);
    }
    return levels;
  }	

  private void putIntoQueues(TreeNode node, ArrayDeque<TreeNode> queue, int level, ArrayDeque<Integer> levelQueue) {
    if (node != null) {
      queue.add(node);
      levelQueue.add(level+1);
    }
  }

  public ArrayList<LinkedList<TreeNode>> getListOfDepthByDfs() {
    ArrayList<LinkedList<TreeNode>> levels = new ArrayList<LinkedList<TreeNode>>();
    dfs(root, levels, 0);
    return levels;
  }

  private void dfs(TreeNode root, ArrayList<LinkedList<TreeNode>> levels, int level) {
    if (root == null) return;
    if (levels.size() > level) {
      LinkedList<TreeNode> levelList = levels.get(level);
      levelList.add(root);
    } else {
      LinkedList<TreeNode> levelList = new LinkedList<TreeNode>();
      levelList.add(root);
      levels.add(levelList);
    }
    dfs(root.left, levels, level+1);
    dfs(root.right, levels, level+1);
  }

}
