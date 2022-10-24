public class LinkList<T> {

    //---------------Fields-------------------
    private Link<T> first = null;
    private int size = 0;

    //------------Constructor-----------------
    public LinkList (Link<T> link){
        this.first = link;
        size = 1;
    }

    //-------------Methods--------------------
    public int getSize(){
        return size;
    }

    public Link<T> getFirst(){
        return first;
    }

    public void addFirst(Link<T> link){
        link.setNext(this.first);
        this.first = link;
        size ++;
    }

    public void addLast(Link<T> link){
        if (size == 0){
            this.first = link;
            size ++;
            return;
        }
        Link<T> curr = this.first;
        while (curr.getNext() != null)
            curr = curr.getNext();
        curr.setNext(link);
        size ++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Link<T> curr = this.first;
        while (curr != null){
            sb.append(curr.toString()).append(", ");
            curr = curr.getNext();
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString() + ">";
    }

    public void printList(){
        System.out.println(this.toString());
    }

    public void reverseList(){
        Link<T> prevNode = this.first;
        Link<T> currNode = prevNode.getNext();
        Link<T> nextNode = currNode.getNext();

        prevNode.setNext(null);
        while (nextNode != null){
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.getNext();
        }
        currNode.setNext(prevNode);
        this.first = currNode;
    }

    public boolean contains(T element){
        Link<T> curr = first;
        while (curr != null){
            if (curr.getData().equals(element))
                return true;
            curr = curr.getNext();
        }
        return false;
    }

    // TODO: add remove methods
}
