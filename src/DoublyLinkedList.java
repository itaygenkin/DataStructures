import java.util.ArrayList;

public class DoublyLinkedList<Integer> extends DoubleLinkedList<Integer> {

    // ------------------ Fields ---------------
    private SLink<Integer> leftSentinel;
    private SLink<Integer> rightSentinel;
    private int size;
    private int h;

    // --------------- Constructor -------------
    public DoublyLinkedList(){
        this.leftSentinel = new SLink<>(null);
        this.rightSentinel = new SLink<>(null);
        leftSentinel.setNext(rightSentinel);
        rightSentinel.setPrev(leftSentinel);
        this.size = 0;
        this.h = 0;
    }

    // --------------- Methods -----------------


}
