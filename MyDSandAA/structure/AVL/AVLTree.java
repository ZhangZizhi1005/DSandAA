package structure.AVL;

public class AVLTree<T extends Comparable<? super T>>{

    // nested class for avl tree node
    private static class AvlNode<T>{
        // fields
        T element; // data in the node
        AvlNode<T> lt; // left child tree
        AvlNode<T> rt; // right child tree
        int height; // height of current node

        // Constructor of AvlNodes
        public AvlNode(T t){
            this(t,null,null);
        }
        public AvlNode(T t, AvlNode<T> left, AvlNode<T> right){
            element = t;
            lt = left;
            rt = right;
            height = 0;
        }
    }

    private AvlNode<T> root;

    /*
    AVL IS-A BST. So all the method BST contains works still for a AVL.
    Relational code omitted here.
    Just implement the Insertion and Deletion
     */

    /**
     * Return the height of node t, or -1 if null
     */
    private int height(AvlNode<T> t){
        return t == null ? -1 : t.height;
    }


    /**
     * Draw schematic diagram before writing rotation code
     *
     * For left-left case
     * Rotate binary node with left child
     * Update height and return new root
     */
    private AvlNode<T> rotateLL(AvlNode<T> k2){
        AvlNode<T> k1 = k2.lt;

        k2.lt = k1.rt;
        k1.rt = k2;

        k2.height = Math.max( height(k2.lt),height(k2.rt))+1;
        k1.height = Math.max( height(k1.lt),height(k1.rt))+1;

        return k1;
    }

    /**
     * For right-right case
     * Totally symmetry with rotateLL
     */
    private AvlNode<T> rotateRR(AvlNode<T> k2){
        AvlNode<T> k1 = k2.rt;

        k2.rt = k1.lt;
        k1.lt = k2;

        k2.height = Math.max( height(k2.lt),height(k2.rt))+1;
        k1.height = Math.max( height(k1.lt),height(k1.rt))+1;

        return k1;
    }

    private AvlNode<T> rotateRL(AvlNode<T> k3){
        AvlNode<T> k1 = k3.lt;
        AvlNode<T> k2 = k1.rt;

    }
}