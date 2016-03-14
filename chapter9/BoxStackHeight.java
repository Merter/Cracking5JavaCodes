
// CtCI5 9.10

import java.util.*;

public class BoxStackHeight {

	private boolean[] used;
	private Box[] boxes;
	private Map<Integer, Integer> maxHeightForBox;

	private class Box {
		int height;
		int width;
		int depth;
	}

	public int makeBiggestStack(Box[] boxes) {
		this.boxes = boxes;
		used = new boolean[boxes.length];
		maxHeightForBox = new HashMap<Integer, Integer>(boxes.length);
		return recursiveStack(-1);
	}

	private int recursiveStack(int bottom) {
		int maxHeight = 0;
		for (int i=0; i<boxes.length; i++) {
			if (!used[i]) {
				if (bottom==-1 || (boxes[bottom].height>boxes[i].height
					&& boxes[bottom].width>boxes[i].width
					&& boxes[bottom].depth>boxes[i].depth)) {
					Integer nextHeight = maxHeightForBox.get(i);
					if (nextHeight == null) {
						used[i] = true;
						nextHeight = recursiveStack(i);
						used[i] = false;
					}
					if (nextHeight > maxHeight) {
						maxHeight = nextHeight;
					}
				}
			}
		}
		if (bottom >= 0) {
			maxHeightForBox.put(bottom, maxHeight + boxes[bottom].height);
			return maxHeight + boxes[bottom].height;
		}
		return maxHeight;
	}
}
