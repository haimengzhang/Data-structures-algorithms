public class DLList {
    DLNode sentinel;
    int size;

    public class DLNode {
        Object item;
        DLNode prev, next;

        public DLNode(Object item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
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
    public void insertBack(Object o) {
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
    public Object get(int position) {
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
    public void insert(Object o, int position) {
       
        if (position < 0) throw new IndexOutOfBoundsException("Negative index");

        if (position >= size) {
            insertBack(o);
        }
        else {
            DLNode curr = sentinel.next;
            for (int i = 0; i < position; i++) {
                curr = curr.next;
            }
            DLNode ins = new DLNode(o, curr.prev, curr);
            ins.next.prev = ins;
            ins.prev.next = ins;
            size++;
        }



    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(Object o) {
      
        DLNode n = new DLNode(o, sentinel, sentinel.next);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    public void remove(Object o) {
       
        DLNode curr = sentinel.next;
        DLNode temp;
        while (curr != sentinel) {
            if (curr.item.equals(o)) {
                temp = curr.next;
                remove(curr);
                curr = temp;
            }
            else {
                curr = curr.next;
            }
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     * @param n DLNode to remove
     */
    public void remove(DLNode n) {
        
        n.next.prev = n.prev;
        n.prev.next = n.next;
        size--;
    }


    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        
        DLNode curr = sentinel.next;
        DLNode ins;
        while (curr != sentinel) {
            ins = new DLNode(curr.item, curr, curr.next);
            ins.next.prev = ins;
            ins.prev.next = ins;
            curr =ins.next;
            size++;
        }
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        
        DLNode curr;
        DLNode oldNext;
        oldNext = sentinel.next;
        sentinel.next= sentinel.prev;
        sentinel.prev = oldNext;
        curr = oldNext;
        while (curr!= sentinel) {
            oldNext = curr.next;
            curr.next = curr.prev;
            curr.prev = oldNext;
            curr = oldNext;
        }
    }

    public static void main(String[] args) {
        // add some quick tests
    }
}
