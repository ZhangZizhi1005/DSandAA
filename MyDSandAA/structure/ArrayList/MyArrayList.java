package structure.ArrayList;


public class MyArrayList<T> implements Iterable<T>
{
   // 默认构造数组的大小，根据其特性，加上static和final关键字
   private static final int DEFAULT_CAPACITY = 10;

   // 声明数组
   private T[] theList;
   // 声明一个数字来保存现有元素的个数！！！ 卡在这里过
   private int theSize;

   //构造函数：正常时候我们会写clear中的两条语句，结果写到clear的时候突然可以复用
   public MyArrayList(){
      clear();
   }

   //数组扩容
   public void ensureCapacity(int newCapacity){
      if(newCapacity < theSize) return;

      T[] old = theList;
      theList = (T[]) new Object[newCapacity];

      for(int i = 0; i <= theSize -1 ; i++){
         theList[i] = old[i];
      }
   }

   //theSize的访问器
   public int size(){
      return theSize;
   }
   public boolean isEmpty(){
      return theSize == 0;
   }

   //theList的访问器和更改器
   public T get(int idx){
      if(idx < 0 || idx >= theSize){
         return null;
      }
      return theList[idx];
   }
   public boolean set(T newItem, int idx){
      if(idx < 0  || idx >= theSize)
         return false;
      theList[idx] = newItem;
      return true;
   }
   public void clear(){
      // 写集合的Clear时候的一个常见的方法，创建一个新的即可。由于clear不能调用构造函数，所以用构造来调用这个clear
      theList = (T[]) new Object[DEFAULT_CAPACITY];
      theSize = 0;
   }

   //增
   public void add(T newItem){
      add(newItem, size());
   }
   public boolean add(T newItem, int idx){
      if(idx < 0 || idx > size())
         return false;
      if(size() == theList.length){
         ensureCapacity(size()*2);
      }
      for(int i = theList.length -1; i > idx; i--){
         theList[i] = theList[i-1];
      }
      theList[idx] = newItem;
      theSize ++;
      return true;
   }

   // 查
   public int find (T item){
       for (int i = 0; i <= size() -1; i++){
          if(item == theList[i])
             return i;
       }
       return  -1;
   }

   //删
   public T remove(int idx){
      if(idx < 0 || idx > size() -1 )
         return null;
      T itemToBeRemoved = theList[idx];
      for ( int i = idx; i < size() -1; i++){
         theList[i] = theList[i+1];
      }
      return  itemToBeRemoved;
   }

   // 固定容量，改为数组
   public T[] timeToSize(){
      var arr = (T[]) new Object[size()];
      for(int i = 0; i < size(); i++){
         arr[i] = theList[i];
      }
      return arr;
   }

   //迭代器
   public java.util.Iterator<T> iterator(){
      return new ArrayListIterator();
   }

   class  ArrayListIterator implements java.util.Iterator<T>{
      int current;

      public ArrayListIterator(){
         current = 0;
      }

      @Override
      public boolean hasNext() {
         return size() > current;
      }

      @Override
      public T next() {
         return  theList[current++];
      }

      @Override
      public void remove() {
         MyArrayList.this.remove( --current);
      }
   }
}
