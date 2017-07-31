/*
* @Author: aaronlai
* @Date:   2017-07-27 17:24:03
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-28 19:23:35
*/

/* 
Implementing 2-3 Tree (BTree) by Left-Leaning Red-Black Tree 
BTree: always perfectly balanced => using promote, rotate, and split
*/
public class BTreebyRBTree<Item extends Comparable<Item>> {

    private RBnode<Item> root;
    private boolean isometryBroken;

    /* Red-Black node */
    private class RBnode<Item extends Comparable<Item>>{
        public RBnode<Item> leftNode;
        public RBnode<Item> rightNode;
        public RBnode<Item> parent;
        public boolean redLink;
        public boolean isLeftChild;
        public Item label;

        public RBnode(RBnode<Item> currentNode, boolean leftChild){
            parent = currentNode;
            redLink = false;
            isLeftChild = leftChild;
        }
    }

    public BTreebyRBTree(){
        root = new RBnode<Item>(null, true);
        isometryBroken = false;
    }

    public void insert(Item newKey){
        RBnode<Item> currentNode = root;

        while (currentNode.label != null){
            if (currentNode.label.compareTo(newKey) > 0){
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }

        currentNode.label = newKey;
        currentNode.leftNode = new RBnode(currentNode, true);
        currentNode.rightNode = new RBnode(currentNode, false);

        /* paint the link red and check Isometry (might break after colorFlip) */
        if (currentNode.parent != null){
            if (currentNode.isLeftChild){
                currentNode.parent.redLink = true;
                currentNode = checkLeftChild(currentNode.parent);
            } else {
                currentNode = checkRightChild(currentNode.parent);           
            }
        }

        /* rebuild Isometry: broken because currentNode has a right red link to its parent
        -> just like adding a right child */
        if (isometryBroken){
            if (currentNode.isLeftChild){
                currentNode = checkLeftChild(currentNode.parent);
            } else {
                currentNode = checkRightChild(currentNode.parent);
            }
        }
    }

    /* add as a left child: do nothing or (rotateRight + colorFlip) */
    private RBnode<Item> checkLeftChild(RBnode<Item> node){
        if (node.parent != null && node.isLeftChild && node.parent.redLink){
            node = rotateRight(node.parent);
            isometryBroken = colorFlip(node);
        }
        return node;
    }

    /* add as a right child: rotateLeft, color flip, or (rotateLeft + rotateRight + colorFlip) */
    private RBnode<Item> checkRightChild(RBnode<Item> node){
        /* red sibling */
        if (node.redLink){
            isometryBroken = colorFlip(node);
        /* red grandparent */
        } else if (node.parent != null && node.isLeftChild && node.parent.redLink){
            node = rotateLeft(node);
            node = rotateRight(node.parent);
            isometryBroken = colorFlip(node);
        /* only "right" red child */
        } else {
            node = rotateLeft(node);
            isometryBroken = false;
        }
        return node;
    }

    private RBnode<Item> rotateLeft(RBnode<Item> node){
        RBnode<Item> child = node.rightNode;

        /* connect node's parent with node's right child */
        child.parent = node.parent;
        if (node.parent != null){
            if (node.isLeftChild){
                child.parent.leftNode = child;
                child.isLeftChild = true;
            } else {
                child.parent.rightNode = child;
                child.isLeftChild = false;
            }
        } else {
            root = child;
            child.isLeftChild = true;
        }

        /* make child's leftNode to be node's rightNode */
        RBnode<Item> cleft = child.leftNode;
        node.rightNode = cleft;
        node.rightNode.isLeftChild = false;
        node.rightNode.parent = node;
        /* child's leftNode now should be the node */
        child.leftNode = node;
        node.isLeftChild = true;
        child.leftNode.parent = child;

        child.redLink = true;

        return child;
    }

    private RBnode<Item> rotateRight(RBnode<Item> node){

        RBnode<Item> child = node.leftNode;
        child.parent = node.parent;

        if (node.parent != null){
            if (node.isLeftChild){
                child.parent.leftNode = child;
                child.isLeftChild = true;
            } else {
                child.parent.rightNode = child;
                child.isLeftChild = false;
            }
        } else {
            root = child;
            child.isLeftChild = true;
        }

        RBnode<Item> cright = child.rightNode;
        node.leftNode = cright;
        node.leftNode.isLeftChild = true;
        node.leftNode.parent = node;

        child.rightNode = node;
        child.rightNode.isLeftChild = false;
        child.rightNode.parent = child;
        child.rightNode.redLink = false;

        return child;
    }

    /* flip the color and return if Isometry is broken */
    private boolean colorFlip(RBnode<Item> node){
        node.redLink = false;
        if (node.parent == null){
            return false;
        } else {
            if (node.isLeftChild){
                node.parent.redLink = true;
                if (node.parent.parent != null &&  node.parent.parent.redLink){
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
    }

    public Item find(Item key){
        RBnode<Item> node = root;

        while (node.label != null){
            if (node.label.compareTo(key) == 0){
                return node.label;
            } else if (node.label.compareTo(key) > 0){
                node = node.leftNode;
            } else {
                node = node.rightNode;
            }
        }

        return null;
    }

    public int depth(){
        return nodeDepth(root);
    }

    private int nodeDepth(RBnode<Item> node){
        int depth = 0;
        if (node.label != null){
            int leftDepth = nodeDepth(node.leftNode);
            int rightDepth = nodeDepth(node.rightNode);

            rightDepth += 1;
            if (!node.redLink){
                leftDepth += 1;
            }
            if (leftDepth > rightDepth){
                depth = leftDepth;
            } else {
                depth = rightDepth;
            }
        }

        return depth;
    }

    /* not implement */
    public Item delete(Item key){
        System.out.println("Not Impleneted.");
        return key;
    }

    public void traverseInOrder(){
        traverseNodes(root);
    }

    private void traverseNodes(RBnode<Item> node){
        if (node.label != null){
            System.out.println(node.label);
            System.out.println(node.leftNode.label);
            System.out.println(node.rightNode.label);
            if (node.parent != null){
                System.out.println(node.parent.label);
            } else {
                System.out.println("null");
            }
            System.out.println(node.redLink);
            System.out.println(node.isLeftChild);
            System.out.println(" ");
            traverseNodes(node.leftNode);
            traverseNodes(node.rightNode);
        }
    }
}