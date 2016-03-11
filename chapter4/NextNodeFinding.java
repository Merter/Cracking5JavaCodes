
// CtCI5 4.6

public class NextNodeFinding<T> {
    private class TreeNode {
        T value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
    
    public T nextValue(TreeNode node) {
        if (node == null)
            return null;
        if (node.right != null)
            return leftMostChild(node.right);
        return nextLargestParentOf(node);
    }
    
    private T leftMostChild(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node.value;
    }
    
    private T nextLargestParentOf(TreeNode node) {
        while (node.parent != null) {
            if (node.parent.left == node)
                return node.parent.value;
             node = node.parent;
        }
        return null;
    }
}