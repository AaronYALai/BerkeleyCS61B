/*
* @Author: aaronlai
* @Date:   2017-07-23 21:38:08
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-28 19:24:02
*/

public class RunBinarySearch {

    public static String newline = System.getProperty("line.separator");

    public static void main(String[] args) {

        System.out.println("Binary Search of Strings using Array:");
        BinarySearch<String> bs = new BinarySearch(100);
        bs.insert("b");
        bs.insert("d");
        bs.insert("e");
        bs.insert("a");
        bs.insert("c");
        bs.insert("a");
        bs.insert("f");
        bs.insert("A");
        bs.insert("c");
        bs.insert("a");
        bs.insert("f");
        bs.print();

        System.out.println(bs.find("d"));
        System.out.println(bs.find("e"));
        bs.delete("b");
        bs.delete("e");
        System.out.println(bs.size());
        bs.print();

        System.out.println(newline + "Binary Search of Integers using Array:");
        BinarySearch<Integer> bsInt = new BinarySearch(100);
        bsInt.insert(6);
        bsInt.insert(9);
        bsInt.insert(7);
        bsInt.insert(1);
        bsInt.insert(5);
        bsInt.insert(6);
        bsInt.insert(3);
        bsInt.insert(8);
        bsInt.insert(0);
        bsInt.insert(5);
        bsInt.insert(4);
        bsInt.insert(16);
        bsInt.print();

        System.out.println(bsInt.find(7));
        System.out.println(bsInt.find(5));
        bsInt.delete(4);
        bsInt.delete(6);
        System.out.println(bsInt.size());
        bsInt.print();

        System.out.println(newline + "Binary Search of Strings using Tree:");
        BinarySearchTree<String> bst = new BinarySearchTree();
        bst.insert("b");
        bst.insert("d");
        bst.insert("e");
        bst.insert("a");
        bst.insert("c");
        bst.insert("a");
        bst.insert("f");
        bst.insert("A");
        bst.insert("c");
        bst.insert("a");
        bst.insert("f");
        bst.traverseInOrder();

        System.out.println(bst.find("d"));
        System.out.println(bst.find("e"));
        System.out.println(bst.left.depth());
        System.out.println(bst.right.depth());
        System.out.println(bst.delete("b"));
        System.out.println(bst.delete("e"));
        System.out.println(bst.depth());
        bst.traverseInOrder();

        System.out.println(newline + "Binary Search of Integers using Tree:");
        BinarySearchTree<Integer> bst1 = new BinarySearchTree();
        bst1.insert(5);
        bst1.insert(9);
        bst1.insert(1);
        bst1.insert(3);
        bst1.insert(0);
        bst1.insert(7);
        bst1.insert(2);
        bst1.insert(8);
        bst1.traverseInOrder();

        System.out.println(bst1.find(0));
        System.out.println(bst1.find(4));
        bst1.delete(8);
        bst1.delete(0);
        System.out.println(bst1.depth());
        bst1.traverseInOrder();

        System.out.println(newline + "Binary Search of Strings using 2-3 Tree (RB Tree):");
        BTreebyRBTree<String> rbst = new BTreebyRBTree();
        rbst.insert("b");
        rbst.insert("d");
        rbst.insert("e");
        rbst.insert("a");
        rbst.insert("c");
        rbst.insert("a");
        rbst.insert("f");
        rbst.insert("A");
        rbst.insert("c");
        rbst.insert("a");
        rbst.insert("f");
        rbst.traverseInOrder();

        System.out.println(rbst.find("d"));
        System.out.println(rbst.find("e"));
        System.out.println(rbst.delete("b"));
        System.out.println(rbst.depth());

        System.out.println(newline + "Binary Search of Integers using 2-3 Tree (RB Tree):");
        BTreebyRBTree<Integer> rbst1 = new BTreebyRBTree();
        rbst1.insert(5);
        rbst1.insert(9);
        rbst1.insert(1);
        rbst1.insert(3);
        rbst1.insert(0);
        rbst1.insert(7);
        rbst1.insert(2);
        rbst1.insert(8);
        rbst1.traverseInOrder();

        System.out.println(rbst1.find(0));
        System.out.println(rbst1.find(4));
        rbst1.delete(8);
        System.out.println(rbst1.depth());
    }
}