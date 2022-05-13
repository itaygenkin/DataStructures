public class Heap {
    // ---------------------- fields ----------------------
    private int[] array;
    private int size;

    // ---------------------- constructors ----------------------
    public Heap (int[] array){
        this.size = array.length;
        int n = findFirst2Power(array.length);
        int[] heapArray = new int[n];
        System.arraycopy(array, 0, heapArray, 0, array.length); //
        this.array = heapArray;
        buildMaxHeap();
    }

    // ---------------------- Methods ----------------------
    private int findFirst2Power (int n){
        int ans = 4;
        while ( ans < n )
            ans *= 2;
        return ans;
    }

    private void buildMaxHeap(){
        int s = (size / 2) - 1;
        for (int i = s; i >= 0; i-- )
            maxHeapify(i);
    }

    public void maxHeapify (int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if ( l <= this.size && array[l] > array[largest] )
            largest = l;
        if ( r <= this.size && array[r] > array[largest] )
            largest = r;
        if ( largest != i ) {
            swap(array, i, largest);
            maxHeapify(largest);
        }
    }

    public int parent (int i){
        return (i-1) / 2;
    }

    public int left (int i){
        return 2 * i + 1;
    }

    public int right (int i){
        return 2 * i + 2;
    }

    private void swap (int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int maximum(){
        return array[0];
    }

    public int extractMax(){
        if ( size == 0 )
            throw new IllegalArgumentException("heap underflow");
        int max = array[0];
        array[0] = array[size-1];
        size = size - 1;
        maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int key){
        if ( key < array[i] )
            return;
//            throw new IllegalArgumentException("new key is smaller than current key");
        array[i] = key;
        while ( i > 0 && array[parent(i)] < array[i] ){
            swap(array, i, parent(i));
            i = parent(i);
        }
    }

    public void insert (int key){
        if ( size == array.length )
            throw new IllegalArgumentException("heap overflow");
        array[size] = Integer.MIN_VALUE;
        size = size + 1;
        increaseKey(size-1, key);
    }

    public void printHeap(){
        System.out.print("<" + array[0] + ", ");
        for (int i = 1; i < size - 1; i++ )
            System.out.print(array[i] + ", ");
        System.out.println(array[size] + ">");
    }
}
