/*
* @Author: aaronlai
* @Date:   2017-06-23 22:15:46
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 20:09:55
*/

public class DynSLList<Item> implements ListBase<Item>{
    private class StuffNode {
        public Item item;
        public StuffNode next;

        public StuffNode(Item i, StuffNode n){
            item = i;
            next = n;
        }
    }

    private class SentinelNode {
        public int item;
        public StuffNode next;

        public SentinelNode(StuffNode n){
            item = 1;
            next = n;
        }
    }

    private StuffNode first;
    private SentinelNode sentinel;
    /* cache size */
    private int size;

    /* Constructer - Improvement 6: empty list */
    public DynSLList(){
        size = 0;
        sentinel = new SentinelNode(null);
    }

    public DynSLList(Item x) {
        sentinel = new SentinelNode(null);
        // first = new StuffNode(x, sentinel);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    @Override
    /* adds x to the front of the list; */
    public void addFirst(Item x){
        // first = new StuffNode(x, first);
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    // /* adds x to the last of the list; */
    // public void addLast(Item x){
    //     /* im7: fisrt can be "null"
    //     => should not change the type of p
    //     if (first == null){
    //         first = new StuffNode(x, null);
    //         return;
    //     }
    //     */

    //     // StuffNode p = first;
    //     SentinelNode p = sentinel;
    //     /* copy reference! */
    //     while (p.next != null){
    //         p = p.next;
    //     }
    //     p.next = new StuffNode(x, null);
    //     size += 1;
    // }

    @Override
   /* adds x to the last of the list; Generic */
    public void addLast(Item x){
        size += 1;

        if (sentinel.next == null){
            sentinel.next = new StuffNode(x, null);
            return;
        }

        StuffNode p = sentinel.next;

        while (p.next != null){
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    /* adds x to the front of the list; */
    public Item getFirst(){
        // return first.item;  /* defined in StuffNode */
        return sentinel.next.item;
    }

    @Override
    public Item getLast(){
        StuffNode p = sentinel.next;

        while (p.next != null){
            p = p.next;
        }
        return p.item;
    }

    @Override
    public Item get(int i){
        StuffNode now;
        now = sentinel.next;
        while (i != 0){
            now = now.next;
            i -= 1;
        }

        return now.item;
    }

    @Override
    public Item removeLast(){
        size -= 1;
        Item x = getLast();

        if (sentinel.next.next == null){
            sentinel.next = null;
            return x;
        }

        StuffNode p = sentinel.next;

        while (p.next.next != null){
            p = p.next;
        }
        p.next = null;
        return x;
    }

    /* override the default method to be more efficient */
    @Override
    public void print(){
        for (StuffNode p = sentinel.next; p != null; p = p.next){
            System.out.print(p.item + " ");
        }
    }

    public static void main(String[] args) {
        DynSLList<String> L = new DynSLList<String>();
        L.addLast("hi");
        L.addFirst("hello");
        L.addLast("hello2");
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}