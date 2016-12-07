
import java.util.*;


// CtCI5 18.3
public class SubsetSelector {

	public List<Integer> selectSubsetFrom(int[] nums, int m) {
		List<Integer> selection = new LinkedList<>();
		if (m >= nums.length) {
			for (int i=0; i<nums.length; i++) {
				selection.add(nums[i]);
			}
		} else {
			for (int i=0; i<m; i++) {
				int indexToSwap = nums.length-1-i;
				int selectedIndex = randomIndex(indexToSwap);
				selection.add(nums[selectedIndex]);
				swap(nums, selectedIndex, indexToSwap);
			}
		}
		return selection;
	}

	private int randomIndex(int n) {
		return new Random().nextInt(n);
	}
	
	private void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}

}