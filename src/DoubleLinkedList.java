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

    public Link<T> get(int index){
        if ( index > size || index <= 0 )
            throw new ArrayIndexOutOfBoundsException("index out of bounds");
        Link<T> output = first;
        while ( index > 1 ){
            output = output.getNext();
            index -= 1;
        }
        return output;
    }

    public void addFirst (T element){
        if ( element == null )
            throw new IllegalArgumentException("input argument is null");
        Link<T> newFirst = new Link<T>(element, first, null);
        first.setPrev(newFirst);
        this.first = newFirst;
        size = size + 1;
    }

    public void addLast (T element){
        if ( element == null )
            throw new IllegalArgumentException("input argument is null");
        Link<T> newLast = new Link<T>(element, null, last);
        last.setNext(newLast);
        this.last = newLast;
        size = size + 1;
    }

    public void removeFirst(){
        first = first.getNext();
        first.setPrev(null);
    }

    public void removeLast(){
        last = last.getPrev();
        last.setNext(null);
    }

    public boolean contains(Object element){
        boolean output = false;
        for (Link<T> curr = first; curr != null && !output; curr = curr.getNext())
            output = element.equals(curr.getData());
        return output;
    }

    public boolean removed (Object toRemove){
        Link<T> current = first;
        boolean removed = false;
        while ( current != null && !removed ){
            if ( current.getData().equals(toRemove) ){
                // if the first link should be removed
                if ( current == first )
                    first = first.getNext();
                else{
                    Link<T> newNext = current.getNext();
                    current.getPrev().setNext(newNext);
                    newNext.setPrev(current.getPrev());
                }
                removed = true;
            }
            else
                current = current.getNext();
        }
        size = size - 1;
        return removed;
    }

    public String toString(){
        String output = "<";
        Link<T> current = first;
        while ( current != null && current != last ){
            output = output + current.toString() + ", ";
            current = current.getNext();
        }
        if ( current == last )
            output = output + current.toString();
        return output + ">";
    }

    public Object[] toArray(){
        Object[] output = new Object[size];
        int index = 0;
        for (Link<T> l = first; l != null; l = l.getNext(), index ++)
            output[index] = l.getData();
        return output;
    }

}
