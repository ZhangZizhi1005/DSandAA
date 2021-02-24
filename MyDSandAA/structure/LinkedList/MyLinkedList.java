package structure;

import java.util.Iterator;

class MyLinkedList<T> implements Iterable<T>{

    //nested class
    private static class node<T>{
        public node<T> prev;
        public node<T> next;
        T data;

        public node(T t, node<T> p, node<T> n){
            data = t;
            prev = p;
            next = n;
        }
    }

    //instance fields
    private int theSize;
    private node<T> head;
    private node<T> tail;

    //constructor
    public MyLinkedList(){
        clear();
    }

    //clear the link
    public void clear(){
        head = new node<>(null,null,null);
        tail = new node<>(null,null,null);

        head.next = tail;
        tail.prev = head;

        theSize = 0;
    }

    //size
    public int size(){
        return theSize;
    }

    //whether the Link is empty
    public boolean  isEmpty(){
        return size() == 0;
    }

    // find the node at the index position
    private node<T> getNode(int index){
        if(index < 0||index > size()-1)
            return null;

        if(index >= size()/2){
            var nodeAtIndex = tail;
            for(int i = size()-1; i > index; i--){
                nodeAtIndex = nodeAtIndex.prev;
            }
            return nodeAtIndex.prev;
        }

        var nodeAtIndex = head;
        for(int i = 0; i < index; i++){
            nodeAtIndex = nodeAtIndex.next;
        }
        return nodeAtIndex.next;
    }

    // Accessor of  the element at the index position
    public T find(int index){
        return getNode(index).data;
    }

    // Changer of the element at the index position
    public boolean set(int index,T t){
        if(index < -1||index > size() - 1)
            return false;
        getNode(index).data = t;
        return true;
    }

    // Accessor of the head and the tail
    public node<T> findHead(){
        return head;
    }
    public node<T> findTail(){
        return tail;
    }

    //add
    public void add(T t){
        add(t,size());
    }
    public void addBefore(T t){
        add(t,0);
    }
    public boolean add(T t, int index){
        if(index < 0 || index > size())
            return false;

        var nodeAtNextIndex=index==size() ? tail : getNode(index);

        var nodeAtIndex = new node<>(t,nodeAtNextIndex.prev,nodeAtNextIndex);
        nodeAtNextIndex.prev.next = nodeAtIndex;
        nodeAtNextIndex.prev = nodeAtIndex;

        theSize++;
        return true;
    }

    //remove
    public void remove(){
        remove(size() - 1);
    }
    public boolean remove(int index){
        if(index < 0||index > size()-1)
            return false;

        var nodeAtIndex = getNode(index);
        nodeAtIndex.next.prev = nodeAtIndex.prev;
        nodeAtIndex.prev.next = nodeAtIndex.next;

        theSize--;

        return true;
    }

    //search
    public int find(T t){
        int count = 0;
        var nodeToBeChecked = head.next;

        while (nodeToBeChecked != tail) {
            if (nodeToBeChecked.data == t)
                return count;
            count ++;
        }

        return -1;
    }

    //Iterable
    public Iterator<T> iterator(){

        return new MyLinkedListIterator();
    }

    public class MyLinkedListIterator implements Iterator<T>{
        // instance fields
        node<T> nodeNow;

        //constructor
        public MyLinkedListIterator(){
            nodeNow = head.next;
        }

        @Override
        public boolean hasNext() {
            return nodeNow != tail;
        }

        @Override
        public T next() {
            nodeNow = nodeNow.next;
            return nodeNow.data;
        }

        @Override
        public void remove() {
            nodeNow.next.prev = nodeNow.prev;
            nodeNow.prev.next = nodeNow.next;
        }
    }
}