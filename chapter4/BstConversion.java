
import java.util.*;


// CtCI5 4.3
public class BstConversion {

  private int[] sortedNumbers;

  private class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
  }

  public TreeNode generateBst() {
    return generateBstInRange(0, sortedNumbers.length-1);
  }

  private TreeNode generateBstInRange(int begin, int end) {
    if (begin > end)
      return null;
    TreeNode root = new TreeNode();
    int mid = (begin+end) / 2;
    root.value = sortedNumbers[mid];
    root.left = generateBstInRange(begin, mid-1);
    root.right = generateBstInRange(mid+1, end);
    return root;
  }

}
