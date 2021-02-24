





# MyArrayList #



---



## Train of thought ##

​		We can consider  it in two aspects:

### Needs ###

1. Dynamic extension when capacity is not enough;
2. Constant time when randomly read an element;
3. Linear time when add, remove or modify an item at given index;

### How  meet these needs ###

1. Create an array with default capacity;

2. When adding items, check if the capacity is enough. If not, double current capacity and move current array into a new array created with the new capacity.

3. If we want to remove an item, using the for loop may leads to the ExceptionOutOfArrayBounds, because after an item was removed, the length of an array minus by one. 

    If we Just copy the rest items into a new array whose length is one less than the original array, extra space cost is needed

    So we use Iterator. That means, we must implement the Iterable interface.

4. Wether we should extend this class from Collections class? **To do**

### Fields ###

1. private int defaultCapacity;
2. 

