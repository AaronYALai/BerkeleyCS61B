/*
* @Author: aaronlai
* @Date:   2017-06-22 14:41:00
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-22 22:28:00
*/

/* An SLList is a list of integers, which hides the nakedness */
public class SLList {

    /** Nested class: define the class inside 
    If the nested class doesn't need to look out => declare it static
    **/
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    /* public ketword to private keyword
    public IntNode first;
    */
    private IntNode first;
    private IntNode sentinel;
    /* cache size */
    private int size;

    /* Improvement 6: empty list */
    public SLList(){
        size = 0;
        /* set first to null is ok for addFirst but not addLast ! => im7
        first = null;
        */

        /* more compact way: "first"'s data type consistent => sentinel node */
        sentinel = new IntNode(-1, null);
    }

    public SLList(int x) {
        sentinel = new IntNode(-1, null);
        // first = new IntNode(x, sentinel);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /* adds x to the front of the list; */
    public void addFirst(int x){
        // first = new IntNode(x, first);
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /* adds x to the last of the list; */
    public void addLast(int x){
        /* im7: fisrt can be "null"
        => should not change the type of p
        if (first == null){
            first = new IntNode(x, null);
            return;
        }
        */

        // IntNode p = first;
        IntNode p = sentinel;
        /* copy reference! */
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    /* SLList is not recursive itself => helper function */
    public int size(){
        /* cache */
        return size;
        /* private method */
        // return size(first);
        // return size(sentinel.next);
    }

    /* return the size of the list that starts at p */
    private static int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }

    /* adds x to the front of the list; */
    public int getFirst(){
        // return first.item;  /* defined in IntNode */
        return sentinel.next.item;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer */
        SLList L = new SLList();
        L.addLast(15);
        L.addFirst(11);
        L.addFirst(12);
        L.addFirst(14);
        L.addLast(15);
        /* prevented by "private" keyword for "other" classes
        L.first.next.next = L.first.next;
        */ 
        // System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}