
// CtCI5 18.1
public class AddWithoutPlus {

	public int add(int first, int second) {
		int carry = 0;
		int mask = 1;
		int sum = 0;
		for (int i=0; i<Integer.SIZE; i++) {
			int bitsForOne = first & mask;
			int bitsForTwo = second & mask;
			int bitSum = bitsForOne ^ bitsForTwo;
			int bitCarry = bitsForOne & bitsForTwo;
			bitSum ^= carry;
			bitCarry &= carry;
			carry = bitCarry;
			sum |= bitSum;
			mask <<= 1;
		}
		return sum;
	}

}
