package algorithms.Sorting.insertion;

class insertion {
    /**
     * Insertion Sort
     * @param a Array to be sorted
     * @param <T> Type parameter
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a){
        int j;
        for(int i = 1; i <= a.length - 1; i ++){
            T tmp = a[i];
            for( j = i; j>0 && tmp.compareTo(a[j-1]) < 0 ; j --){
                a[j] = a [j-1];
            }
            a[j] = tmp;
        }
    }
}