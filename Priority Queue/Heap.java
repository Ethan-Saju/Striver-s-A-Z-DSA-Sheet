import java.util.List;

public interface Heap<T> {
    void add(T val);
    T poll();
    int size();
    T peek();
    void heapify(List<T> list);
    boolean isEmpty();
    void clear();
    String toString();
}
