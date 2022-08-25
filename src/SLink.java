import java.util.ArrayList;

public class SLink<Integer> extends Link<Integer>{

    // ------------------ Fields ---------------
    private Integer data;
    private Link<Integer> next;
    private Link<Integer> prev;
    protected Link<Integer> upper;
    protected Link<Integer> lower;
    protected ArrayList<Link<Integer>> height;

    // --------------- Constructor -------------
    public SLink(Integer data){
        super(data);
        this.upper = null;
        this.lower = null;
        this.height = new ArrayList<Link<Integer>>();
    }

    // --------------- Methods -----------------

}
