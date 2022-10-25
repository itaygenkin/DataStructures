public class SmartArray {

    private final int[] A;
    private final int[] B;
    private final int[] C;
    private int TIME;
    private int INIT_VAL = 0;

    public SmartArray(int n, int init_val){
        this.A = new int[n];
        this.B = new int[n];
        this.C = new int[n];
        this.TIME = 0;
        this.INIT_VAL = init_val;
    }

    public void Init(int val){
        this.INIT_VAL = val;
        this.TIME = 0;
    }

    public void write(int index, int val){
        if (notDefined(index)){
            this.B[index] = TIME;
            this.C[TIME] = index;
            this.TIME ++;
        }
        this.A[index] = val;
    }

    public int read(int index){
        return (notDefined(index)) ? this.INIT_VAL : A[index];
    }

    private boolean notDefined(int i) {
        return !(0 <= B[i] && B[i] < TIME && C[B[i]] == i);
    }
}
