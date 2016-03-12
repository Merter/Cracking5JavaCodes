
import java.util.*;

// CtCI5 4.9
public class PathToSum {

	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
	}
	
	public void printAllPaths(TreeNode root, int key) {
		if (root == null)
			return;
		ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
		nodeQueue.addLast(root);
		while (nodeQueue.size() > 0) {
			TreeNode start = nodeQueue.removeFirst();
			if (start.left != null)
				nodeQueue.addLast(start.left);
			if (start.right != null)
				nodeQueue.addLast(start.right);
			ArrayDeque<TreeNode> path = new ArrayDeque<TreeNode>();
			printPathsToValue(start, path, key);
		}
	}

	private void printPathsToValue(TreeNode node, ArrayDeque<TreeNode> path, int remain) {
		if (node == null)
			return;
		remain -= node.value;
		path.addLast(node);
		if (remain == 0)
			printPathValues(path);
		printPathsToValue(node.left, path, remain);
		printPathsToValue(node.right, path, remain);
		path.removeLast();
	}
	
	private void printPathValues(ArrayDeque<TreeNode> path) {
		StringBuilder sb = new StringBuilder();
		for (TreeNode node : path) {
			sb.append(node.value);
			sb.append("\t");
		}
		System.out.println(sb.toString().trim());
	}
}
