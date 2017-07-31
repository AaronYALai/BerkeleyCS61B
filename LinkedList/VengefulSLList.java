/*
* @Author: aaronlai
* @Date:   2017-06-28 22:57:21
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-28 23:22:22
*/

/* record all deleted items */
public class VengefulSLList<Item> extends DynSLList<Item> {
    DynSLList<Item> deletedItems;
    /* deletedItems is "null" in default */

    /* use a constructor to make deletedItems */
    public VengefulSLList(){
        deletedItems = new DynSLList<Item>();
    }

    /* super with argument */
    public VengefulSLList(Item x){
        /* If don't expicitly use "super(x)" => call "default" constructor
         => will be no argument version!! */
        super(x);
        deletedItems = new DynSLList<Item>();
    }

    /* only copy and paste DynSLList's removeLast will result in errors
    => "size" and "sentinel" are private variables!!! */
    @Override
    public Item removeLast(){
        /* Use "super" to execute SLList's method */
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public void printLostItems(){
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<Integer>(9);
        vs1.addLast(10);
        vs1.addLast(11);
        vs1.addLast(12);
        vs1.addLast(13);

        vs1.removeLast();
        vs1.removeLast();
        /* now should be [10, 11] */

        /* should print out fallen numbers => 13 and 12 */
        System.out.print("The fallen are:");
        vs1.printLostItems();
        vs1.print();
    }
}