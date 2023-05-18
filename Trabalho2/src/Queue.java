public interface Queue<T> {
    void enqueue(T obj) throws Exception;
    T dequeue() throws Exception;
    int size();
    boolean isEmpty();
}