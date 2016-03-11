

// CtCI5 17.1
public class Swapper {

	public void swapNumbers(int[] numbers, int from, int to) {
		if (from<0 || from>=numbers.length || to<0 || to>=numbers.length)
			return;	// Exception???
		if (from == to)
			return;
		if (numbers[from] == numbers[to])
			return;
	
		numbers[from] = numbers[from] ^ numbers[to];
		numbers[to] = numbers[from] ^ numbers[to];
		numbers[from] = numbers[from] ^ numbers[to];
	}

}
