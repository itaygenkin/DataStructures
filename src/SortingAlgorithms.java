public class SortingAlgorithms {

    public static void main (String[] args){
        int[] array = {16, 17, 18, 20, 11, 10, 21, 13, 25, 19};
        for (int i = 0; i < array.length; i++)
            System.out.print(partition(array, 0, i) + " ");

    }

    public static void printArray (int[] array){
        System.out.print("<");
        for (int i = 0; i < array.length - 1; i++ )
            System.out.print(array[i] + ", ");
        System.out.println(array[array.length - 1] + ">");
    }

    public static void bubbleSort (int[] array){ // O(n^2)
        for (int i = 0; i < array.length - 1; i++ ){
            for (int j = i + 1; j < array.length; j++ ){
                if ( array[i] > array[j] ){
                    swap(array, i, j);
                }
            }
        }
    }

    public static void swap (int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void insertionSort (int[] array){ // O(n^2)
        for (int j = 1; j < array.length; j++ ){
            int key = array[j];
            int i = j - 1;
            while ( i >= 0 && array[i] > key ){
                array[i+1] = array[i];
                i --;
            }
            array[i+1] = key;
        }
    }

    public static void mergeSort (int[] array){ // O(nlog n)
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort (int[] array, int left, int right){
        if ( left < right ){
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge (int[] array, int left, int mid, int right){
        int n = mid - left + 1;
        int m = right - mid;
        int[] leftArray = new int[n+1];
        int[] rightArray = new int[m+1];
        for (int i = 0; i < n; i++ )
            leftArray[i] = array[left + i];
        for (int j = 0; j < m; j++ )
            rightArray[j] = array[mid + j + 1];
        leftArray[n] = Integer.MAX_VALUE;
        rightArray[m] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = left; k <= right; k++ ){
            if ( leftArray[i] <= rightArray[j] ){
                array[k] = leftArray[i];
                i ++;
            }
            else{
                array[k] = rightArray[j];
                j ++;
            }
        }
    }

    public static int[] countingSort (int[] array, int k){
        int[] output = new int[array.length];
        int[] histogram = new int[k+1];
        for (int i = 0; i < array.length; i++ )
            histogram[array[i]] ++;
        for (int i = 1; i <= k; i++ )
            histogram[i] = histogram[i] + histogram[i-1];
        for (int j = array.length - 1; j >= 0; j-- ){
            int temp = histogram[array[j]];
            output[temp - 1] = array[j];
            histogram[array[j]] -- ;
        }
        return output;
    }

    public static void quickSort (int[] array){ // O(nlog n) expected
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort (int[] array, int p, int r){
        if ( p < r ){
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array,q + 1, r);
        }
    }

    public static int partition (int[] array, int p, int r){
        int i = p - 1;
        for (int j = p; j <= r - 1; j++ ){
            if ( array[j] <= array[r] ){
                i ++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    public static void randomizedQuickSort (int[] array){
        randomizedQuickSort(array, 0, array.length - 1);
    }

    public static void randomizedQuickSort (int[] array, int p, int r){
        if ( p < r ){
            int q = randomizedPartition(array, p, r);
            randomizedQuickSort(array, p, q-1);
            randomizedQuickSort(array, q+1, r);
        }
    }

    public static int randomizedPartition (int[] array, int p, int r){
        double random = Math.random();
        int i = (int) random * (p + 1 - r) + p;
        swap(array, i, r);
        return partition(array, p, r);
    }

    public static int minimum (int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++ ){
            if ( array[i] < min )
                min = array[i];
        }
        return min;
    }

    public static int randomizedSelect (int[] array, int p, int r, int i){
        if ( p == r )
            return array[p];
        int q = randomizedPartition(array, p, r);
        int k = q - p + 1;
        if ( i == k )
            return array[q];
        else if ( i < k )
            return randomizedSelect(array, p, q - 1, i);
        else
            return randomizedSelect(array, q + 1, r, i - k);
    }

    public static int select (int[] array, int p, int r, int i){ //can't be run until choosePivot is done
        if ( p == r )
            return array[p];
        int j = choosePivot(array, p, r);
        swap(array, j, r);
        int q = partition(array, p, r);
        int k = q - p + 1;
        if ( i == k )
            return array[q];
        else if ( i < k )
            return select(array, p, q-1, i);
        else
            return select(array, q + 1, r, i - k);
    }

    public static int choosePivot(int[] array, int p, int r){
        //TODO: complete
        int n = r - p + 1;
        if ( n <= 10 )
            return r;

        return -1;
    }

    public static int[] heapSort(int[] array){
        Heap h = new Heap(array); // O(n)
        for (int i = array.length - 1; i >= 0; i--) // O(n)
            array[i] = h.extractMax(); // O(log n)
        return array;
    }

}
