/** Represent a set of nonnegative ints from 0 to maxElement - 1 for some
 *	initially specified maxElement.
 */
public class BooleanSet implements SimpleSet {

	/** contains[k] is true if k is in the set, false if it isn't. */
	private boolean[] contains;

	/** Initializes a set of ints from 0 to maxElement - 1. */
	public BooleanSet (int maxElement) {
		// YOUR CODE HERE
		contains = new boolean [maxElement]; //empty set with default false values in each position;
	}

	/** Adds k to the set.
	 *	precondition: 0 <= k < maxElement.
	 *	postcondition: k is in this set.
	 */
	public void add(int k) {
		// YOUR CODE HERE
		if ( k > 0 && k < contains.length) {
			contains [k] = true;
		}

	}

	/** Removes k from the set.
	 *	precondition: 0 <= k < maxElement.
	 *	postcondition: k is not in this set.
	 */
	public void remove(int k) {
		// YOUR CODE HERE
		if ( k > 0 && k < contains.length) {
			contains [k] = false;
		}
	}

	/** Return true if k is in this set, false otherwise.
	 *	precondition: 0 <= k < maxElement
	 */
	public boolean contains (int k) {
		// YOUR CODE HERE
		if ( k > 0 && k < contains.length) {
			if (contains [k] == true) {
				return contains [k];
			}
		} return false;
	}

	/** Return true if this set is empty, false otherwise. */
	public boolean isEmpty() {
		// YOUR CODE HERE
		if (contains.length == 0) {
			return true;
		}else {
			return false;
		}
	}

	/** Returns the number of items in the set. */
	public int size() {
		// YOUR CODE HERE
		int count = 0;
		for (int i = 0; i <contains.length; i++) {
			if ( contains [i] == true) {
				count += 1;
			}
		}return count;
	}
}
