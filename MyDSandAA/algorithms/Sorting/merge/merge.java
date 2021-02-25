package algorithms.Sorting.merge;

class merge{
    /**
     * Mergesort algorithms
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] a){
        T[] tmp = (T[]) new Comparable[a.length];
        mergeSort(a,tmp,0,a.length-1);
    }

    /**
     * Internal method that makes recursive calls
     * @param a an array of Comparable items
     * @param tmpArray an array to place the merged result
     * @param left the left most index of the subarray
     * @param right the right most index of the subarray
     * @param <T> type parameter
     */
    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmpArray, int left, int right){
        if (left < right){
            int center = (left + right)/2;
            mergeSort(a,tmpArray,left,center);
            mergeSort(a,tmpArray,left,center);
            merge(a,tmpArray,left,center+1,right);
        }

    }

    /**
     * Internal method that merges two sorted halves of a subarray
     * @param a an array of Comparable items
     * @param tmpArray an array to place the merge result
     * @param leftPos the most left index of the subarray
     * @param rightPos the index of the start of the second half
     * @param rightEnd the most right index of the array
     * @param <T> type parameter
     */
    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos -1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if(a[leftPos].compareTo(a[rightPos]) <= 0){
                tmpArray[tmpPos] = tmpArray[leftPos];
                tmpPos++;
                leftPos++;
            }
            else{
                tmpArray[tmpPos] = tmpArray[rightPos];
                tmpPos++;
                rightPos++;
            }
        }
        // copy the rest of the first half
        while (leftPos <= leftEnd){
            tmpArray[tmpPos] = tmpArray[leftPos];
            tmpPos++;
            leftPos++;
        }
        // copy the rest of the second half
        while (rightPos <= rightEnd){
            tmpArray[tmpPos] = tmpArray[rightPos];
            tmpPos++;
            rightPos++;
        }

        // copy tmpArray back
        for(int i = 0; i <= numElements - 1; i++,rightEnd--){
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}