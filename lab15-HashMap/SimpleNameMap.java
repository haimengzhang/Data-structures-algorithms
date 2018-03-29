import java.util.Map;

/**
 *  A simple mapping from string names to string values backed by an array.
 *  Supports only A-Z for the first character of the key name. Values can be
 *  any valid string.
 *
 *  @author You
 */
public class SimpleNameMap {


    //Declare an instance variable
    Entry[] bins;
    public int size;

    //Instantiate the size of our array: 26 bucket to store names and each bucket has a hash key
    public SimpleNameMap() {
        bins = new Entry[26];
        size = 0;
    }

    // return an index for a key, what bucket to put it into
    public int hashCode(String key) {
        return (int) (key.charAt(0) - 'A');
    }

    /** Returns true if the map contains the KEY. */
    public boolean containsKey(String key) {
        if (!isValidName(key)) {
            return false;
        }
        int modOfHash = key.hashCode()% bins.length;
        if (bins[modOfHash] == null) {
            return false;
        }
        Entry temp = bins[modOfHash];
        // if temp not null, compare it.
        while (temp._key!= null) {
            if (temp._key.equals(bins[modOfHash])) {
                return true;
            } temp = temp._next; // if temp is not equal to key, set temp to next
        }return false;
    }

    /** Returns the value for the specified KEY. */
    public String get(String key) {
        if (!containsKey(key)) {
            return null;
        }
        int modOfHash = key.hashCode() % bins.length;
        Entry temp = bins[modOfHash];
        while (temp!= null) {
            // if temp not null, compare it.
            if (temp._key.equals(bins[modOfHash])) {
                return temp._value;
            } temp = temp._next;
        }return null;
    }

    /** Put a (KEY, VALUE) pair into this map. */
    void put(String key, String value) {
        if (isValidName(key)) {
            if (size/bins.length > 0.75) {
                resize();
            }
            int modOfHash = key.hashCode() % bins.length;
            Entry temp = bins[modOfHash];
            while (temp!= null) {
                temp = temp._next;
            }
            if (!containsKey(key)){
                bins[modOfHash]._next = new Entry(key, value);
                size ++;
            }
        } throw new IllegalArgumentException("Your key is not valid");
    }

    public void resize () {
            bins = new Entry[bins.length*2];
    }

    /** Remove a single entry, KEY, from this table and return the VALUE if successful or NULL otherwise. */
    public String remove(String key) {
        if (!containsKey(key)) {
            return null;
        } else {
            int modOfHash = key.hashCode() % bins.length;
            Entry temp = bins[modOfHash];
            while (temp._next != null) {
                if (temp._next._key.equals(key)) {
                    String toReturn = temp._next._value;
                    temp._next = temp._next._next;
                    size --;
                    return toReturn;
                }
                temp = temp._next;
            }return null;
        }
    }
    // Let's add external chaining to our SimpleNameMap.
    // We can either use Java's LinkedList class or modify the Entry static nested class (by adding next pointers)
    // to support multiple entries in a bucket.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** A wrapper class for holding each (KEY, VALUE) pair. */
    private static class Entry {

        /** The key used for lookup. */
        private String _key;
        /** The associated value. */
        private String _value;
        private Entry _next;

        /** Create a new (KEY, VALUE) pair. */
        public Entry(String key, String value) {
            _key = key;
            _value = value;
            this._next = null;
        }

        /** Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return _key.equals(other._key);
        }

        /** Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry &&
                    _key.equals(((Entry) other)._key) &&
                    _value.equals(((Entry) other)._value));
        }

    }

    /** Returns true if the given KEY is a valid name that starts with A-Z. */
    private static boolean isValidName(String key) {
        return 'A' <= key.charAt(0) && key.charAt(0) <= 'Z';
    }



}