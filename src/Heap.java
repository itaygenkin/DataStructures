public class Heap {

    private int[] array;
    private int size;

    public Heap (int[] array){
        this.array = array;
        this.size = array.length - 1;
        buildMaxHeap();
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

    private void buildMaxHeap(){
        int s = (size / 2) - 1;
        for (int i = s; i >= 0; i-- )
            maxHeapify(i);
    }

    public void increaseKey(int i, int key){
        if ( key < array[i] )
            throw new IllegalArgumentException("new key is smaller than current key");
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
