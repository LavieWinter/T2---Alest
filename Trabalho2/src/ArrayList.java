public class ArrayList<T> {
    private Object[] array;
    private int size;

    public ArrayList() {
        this.array = new Object[100];
        this.size = 0;
    }

    public void add(T obj) {
        try {
            array[size] = obj;            
        } catch (Exception e) {
            newArray();
            array[size] = obj;
        } finally {
            size++;
        }
    }

    private void newArray() {
        Object[] aux = new Object[array.length*2];
        for(int i = 0; i < array.length; i++){
            aux[i] = array[i];
        }
        array = aux;
    }

    public T get(int pos) throws Exception {
        if(pos < 0 || pos >= size){
            throw new Exception("Invalid index: "+pos);
        }
        return (T)array[pos];
    }

    public int size() {
        return size;
    }
}