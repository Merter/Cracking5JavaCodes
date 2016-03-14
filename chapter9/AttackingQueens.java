
// CtCI5 9.9

public class AttackingQueens {

	private static final int GRID_SIZE = 8;
	private static int solutionCount = 0;
	private static boolean[] used = new boolean[GRID_SIZE];
	
	public int solveEightQueens() {
		int[] cols = new int[GRID_SIZE];
		permutations(cols, 0);
		return solutionCount;
	}

	private void permutations(int[] cols, int pos) {
		if (pos == GRID_SIZE) {
			checkQueenPositions(cols);
			return;
		}
		for (int i=0; i<GRID_SIZE; i++) {
			if (!used[i]) {
				used[i] = true;
				cols[pos] = i;
				permutations(cols, pos+1);
				used[i] = false;
			}
		}
	}
	
	private void checkQueenPositions(int[] cols) {
		for (int i=0; i<GRID_SIZE; i++) {
			int row1 = i;
			int col1 = cols[i];
			for (int j=i+1; j<GRID_SIZE; j++) {
				int row2 = j;
				int col2 = cols[j];
				if (row2-row1 == Math.abs(col2-col1))
					return;
			}
		}
		solutionCount++;
	}

}
