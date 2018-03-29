/**
 * Created by haimengzhang on 7/20/17.
 */
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class HashMap<K,V> implements Map61BL<K,V> {


    //Declare an instance variable
<<<<<<< HEAD
    Entry<K, V>[] bins;
    public int size;
    public int capacity;
    public double loadFactor = 0.75;
    Set<K> keySet = new HashSet<K>();


    /** Create a new hash map with a default array of size 16 and load factor of 0.75. */
    public HashMap() {
        capacity = 16;
        bins = (Entry<K, V>[]) new Entry[16];
        size = 0;
=======
//    Entry<K, V>[] bins;
    ArrayList<Entry>[] bins;
    public double size;
    public double loadFactor;
    public double capacity;
    Set<K> keySet = new HashSet<K>();


    /**
     * Create a new hash map with a default array of size 16 and load factor of 0.75.
     */
    public HashMap() throws java.lang.ClassCastException {
        size = 0;
        bins = (ArrayList<Entry>[]) new ArrayList[16];
        loadFactor = 0.75;
        capacity = 16;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
    }


    /**
     * Create a new hash map with an array of size INITIALCAPACITY and default load factor of 0.75.
     */
    public HashMap(int initialCapacity) {
<<<<<<< HEAD
        capacity = initialCapacity;
        bins = (Entry<K, V>[]) new Entry[initialCapacity];
        size = 0;

    }

    /** Create a new hash map with INITIALCAPACITY and LOADFACTOR. */
    public HashMap(int initialCapacity, float loadFactor) {
        bins = (Entry<K, V>[]) new Entry[initialCapacity];
        this.loadFactor = loadFactor;
        size = 0;
=======
        size = 0;
        bins = (ArrayList<Entry>[]) new ArrayList[initialCapacity];
        loadFactor = 0.75;
        capacity = initialCapacity;

    }

    /**
     * Create a new hash map with INITIALCAPACITY and LOADFACTOR.
     */
    HashMap(int initialCapacity, float loadFactor) {
        size = 0;
        bins = (ArrayList<Entry>[]) new ArrayList[initialCapacity];
//        this.loadFactor = size/bins.length;
        this.loadFactor = loadFactor;
        capacity = initialCapacity;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
    }

    /**
     * Return the capacity of this hash table's internal array.
     */
    public int capacity() {
        return (int)capacity;
    }

    public int size() {
<<<<<<< HEAD
        return this.size;
=======
        return (int)this.size;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
    }

    // return an index for a key, what bucket to put it into
    public int hashCode(String key) {
        return (int) (key.charAt(0) - 'A');
    }

    /**
     * Returns true if the map contains the KEY.
     */
    public boolean containsKey(K key) {

<<<<<<< HEAD
        int modOfHash = (key.hashCode() & 0x7FFFFFFF)  % bins.length;
=======
        int modOfHash = (key.hashCode() & 0x7FFFFFFF) % this.capacity();
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
        if (bins[modOfHash] == null) {
            return false;
        }
        ArrayList<Entry> temp = bins[modOfHash];

        // if temp not null, compare it.
<<<<<<< HEAD
        while (temp != null) {
            if (temp._key.equals(key)) {
                return true;
=======
        if (temp != null) {
            for (Entry i : temp) {
                if (i._key.equals(key))
                    return true;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
            }
        }
        return false;
    }

    /**
     * Returns the value for the specified KEY.
     */
    public V get(K key) {
        if (!containsKey(key)) {
            System.out.println ("Key not found");
            return null;
        }
<<<<<<< HEAD
        int modOfHash = (key.hashCode() & 0x7FFFFFFF )  % bins.length;
        Entry<K, V> temp = bins[modOfHash];

        while (temp != null) {
            // if temp not null, compare it.
            if (temp._key.equals(key)) {
                return temp._value;
            }
            temp = temp._next;
=======
        int modOfHash = (key.hashCode() & 0x7FFFFFFF) % bins.length;
//        Entry<K, V> temp = bins[modOfHash];
        ArrayList<Entry> temp = bins[modOfHash];
        for (Entry i : temp) {
            if (i._key.equals(key))
                return (V) i._value;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
        }
        return null;
    }

    /**
     * Put a (KEY, VALUE) pair into this map.
     */
    public void put(K key, V value) {
<<<<<<< HEAD
        int modOfHash = (key.hashCode() & 0x7FFFFFFF) % bins.length;
        Entry<K, V> temp = bins[modOfHash];
        if (temp == null) {
            System.out.println("modOfHash is:" + modOfHash);
            bins [modOfHash] = new Entry<K, V> (key, value);
            System.out.println(bins[modOfHash]._value);
            keySet.add(key);
            size ++;
        } else {
            while (true) {
                if (temp._key.equals(key)) {
                    temp._value = value;
                    break;
                }
                if (temp._next == null) {
                    temp._next = new Entry<K, V>(key, value);
                    size++;
                    keySet.add(key);
                    break;
                }
                temp = temp._next;
            }
        }
        if (this.size > loadFactor * bins.length) {
            System.out.println("size before resize:" + size + " " + "bins before resize:" + bins.length);
            resize();
            System.out.println("size after resize:"+ size + " " + "bins before resize:"+ bins.length);
=======
        Entry given = new Entry(key, value);

        int modOfHash = (key.hashCode() & 0x7FFFFFFF) % bins.length;
        ArrayList<Entry> temp = bins[modOfHash];
        ArrayList<Entry> newElist = new ArrayList<>();

        if (temp != null) {
            for (Entry i : temp) {
                if (i._key.equals(key)) {
                    i._value = value;
                    return;
                }
            }
            temp.add(given);

        } else {
            newElist.add(new Entry(key, value));
            bins[modOfHash] = newElist;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
        }

        size++;
        resize();



    }


    public void resize() {
<<<<<<< HEAD
        Entry<K, V>[] prevBins = this.bins;
        this.bins = (Entry<K, V> []) new Entry[this.capacity()* 2];
        for (int i = 0; i < prevBins.length; i++) {
            while (prevBins[i] != null) {
                put(prevBins[i]._key, prevBins[i]._value);
                size --;
                prevBins[i]= prevBins[i]._next;
            }
=======
        if (size/bins.length > loadFactor) {

            capacity = capacity*2;
            ArrayList<Entry>[] resized = (ArrayList<Entry>[]) new ArrayList[(int)capacity];

            // copy contents to new list
            for (ArrayList<Entry> entries : bins) {
                if (entries != null) {
                    for (Entry entry : entries) {
                        int modOfHash = (entry._key.hashCode() & 0x7FFFFFFF) % bins.length;
                        if (resized[modOfHash] == null)
                            resized[modOfHash] = new ArrayList<>();
                        resized[modOfHash].add(entry);
                    }
                }


            }
            bins = resized;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
        }
    }

    /**
     * Remove a single entry, KEY, from this table and return the VALUE if successful or NULL otherwise.
     */
    public V remove(K key) {
        if (!containsKey(key)) {
            return null;
        } else {
<<<<<<< HEAD
            int modOfHash = (key.hashCode() & 0x7FFFFFFF) % bins.length;
            Entry<K, V> temp = bins[modOfHash];
            if (temp == null) {
                return null;
            } else {
                if (temp._key.equals(key)) {
                    V toReturn = temp._value;
                    bins[modOfHash] = null;
                    keySet.remove(key);
                    size --;
                    System.out.println("size after remove is" + size);
                    return toReturn;
                }
                else {
                    while (temp._next != null) {
                        if (temp._next._key.equals(key)) {
                            V toReturn = temp._next._value;
                            temp._next = temp._next._next;
                            System.out.println("size after remove is" + size);
                            keySet.remove(key);
                            size --;
                            return toReturn;
                        } temp = temp._next;
                    } return null;
                }
=======
            int modOfHash = key.hashCode() % bins.length;
            ArrayList<Entry> rem = bins[modOfHash];
            for (Entry entry : rem) {
                if (entry._key.equals(key)) {
                    rem.remove(entry);
                    size--;
                    return (V) entry._value;
                }
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
            }
        }
    }
<<<<<<< HEAD
    // remove all mapings, but key is still there. so don't erase key. just set null pointer?
    public void clear() {
        bins = (Entry<K, V>[]) new Entry[bins.length];
        size = 0;
=======
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f


    public void clear() {
        bins = (ArrayList<Entry>[]) new ArrayList[this.capacity()];
        size = 0;
    }
    public boolean remove(K key, V value) {
        throw new UnsupportedOperationException();
    }




//    public Iterator<K> iterator() {
//        return keySet.iterator();
//
//    }

    public Iterator<K> iterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator<K> {
        int aaa = bins.length;
        int bbb;
        int ccc = 0;
        int ddd = 0;

        public MapIterator() {

        }
        public boolean hasNext() {
            while (1==1) {
                if (aaa == ccc) {
                    return false;
                }
                ArrayList<Entry> tester = bins[ccc];
                if (tester == null) {
                    ccc++;
                    ddd = 0;
                    continue;
                }
                bbb = bins[ccc].size();
                break;
            }
            return true;
        }

        public K next() {
            Entry item = bins[ccc].get(ddd);
            ddd++;
            if (ddd >= bbb) {
                ccc++;
                ddd = 0;
            }
            return (K) item._key;
        }


    }


    // Let's add external chaining to our SimpleNameMap.
    // We can either use Java's LinkedList class or modify the Entry static nested class (by adding next pointers)
    // to support multiple entries in a bucket.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A wrapper class for holding each (KEY, VALUE) pair.
     */
    private class Entry<K, V> {

        /**
         * The key used for lookup.
         */
        public K _key;
        /**
         * The associated value.
         */
<<<<<<< HEAD
        private V _value;

=======
        public V _value;
>>>>>>> cb74131caa184b49c432bbae3b880e48bb721d2f
        private Entry<K, V> _next;

        /**
         * Create a new (KEY, VALUE) pair.
         */
        public Entry(K key, V value) {
            _key = key;
            _value = value;
            this._next = null;
        }

//        public boolean AddLast(Entry<K,V> lists,Entry<K,V> add){
//            if(lists == null){
//                lists = add;
//                bins[lists._key.hashCode() % bins.length]
//            }
//            if(lists._next == null){
//                lists._next = add;
//                return true;
//            }
//            return AddLast(lists._next,add);
//        }

        /**
         * Returns true if this key matches with the OTHER's key.
         */
        public boolean keyEquals(Entry<K, V> other) {
            return _key.equals(other._key);
        }

        /**
         * Returns true if both the KEY and the VALUE match.
         */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry &&
                    _key.equals(((Entry) other)._key) &&
                    _value.equals(((Entry) other)._value));
        }




    }
}





