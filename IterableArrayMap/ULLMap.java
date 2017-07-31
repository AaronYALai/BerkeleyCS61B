/*
* @Author: aaronlai
* @Date:   2017-07-22 22:00:16
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-23 01:04:33
*/

import java.util.Iterator;

public class ULLMap<ItemKey, ItemValue> implements Iterable<ItemKey>{

    private class Node{
        public ItemKey key;
        public ItemValue value;
        public Node next;

        public Node(ItemKey newKey, ItemValue newValue, Node nextNode){
            key = newKey;
            value = newValue;
            next = nextNode;
        }
    }

    private class Sentinel{
        public Node next;

        public Sentinel(Node node){
            next = node;
        }
    }

    private int size;
    private Sentinel sentinel;

    public ULLMap(){
        size = 0;
        sentinel = new Sentinel(null);
    }

    public ItemValue get(ItemKey key){
        Node node = sentinel.next;
        while (node.key != key){
            node = node.next;
        }
        return node.value;
    }

    public int size(){
        return size;
    }

    public boolean containsKey(ItemKey key){
        if (sentinel.next == null){
            return false;
        }

        Node node = sentinel.next;
        while (node != null){
            if (node.key == key){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void put(ItemKey key, ItemValue value){
        Node node = sentinel.next;

        while (node != null){
            if (node.key == key){
                node.value = value;
                return;
            }
            node = node.next;
        }

        size += 1;
        sentinel.next = new Node(key, value, sentinel.next);
    }

    public void clear(ItemKey key){
        Node node = sentinel.next;

        if (node.key == key){
            sentinel.next = node.next;
            size -= 1;
            return;
        }

        while (node.next.key != key){
            node = node.next;
        }
        node.next = node.next.next;
        size -= 1;
    }

    /* Map Iterator */
    public class ULLMapIter implements Iterator<ItemKey>{
        private int wizardPos;
        private Node node = sentinel.next;

        public ULLMapIter(){
            wizardPos = 0;
        }

        public boolean hasNext(){
            return wizardPos < size;
        }

        public ItemKey next(){
            ItemKey key = node.key;
            node = node.next;
            wizardPos += 1;
            return key;
        }
    }

    @Override
    public Iterator<ItemKey> iterator(){
        ULLMap.ULLMapIter mapIter = new ULLMap.ULLMapIter();
        return mapIter;
    }
}