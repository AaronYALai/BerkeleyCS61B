/*
* @Author: aaronlai
* @Date:   2017-07-05 14:21:22
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-24 00:41:51
*/


/* Let Generic Item to be Comparable */
public class BinarySearch<Item extends Comparable<Item>>{

    private class Node<Item extends Comparable<Item>> implements Comparable<Node<Item>>{
        public Item label;

        public Node(Item key){
            label = key;
        }

        @Override
        public int compareTo(Node<Item> otherNode){
            return label.compareTo(otherNode.label);
        }
    }

    private int size;
    private int itemPos;
    private Node[] items;

    public BinarySearch(int capacity){
        /* self-defined class array can be used like this */
        items = new Node[capacity];
        size = 0;
    }

    private int indexBinarySearch(Node<Item> item){
        if (size == 0){
            return 0;
        }

        int start = -1;
        int end = size;
        int wizardPos = (start + end) / 2;

        while ((end - start) > 1){
            if (items[wizardPos].compareTo(item) > 0){
                end = wizardPos;
            } else {
                start = wizardPos;
            }

            wizardPos = (start + end) / 2;
        }
        return end;
    }

    public void insert(Item key){
        Node item = new Node(key);
        itemPos = indexBinarySearch(item);
        System.arraycopy(items, itemPos, items, itemPos + 1, size - itemPos);
        items[itemPos] = item;
        size += 1;
    }

    public Item find(Item key){
        Node item = new Node(key);
        itemPos = indexBinarySearch(item) - 1;
        /* Cannot without casting => Object */
        Item returnKey = (Item) items[itemPos].label;
        return returnKey;
    }

    public void delete(Item key){
        Node item = new Node(key);
        itemPos = indexBinarySearch(item) - 1;
        if (items[itemPos].label == key){
            System.arraycopy(items, itemPos + 1, items, itemPos, size - itemPos);
        }
        size -= 1;
    }

    public int size(){
        return size;
    }

    public void print(){
        int posPrint = 0;
        while (posPrint < size){
            System.out.println(items[posPrint].label);
            posPrint += 1;
        }
    }
}