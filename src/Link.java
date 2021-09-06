public class Link<T> {
    // ---------------------- fields ----------------------
    private T data;
    private Link<T> next;
    private Link<T> prev;

    // ---------------------- constructors ----------------------
    public Link (T data, Link<T> next, Link<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Link(T data) {
        this(data, null, null);
    }

    // ---------------------- Methods ----------------------
    public Link<T> getNext(){
        return next;
    }

    public Link<T> getPrev(){
        return prev;
    }

    public T getData(){
        return data;
    }

    public void setNext(Link<T> next){
        this.next = next;
    }

    public void setPrev(Link<T> prev){
        this.prev = prev;
    }

    public void setData(T data){
        this.data = data;
    }

    public String toString(){
        return data.toString();
    }

}
