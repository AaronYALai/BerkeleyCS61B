/*
* @Author: aaronlai
* @Date:   2017-06-26 12:03:47
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 19:08:16
*/

/* Invariants: 
    addLast: The next item we want to add, will go into position "size"
    size: number of items in the list should be size.
    getLast: the item we want to return is in position "size - 1"

*/

public class AList {
    /* prevent outsider from manipulating => private */
    private int[] items;
    private int size;
    private double usage_ratio;

    /* Constructor - create empty list: define memeory boxes */
    public AList(){
        /* initialized to [0 0 0 0 ....] */
        items = new int[10];
        size = 0;
    }

    /* make a indep, private method to help in resizing the array
    Can test the component independently, and easier to read */
    private void resize_array(int capacity){
        int[] new_array = new int[capacity];
        System.arraycopy(items, 0, new_array, 0, size);
        items = new_array;
    }

    public void addLast(int x){
        /* Make it dynamic */
        if (size == items.length){
            /* resizing factor => using mal is better than add */
            resize_array(size * 2);
        }

        /* "size" acts like the index for the last item */
        items[size] = x;
        size += 1;
    }

    public int getLast(){
        return items[size - 1];
    }

    public int get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public int removeLast(){
        /* setting deleted item to 0: not necessary to 
        preserve invariants */
        int x = getLast();
        size -= 1;

        usage_ratio = size * 1.0 / items.length;
        if (usage_ratio < 0.25){
            resize_array(items.length / 2);
        }
        System.out.println(usage_ratio);
        System.out.println(items.length);

        return x;
    }

    public static void main(String[] args) {

    }
}