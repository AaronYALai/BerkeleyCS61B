/*
* @Author: aaronlai
* @Date:   2017-07-23 11:41:31
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-25 15:16:08
*/

/* Static method cannot have generic object as input !! */
public class BinarySearchTree<Item extends Comparable<Item>> {

    public BinarySearchTree<Item> left;
    public BinarySearchTree<Item> right;
    public Item label;

    public BinarySearchTree(){}

    public void insert(Item newKey){
        if (label == null){
            label = newKey;
            left = new BinarySearchTree();
            right = new BinarySearchTree();
        } else if (label.compareTo(newKey) > 0){
            left.insert(newKey);
        } else {
            right.insert(newKey);
        }
    }

    public void traverseInOrder(){
        if (this.left != null) this.left.traverseInOrder();
        if (this.label != null) System.out.println(this.label);
        if (this.right != null) this.right.traverseInOrder();
    }

    public Item find(Item key){
        if (this.label == null){
            return null;
        } else if (this.label == key){
            return this.label;
        } else if (this.label.compareTo(key) > 0){
            return this.left.find(key);
        } else {
            return this.right.find(key);
        }
    }

    public int depth(){
        if (label == null){
            return 0;
        }

        int left_depth = this.left.depth();
        int right_depth = this.right.depth();
        int depth;

        if (left_depth > right_depth){
            depth = left_depth + 1;
        } else {
            depth = right_depth + 1;
        }

        return depth;
    }

    private Item find_rightest(){
        if (this.label == null){
            return null;
        } else if (this.right.label == null){
            return this.label;
        } else {
            return this.right.find_rightest();
        }
    }

    private Item find_leftest(){
        if (this.label == null){
            return null;
        } else if (this.left.label == null){
            return this.label;
        } else {
            return this.left.find_rightest();
        }
    }

    private BinarySearchTree<Item> cut_rightest(){
        if (this.label == null){
            return null;
        } else if (this.right.label == null){
            return this.left;
        } else {
            BinarySearchTree<Item> bst = new BinarySearchTree();
            bst.label = this.label;
            bst.left = this.left;
            bst.right = this.right.cut_rightest();
            return bst;
        } 
    }

    private BinarySearchTree<Item> cut_leftest(){
        if (this.label == null){
            return null;
        } else if (this.left.label == null){
            return this.right;
        } else {
            BinarySearchTree<Item> bst = new BinarySearchTree();
            bst.label = this.label;
            bst.right = this.right;
            bst.left = this.left.cut_rightest();
            return bst;
        } 
    }

    public Item delete(Item key){
        if (this.label == key){
            int left_depth = this.left.depth();
            int right_depth = this.right.depth();
            Item returnKey = this.label;

            if (left_depth > right_depth){
                this.label = this.left.find_rightest();
                this.left = this.left.cut_rightest();
            } else {
                this.label = this.right.find_leftest();
                this.right = this.right.cut_leftest();
            }

            return returnKey;
        }

        if (this.label == null){
            return null;
        } else if (this.label.compareTo(key) > 0){
            return this.left.delete(key);
        } else {
            return this.right.delete(key);
        }
    }

}