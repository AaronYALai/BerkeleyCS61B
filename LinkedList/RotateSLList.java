/*
* @Author: aaronlai
* @Date:   2017-06-28 09:46:06
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-28 09:53:37
*/

public class RotateSLList<Item> extends DynSLList<Item>{

    /* Rotates list to the right. */
    public void rotateRight(){
        /* call methods in DynSLList */
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotateSLList<Integer> rs1 = new RotateSLList<>();
        rs1.addLast(10);
        rs1.addLast(11);
        rs1.addLast(12);
        rs1.addLast(13);

        /* should be [13, 10, 11, 12] */
        rs1.rotateRight();
        rs1.print();
    }
}