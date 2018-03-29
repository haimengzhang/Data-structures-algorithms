public class FixedSizeList implements SimpleList {

    /** List of elements. */
    protected int[] values;
    /** Number of array cells used by the list. */
    int count;

    /** Initializes a FixedSizeList with specified capacity. The capacity is the
     *  the actual size of the array (i.e. the max number of items it can hold).
     */
    public FixedSizeList(int capacity) {
        // YOUR CODE HERE
        values = new int[capacity];
        count = 0;
    }
    public FixedSizeList() {

    }


    /** Returns the number of items in the list. */
    public int size() {
        // YOUR CODE HERE
        return count;
    }

    /** Returns true if the list is empty, else false. */
    public boolean isEmpty() {
        // YOUR CODE HERE
        if (values.length == 0){
            return true;
        }else {
            return false;
        }
    }

    /** Adds the int k to the list by placing it in the first unused spot in
     *  values.
     */
    public void add(int k) {
        // YOUR CODE HERE'
        if (size() == values.length) {
            throw new ListException(" No more space to add!");
        }
        values[count] = k;
        count += 1;
    }

    /** Removes k from the list if it is present. If k appears multiple times,
     *  it only removes the first occurence of k.
     */
    public void remove(int k) {
        // YOUR CODE HERE
        for (int i = 0; i < count; i++) {
            if (get(i) == k) {
                removeIndex(i);
            }
        }
    }

    /** Returns if the collection contains k. */
    public boolean contains(int k) {
        // YOUR CODE HERE
        for (int i = 0; i < count; i++){
            if (get(i)== k) {
                return true;
            }
        }return false;
    }


    /** Returns the integer stored at the i-th index in the list. */
    public int get(int i) {
        // YOUR CODE HERE
        if (i < 0 || i >= size()) {
            throw new ListException("No such index exists");
        }
        return values [i];
    }

    /** Inserts k into the list at position i by shifting each element at index
     *  i and onwards one entry to the right.
     *  Precondition: i is between 0 and count, inclusive.
     */
    public void add(int i, int k) {
        if (i < 0 || i >= values.length || (size()== values.length)) {
            throw new ListException("No more open seat for your number!");
        }
        for (int j = count; j > i; j--) {
            values[j] = values[j-1];
        }
        values[i] = k;
        count++;
    }

    /** Removes the entry at position i by shifting each element after position
     *  i one entry to the left.
     */
    public void removeIndex(int i) {
        // YOUR CODE HERE
        for (int j = i; j < count; j++) {
            values[j] = values[j+1];
        }
        values[count-1]=0;
        count -=1;
    }
}

