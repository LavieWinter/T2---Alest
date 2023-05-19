public interface Queue<T> {
    void enqueue(T obj) throws Exception;
    T dequeue() throws Exception;
    T get(int pos) throws Exception;
    int size();
    boolean isEmpty();
}