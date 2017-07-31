/*
* @Author: aaronlai
* @Date:   2017-07-01 15:28:11
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-02 21:49:40
*/

import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;


public class ArrayMap<K, V> implements Iterable<K>{

    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap(){
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /* private helper/callback function to return
    the index of the given key if it exists */
    public int keyIndex(K key){
        for (int i = 0; i < keys.length; i += 1){
            /* "==" operation is to examine if pointing to the same memory boxes !!
             not comparing values => define our own "equals" method instead */
            if (keys[i] == key){
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key){
        int index = keyIndex(key);
        return (index > -1);
    }

    public void put(K key, V value){
        /* if key exists, replace the value. Put the value into a new slot otherwise. */
        int index = keyIndex(key);
        if (index == -1){
            keys[size] = key;
            values[size] = value;
            size += 1;
            return;
        }
        values[index] = value;
    }

    public V get(K key){
        /* crashing when key not exists */
        int index = keyIndex(key);

        /* Exceptions */
        if (index == -1){
            throw new IllegalArgumentException("The key doesn't exists.");
        }
        return values[index];
    }

    public List<K> keys(){
        List<K> keylist = new ArrayList<K>();
        for (int i = 0; i < size; i += 1){
            keylist.add(keys[i]);
        }
        return keylist;
    }

    /* Iterator and Iteration: this class is associated with class ArrayMap
    => Usage: am.new KeyIterator(); where "am" is an ArrayMap instance */
    public class KeyIterator implements Iterator<K>{
        private int wizardPosition;

        /* constructor (init) - make a wizard */
        public KeyIterator(){
            wizardPosition = 0;
        }

        /* not done: size not reached */
        public boolean hasNext(){
            return wizardPosition < size;
        }

        public K next(){
            K returnVal = keys[wizardPosition];
            wizardPosition += 1;
            return returnVal;
        }
    }

    @Override
    public Iterator<K> iterator(){
        /* KetIterator should implements Iterator */
        // return new KeyIterator();

        /* Better version */
        List<K> keylist = keys();
        return keylist.iterator();
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> L = new ArrayMap<String, Integer>();
        L.put("horse", 3);
        L.put("fish", 9);
        L.put("pig", 12);
        System.out.println(L.keys());
        System.out.println(L.get("pig"));
        System.out.println(L.containsKey("fish"));
        // L.get("ok");
        for (String s : L){
            System.out.println(s);
        }
    }
}