import java.util.Iterator;

<<<<<<< HEAD
public class DLList<T> implements Iterable<T> {
    DLNode sentinel;
    int size;
    int index;
    private DLListIterator iter;

    private class DLListIterator implements Iterator<T> {
        private int index;
        private DLNode current;


        public DLListIterator () {
            int index= 0;
=======
public class DLList <T> implements Iterable<T> {
    DLNode sentinel;
    int size;
    int index;
    private DLNode current;
    private DLListIterator itty;

    private class DLListIterator implements Iterator {
        private int index;
        private DLNode current;

        public DLListIterator () {
            index = 0;
>>>>>>> c47c2ba7dd7e238c053a89ba3808fca113ad4adc
            current = sentinel;
        }

        @Override
<<<<<<< HEAD
        public boolean hasNext () {
=======
        public boolean hasNext() {
>>>>>>> c47c2ba7dd7e238c053a89ba3808fca113ad4adc
            return index < size;
        }

        @Override
<<<<<<< HEAD
        public T next () {
            if (!hasNext()) {
                return null;
            }
            else {
                index++;// it has next element, move on to next index
                current = current.next;
                return current.item;

            }

        }
    }

    public Iterator<T> iterator() {
        return new DLListIterator ();
    }
=======
        public T next() {
            if (!hasNext()) {
                return null;
            }
            index++;
            current = current.next;
            return current.item;
        }

    }

    public Iterator<T> iterator() {
        return new DLListIterator();
    }

>>>>>>> c47c2ba7dd7e238c053a89ba3808fca113ad4adc
    public class EvenIterator implements Iterator {
        private int index;
        private DLNode current;

<<<<<<< HEAD
        public boolean hasNext () {
=======
        public boolean hasNext() {
>>>>>>> c47c2ba7dd7e238c053a89ba3808fca113ad4adc
            return index < size;
        }

        public T next() {
<<<<<<< HEAD
            if (!hasNext()){
                return null;
            }
            index =+ 2;
            current = current.next;
            return T current.item;
        }
    }
    public class ReverseIterator implements Iterator {
        private int index;
        private DLNode current;

        public Iterator<T> iterator() {

        }
    }
    }

=======
            if (!hasNext()) {
                return null;
            }
            index++;
            current = current.next;
            return current.item;
        }
    }

    public class ReverseIterator implements Iterator {
        private int index;
        private DLNode current;
        public Iterator<T> iterator() {
            index = 0;
            current = sentinel;
            return this.iterator();
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            if (!hasNext()) {
                return null;
            }
            index++;
            current = current.prev;
            return current.item;
        }
    }

    public class RandomIterator implements Iterator  {
        private int index;
        private DLNode current;
        public Iterator<T> iterator() {
            index = 0;
            current = sentinel;
            return this.iterator();
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            if (!hasNext()) {
                return null;
            }
            index++;
            current = current.next;
            return current.item;
        }
    }
>>>>>>> c47c2ba7dd7e238c053a89ba3808fca113ad4adc


    public class DLNode {
        T item; //
        DLNode prev, next;

        public DLNode(T item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DLNode dlNode = (DLNode) o;

            if (!item.equals(dlNode.item)) return false;
            if (!prev.equals(dlNode.prev)) return false;
            return next.equals(dlNode.next);
        }

        @Override
        public String toString() {
            return "DLNode{" +
                    "item=" + item +
                    '}';
        }
    }

    /**
     * Construct a new DLList with a sentinel that points to itself.
     */
    public DLList() {
        sentinel = new DLNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Insert into the end of this list
     * @param o Object to insert
     */
    public void insertBack(T o) { // change the obeject type to be T generic type
        DLNode n = new DLNode(o, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }


    /**
     * Get the value at position pos. If the position does not exist, return null (the item of
     * the sentinel).
     * @param position to get from
     * @return the Object at the position in the list.
     */
    public T get(int position) {
        DLNode curr = sentinel.next;
        while (position > 0 && curr != sentinel) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DLList(");
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /**
     * Insert a new node into the DLList.
     * @param o Object to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(T o, int position) {
        DLNode curr = sentinel;
        while (position > 0 && curr.next != sentinel) {
            curr = curr.next;
            position--;
        }
        DLNode n = new DLNode(o, curr, curr.next);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(T o) {
        insert(o, 0);
    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    public void remove(T o) {
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            if (curr.item.equals(o)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
            }
            curr = curr.next;
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     * @param n DLNode to remove
     */
    public void remove(DLNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }

    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            DLNode dup = new DLNode(curr.item, curr, curr.next);
            dup.prev.next = dup;
            dup.next.prev = dup;
            curr = dup.next;
        }
        size *= 2;
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        DLNode curr = sentinel;
        do {
            DLNode tmp = curr.prev;
            curr.prev = curr.next;
            curr.next = tmp;
            curr = curr.prev;
        } while (curr != sentinel);
    }

    public static void main(String[] args) {
        DLList<String> l = new DLList<> ();
        l.insertBack("CS");
        l.insertBack("61");
        l.insertBack("BL!");
        System.out.println("l = " + l);

        l.insertBack("2");
        l.insertFront("1");
        System.out.println("l.get(0) = " + l.get(0));
        l.insert("4", 1);
        l.remove("1");
        System.out.println("l = " + l);
        l.doubleInPlace();
        System.out.println("l = " + l);
        l.reverse();
        System.out.println("l = " + l);

        Iterator<String> itt = l.iterator();
        while (itt.hasNext()) {
            System.out.println(itt.next());
        }
    }
}
