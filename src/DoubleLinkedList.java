public class DoubleLinkedList<T>{
    // ---------------------- fields ----------------------
    private Link<T> first;
    private Link<T> last;
    private int size;

    // ---------------------- constructors ----------------------
    public DoubleLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public DoubleLinkedList(Link<T> link){
        this.first = link;
        this.last = link;
        this.size = 1;
    }

    // ---------------------- Methods ----------------------
    public int getSize(){
        return size;
    }

    public Link<T> getFirst(){
        return first;
    }

    public Link<T> getLast(){
        return last;
    }

    public void addFirst (T element){
        if ( element == null )
            throw new IllegalArgumentException("input argument in null");
        first = new Link<T>(element, first, null);
        size = size + 1;
    }

    //Todo: complete the methods









}
