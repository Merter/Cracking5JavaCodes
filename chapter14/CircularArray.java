
import java.util.*;


// CtCI5 14.6
public class CircularArray<T> implements Iterable<T> {

	private T[] array;
	private int arrayBegin;
	
	private CircularArray(int size) {
		array = (T[])new Object[size];
	}
	
	public static CircularArray circularArrayFactory (int size) {
		return new CircularArray(size);
	}
	
	private class CircularArrayIterator implements Iterator<T> {
		private int iteratorStart;
		private int index;
		
		public CircularArrayIterator() {
			index = arrayBegin;
		}
		
		public boolean hasNext() {
			return index != addOffset(array.length-1);
		}
		
		public T next() {
			if (!hasNext()) 
				return null;
			T result = (T)array[index];
			index = addOffset(index);
			return result;
		}
		
		public void remove() {
			// left blank intentionally
		}
	}
	
	public Iterator<T> iterator() {
		return new CircularArrayIterator();
	}

	public T get(int i) {
		if (i<0 || i>=array.length)
			return null;
		return array[addOffset(i)];
	}

	private int addOffset(int i) {
		while (i < 0)
			i += array.length;
		return (arrayBegin+i) % array.length;
	}
	
	public void set(int i, T item) {
		array[addOffset(i)] = item;
	}

	public void rotate(int shiftCount, boolean toRight) {
		arrayBegin = toRight ? addOffset(shiftCount) : addOffset(shiftCount * -1);
	}

}
