import java.util.Collection;
import java.util.Iterator;

public class DoubleLinkedList<T>{
    // ---------------------- fields -----------------------
    private Link<T> first = null;
    private Link<T> last = null;
    private int size = 0;

    // ------------------- constructors --------------------
    public DoubleLinkedList(){}

    public DoubleLinkedList(Link<T> link){
        this.first = link;
        this.last = link;
        this.size += 1;
    }

    public DoubleLinkedList(Collection<T> c){
        Iterator<T> itr = c.iterator();
        while (itr.hasNext())
            this.addLast(itr.next());
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

    public void addFirst (T element) {
//        if ( element == null )
//            throw new IllegalArgumentException("Input argument is null");
        Link<T> newFirst = new Link<T>(element, first, null);
        if (size == 0)
            this.last = newFirst;
        else
            first.setPrev(newFirst);
        this.first = newFirst;
        size ++;
    }

    public void addLast (T element){
//        if ( element == null )
//            throw new IllegalArgumentException("Input argument is null");
        Link<T> newLast = new Link<T>(element, null, last);
        if (size == 0)
            this.first = newLast;
        else
            last.setNext(newLast);
        this.last = newLast;
        size ++;
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

    public boolean remove (T toRemove){
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
        size --;
        return removed;
    }

    public String toString(){
        StringBuilder output = new StringBuilder("<");
        Link<T> curr = first;
        while (curr != null){
            output.append(curr.toString()).append(", ");
            curr = curr.getNext();
        }
        output.delete(output.length()-2, output.length());
        return output + ">";
    }

    public Object[] toArray(){
        Object[] output = new Object[size];
        int index = 0;
        for (Link<T> l = first; l != null; l = l.getNext(), index ++)
            output[index] = l.getData();
        return output;
    }

    public void printList(){
        System.out.println(this.toString());
    }
}
