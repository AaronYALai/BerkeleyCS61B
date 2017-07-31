/*
* @Author: aaronlai
* @Date:   2017-06-26 12:03:47
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 19:39:39
*/

/* Invariants: 
    addLast: The next item we want to add, will go into position "size"
    size: number of items in the list should be size.
    getLast: the item we want to return is in position "size - 1"

*/

public class GenericAList<Item> implements ListBase<Item>{
    /* prevent outsider from manipulating => private */
    private Item[] items;
    private int size;

    /* create empty list: define memeory boxes */
    public GenericAList(){
        items = (Item[]) new Object[100];
        size = 0;
    }

    /* make a indep, private method to help in resizing the array
    Can test the component independently, and easier to read */
    private void resize_array(int capacity){
        Item[] new_array = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, new_array, 0, size);
        items = new_array;
    }

    @Override
    public void addLast(Item x){
        if (size == items.length){
            resize_array(size * 2);
        }

        items[size] = x;
        size += 1;
    }

    @Override
    public void addFirst(Item x){
        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
        size += 1;
    }

    @Override
    public Item getLast(){
        return items[size - 1];
    }

    @Override
    public Item getFirst(){
        return items[0];
    }

    @Override
    public Item get(int i){
        return items[i];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Item removeLast(){
        Item x = getLast();
        size -= 1;
        items[size] = null;

        return x;
    }

    public static void main(String[] args) {

    }
}