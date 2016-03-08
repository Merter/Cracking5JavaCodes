

// CtCI5 7.7
import java.util.*;

public class PrimeFactors {

	public int kthFactorByPriorityQueue(int k) {
		if (k <= 0)
			return 0;
	
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(1);
		int min = 1;
		for (int i=2; i<=k; i++) {
			min = pq.poll();
			pq.add(min * 3);
			pq.add(min * 5);
			pq.add(min * 7);
			while (pq.peek() == min)
				pq.poll();
		}
		return min;
	}
	
	public int kthFactorByQueues(int k) {
		if (k <= 0)
			return 0;
	
		ArrayDeque<Integer> queue3 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> queue5 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> queue7 = new ArrayDeque<Integer>();
		
		int min = 1;
		queue3.addLast(3);
		queue3.addLast(5);
		queue3.addLast(7);
		for (int i=2; i<=k; i++) {
			int min3 = queue3.peek();
			int min5 = queue5.peek();
			int min7 = queue7.peek();
			if (min5 < min7) {
				if (min3 < min5) {
					min = min3;
					queue3.poll();
					queue3.addLast(min * 3);
					queue5.addLast(min * 5);
					queue7.addLast(min * 7);
				} else {
					min = min5;
					queue5.poll();
					queue5.addLast(min * 5);
					queue7.addLast(min * 7);
				}
			} else {
				if (min3 < min7) {
					min = min3;
					queue3.poll();
					queue3.addLast(min * 3);
					queue5.addLast(min * 5);
					queue7.addLast(min * 7);					
				} else {
					min = min7;
					queue7.poll();
					queue7.addLast(min * 7);
				}
			}
		}
		return min;
	}

}