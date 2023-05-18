public class ArrayQueue<T> implements Queue<T> {
    private Object[] array;
    private int start;
    private int end;
    private int size;

    public ArrayQueue(int length) {
        this.array = new Object[length];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T obj) throws Exception {
        if(((end+1) % array.length) == start){
            throw new Exception("Queue Full");
        }
        if(size != 0){
            end = (end+1) % array.length;
            array[end] = obj;
        }
        else {
            array[end] = obj;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0){
            throw new Exception("Queue Empty");
        }
        Object obj = array[start];
        start = (start+1) % array.length;
        size--;
        return (T)obj;
    }

    public T get(int i) {
        int now = (start + i) % array.length;
        return (T)array[now];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}