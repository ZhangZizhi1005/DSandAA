package structure.BST;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<T extends Comparable<? super T>>{
    // nested class to store node
    private static class BinaryNode<T>{
        T element; // data in the node
        BinaryNode<T> lt; // left child node
        BinaryNode<T> rt; // right child node

        // Constructor of node
        public BinaryNode(T t){
            this(t, null, null);
        }
        public BinaryNode(T t, BinaryNode<T> left ,BinaryNode<T> right){
            element = t;
            lt = left;
            rt = right;
        }
    }

    //field of tree
    private BinaryNode<T> root;

    //Constructor of tree
    public BinarySearchTree(){
        root = null;
    }

    //direct method
    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    // use public method to call recursive private method
    public boolean contains(T x){
        return contains(x, root);
    }

    public T findMin(){
        if(isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public T findMax(){
        if(isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(T x){
        root = insert(x, root);
    }

    public void remove(T x){
        root = remove(x, root);
    }

    public void printTree(){
        if(isEmpty())
            System.out.println("The tree is empty");
        printTree(root);
    }


    // recursive private method

    /**
     * Internal method to find an item in a subtree
     * @param x item to search for
     * @param t the node that roots the subtree
     * @return node containing the matched item
     */
    private boolean contains(T x, BinaryNode<T> t){
        if( t == null )
            return false;

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0)
            return contains(x, t.lt);
        else if(compareResult > 0)
            return contains(x, t.rt);
        else
            return true;
    }

    /**
     * Internal method to find the smallest item in a subtree, iterative method
     * @param t the node that roots the subtree
     * @return node containing the smallest item
     */
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if(t == null)
            return null;
        while(t.lt != null)
            t = t.lt;
        return t;
    }

    /**
     * Internal method to find the biggest item in a subtree, recursive method
     * @param t the node that roots the subtree
     * @return node containing the biggest item
     */
    private BinaryNode<T> findMax(BinaryNode<T> t){
        if(t != null){
            if(t.rt == null)
                return t;
            else
                findMax(t.rt);
        }
        return null;
    }

    /**
     * Internal method to insert into a subtree
     * @param x the item to insert
     * @param t the node that roots the subtre
     * @return the new toot of new subtree
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t){
        if(t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0)
            t.lt = insert(x, t.lt );
        if(compareResult > 0)
            t.rt = insert(x, t.rt);
        else
            System.out.println("the item is already there"); // duplicate, do something

        return t;
    }

    /**
     * Internal method to remove from a subtree
     * @param x the item to remove
     * @param t the node that roots the subtree
     * @return the new root of subtree
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> t){
        if(t == null)
            return t;

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0)
            t.lt = remove(x, t.lt);
        if(compareResult > 0)
            t.rt = remove(x,t.rt);

        else if(t.lt != null && t.rt != null){
            t.element = findMin(t.rt).element;
            t.rt = remove(t.element, t.rt);
        }
        else
            t =(t.lt != null)?t.lt:t.rt;

        return t;
    }

    /**
     * Print tree contents in sorted order. It is an inorder traversal.
     * @param t
     */
    private void printTree(BinaryNode<T> t){
        printTree(t.lt);
        System.out.println(t.element);
        printTree(t.rt);

    }
}

