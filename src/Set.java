public interface Set<T> extends Iterable<T> {

    public int size();

    public boolean add(T element);

    public boolean contains(T element);

    public boolean remove(T element);

    public boolean isEmpty();

}
