
import java.util.*;


// CtCI5 4.5
public class SearchTreeVerification<T extends Comparable <T>> {

	private ArrayList<T> treeAsArray = new ArrayList<T>();

	private class TreeNode {
		T value;
		TreeNode left;
		TreeNode right;
	}

	// get the greatest element from left child
	// if null, return false
	// root.value must be greater than or equal to it
	// get the smallest element from right child
	// if null, return false
	// root.value must be smaller than or equal to it
	public boolean isBinarySearchTree(TreeNode root) {
		return isBinarySearchTreeByRecursion(root, root.value);
	}

	private boolean isBinarySearchTreeByRecursion(TreeNode root, T value) {
		if (areAllSmaller(root.left, value)) {
			if (areAllBigger(root.right, value)) {
				if (isBinarySearchTreeByRecursion(root.left, value)) {
					if (isBinarySearchTreeByRecursion(root.right, value))
						return true;
					return false;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean areAllSmaller(TreeNode node, T value) {
		if (node == null)
			return true;
		return areAllSmaller(node.left, value) && node.value.compareTo(value)<=0 && areAllSmaller(node.right, value);
	}

	private boolean areAllBigger(TreeNode node, T value) {
		if (node == null)
			return true;
		return areAllBigger(node.left, value) && node.value.compareTo(value)>=0 && areAllBigger(node.right, value);
	}

	// (root, null, null)
	private boolean isBinarySearchTreeWithBetweenness(TreeNode node, T min, T max) {
		if (node == null)
			return true;
		if (min != null) {
			if (max != null) {
				int comp = node.value.compareTo(min);
				if (comp < 0)
					return false;
				comp = node.value.compareTo(max);
				if (comp > 0)
					return false;
			} else {
				int comp = node.value.compareTo(min);
				if (comp < 0)
					return false;
			}
		} else {
			if (max != null) {
				int comp = node.value.compareTo(max);
				if (comp > 0)
					return false;
			}
		}
		if (!isBinarySearchTreeWithBetweenness(node.left, min, node.value))
			return false;
		return isBinarySearchTreeWithBetweenness(node.right, node.value, max);
	}
}