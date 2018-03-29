public class ArrayOperations {

	// Delete the value at the given position in the argument array,
	// shifting all the subsequent elements down, and storing a 0
	// as the last element of the array.
	public static void delete (int[] values, int pos) {
		if (pos < 0 || pos >= values.length) {
			return;
		}
		// YOUR CODE HERE
		for (int i = pos + 1; i < values.length; i++) {
			values[i - 1] = values[i];
		}
		values[values.length-1] = 0;
	}
	
	// Insert newInt at the given position in the argument array,
	// shifting all the subsequent elements up to make room for it.
	// The last element in the argument array is lost.
	public static void insert (int[] values, int pos, int newInt) {
		if (pos < 0 || pos >= values.length) {
			return;
		}
		// YOUR CODE HERE
		int temp1 = values[pos];
		int temp2;
		for (int i = pos + 1; i < values.length; i++) {
			temp2 = values[i];
			values[i] = temp1;
			temp1 = temp2;
		}
		values[pos] = newInt;
	}
}
