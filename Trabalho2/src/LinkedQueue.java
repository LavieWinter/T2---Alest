public class LinkedQueue<T> implements Queue<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T>{
        private T obj;
        private Node<T> next;

        public Node(T obj) {
            this.obj = obj;
            this.next = null;
        }
    }

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T obj) {
        Node<T> aux = new Node<>(obj);
        if(size == 0){
            head = aux;
            tail = aux;
        }
        else {
            tail.next = aux;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception{        
        if(size == 0){
            throw new Exception("Queue Empty");
        }
        Node<T> aux = head;
        head = head.next;
        aux.next = null;
        size--;
        return aux.obj;
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