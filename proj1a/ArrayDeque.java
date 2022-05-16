public class ArrayDeque<T>{
    private T[] vals;
    private int left;
    private int right;
    private int capacity;
    public ArrayDeque(){
        vals = (T[]) new Object[capacity];
        capacity = 8;
        left = 0;
        right = 0;
    }
    public void addFirst(T item){
        if(size() == capacity){
            resize((int)(capacity * 1.2));
        }
        if(left - 1 < 0) {
            left = left + capacity - 1;
        }
        else left = left - 1;
        vals[left] = item;    //对于addFirst和addLast需要一个在当前添加，一个在变换位置后添加，这也可以最大效率利用空间。
    }
    public void addLast(T item){
        if(size() == capacity){
            resize((int)(capacity * 1.2));
        }
        vals[right] = item;
        if(right + 1 > capacity){
            right = right - capacity + 1;
        }
        else right = right + 1;
    }
    public int size(){
        return (right - left + capacity) % capacity;
    }
    public boolean isEmpty(){
        return right == left;
    }
    public void printDeque(){
        int i = left;
        while(i + 1 != right){
            System.out.print(vals[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.print(vals[i]);
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T ans = vals[left];
        left = (left + 1 + capacity) % capacity;
        if(LowRate()){
            resize((int)(capacity * 0.5));
        }
        return ans;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        right = (right - 1 + capacity) % capacity;
        T ans = vals[right];
        if(LowRate()){
            resize((int)(capacity * 0.5));
        }
        return ans;
    }
    public T get(int index){
        if(index < 0 || index > size() || isEmpty()){
            return null;
        }
        if(right > left){
            return vals[left + index];
        }
        else return vals[(left + index + capacity) % capacity];
    }
    public boolean LowRate(){
        if (capacity >= 16 && size() / (double)capacity < 0.25){
            return true;
        }
        return false;
    }
    public void resize(int newsize){
        T[] newvals = (T[]) new Object[newsize];

        int begin = left;
        int end = right;
        while(begin != end){
            newvals[begin] = vals[begin];
            begin = (begin + 1 + capacity) % capacity;
        }
        capacity = newsize;
        vals = newvals;
    }
}