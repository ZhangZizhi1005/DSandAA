package algorithms.Sorting.shell;

class shell{
    /**
     * The core of shell sort is to choose gap.
     * Generally, we ues the half failure of length.
     * For every specific gap, we do sort works, we can ues insertion sort to simplify coding.
     * We can regard insertion sort as a shell sort of 1 step gap.
     * So just substituting all 1 by gap is done.
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] a){
        int j;
        for(int gap = a.length/2; gap > 0; gap/=2){
            for( int i = gap; i < a.length; i++){
                T tmp = a[i];
                for( j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap){
                    a[j] = a [j - gap];
                }
                a[j] = tmp;
            }
        }
    }
}