/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    private int item;
    /** The next node in this IntList. */
    private IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints (1 2 3) */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /** Returns the integer stored by this IntList. */
    public int item() {
        return item;
    }

    /** Returns the next node stored by this IntList. */
    public IntList next() {
        return next;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) throws IllegalArgumentException {
        if (position == 0) {
            return this.item;
        }
        if ((position > 0 && this.next == null) || position < 0) {
            throw new IllegalArgumentException("YOUR MESSAGE HERE");
        }
        return this.next.get(position - 1);
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        IntList p = this.next;
        int count = 1;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "( 1 2 3 )".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        String str = "( " + this.item + " ";
        IntList p = this.next;
        while (p != null) {
            str += (p.item + " ");
            p = p.next;
        }
        return str + ")";
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof IntList)) {
            return false;
        }
        IntList p = this;
        IntList q = ((IntList) obj);
        int sz = p.size();
        if (sz != q.size()) {
            return false;
        }
        for (int i = 0; i < sz; i++) {
            if (p.item != q.item) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /**
     * Adds the given item at the end of the list.
     *
     * @param item, the int to be added.
     */
    public void add(int item) {
        IntList a = new IntList (item);
        IntList p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = a;
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        int smo = this.item;
        IntList p = this.next;
        while (p != null) {
            if (p.item < smo) {
                smo = p.item;
            }
            p = p.next;
        }
        return smo;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        int somSom = this.item * this.item;
        IntList p = this.next;
        while (p != null) {
            somSom += (p.item * p.item);
            p = p.next;
        }
        return somSom;
    }

    /**
     * Returns a new IntList consisting of L1 followed by L2,
     * non-destructively.
     *
     * @param l1 list to be on the front of the new list.
     * @param l2 list to be on the back of the new list.
     * @return new list with L1 followed by L2.
     */
    public static IntList append(IntList l1, IntList l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        IntList a;
        IntList p = l1;
        IntList q = l2;
        if (l1 == null) {
            a = new IntList (l2.item);
            q = q.next;
        }
        else {
            a = new IntList (l1.item);
            p = p.next;
        }

        IntList s = a;

        while (p != null) {
            s.next = new IntList (p.item);
            s = s.next;
            p = p.next;
        }
        while (q != null) {
            s.next = new IntList (q.item);
            s = s.next;
            q = q.next;
        }
        return a;

    }
}