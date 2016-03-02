
import java.util.*;


// CtCI5 4.1
public class BalancedTreeCheck<T> {

  private static final int LEAF_CHILD_HEIGHT = -1;

  private class TreeNode {
    T value;
    TreeNode left;
    TreeNode right;
    private int height = LEAF_CHILD_HEIGHT;
  }

  private TreeNode root;

  public boolean isBalanced() {
    return isBalanced(root);
  }

  private boolean isBalanced(TreeNode node) {
    if (node == null)
      return true;
    if (!isBalanced(node.left))
      return false;
    if (!isBalanced(node.right))
      return false;

    int leftHeight = node.left==null ? LEAF_CHILD_HEIGHT : node.left.height;
    int rightHeight = node.right==null ? LEAF_CHILD_HEIGHT : node.right.height;
    if (Math.abs(leftHeight - rightHeight) > 1)
      return false;
    node.height = Math.max(leftHeight, rightHeight) + 1;
    return true;
  }

}
