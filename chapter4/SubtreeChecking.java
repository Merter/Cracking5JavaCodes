

// CtCI 4.8
public class SubtreeChecking<T extends Comparable<T>> {

	private class TreeNode {
		T value;
		TreeNode left;
		TreeNode right;
	}
	
	public boolean containsTree(TreeNode T1, TreeNode T2) {
		if (T2 == null)
			return true;
		return doesMatch(T1, T2);
	}
	
	private boolean doesMatch(TreeNode T1, TreeNode T2) {
		if (T1 == null)
			return T2 == null;
		if (T2 == null)
			return false;
		if (T1.value.compareTo(T2.value) == 0) {
			if (doesMatch(T1.left, T2.left)) {
				if (doesMatch(T1.right, T2.right)) {
					return true;
				}
			}
		}
		if (doesMatch(T1.left, T2))
			return true;
		return doesMatch(T1.right, T2);
	}
}