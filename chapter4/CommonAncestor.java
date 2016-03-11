
// CtCI5 4.7

public class CommonAncestor<T> {

	private class TreeNode {
		T value;
		TreeNode left;
		TreeNode right;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
		if (root == null)
			return null;
		if (root==first || root==second)
			return root;
	
		if (underThis(root.left, first)) {
			if (underThis(root.left, second)) {
				return lowestCommonAncestor(root.left, first, second);
			} else {
				return root;
			}
		} else {
			if (underThis(root.left, second)) {
				return root;
			} else {
				return lowestCommonAncestor(root.right, first, second);
			}
		}
	}
	
	private boolean underThis(TreeNode node, TreeNode target) {
		if (node == null)
			return false;
		if (node == target)
			return true;
		if (underThis(node.left, target))
			return true;
		return underThis(node.right, target);
	}
}