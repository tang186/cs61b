public class ArrayDeque<T> {
    private T[] vals;
    private int left;
    private int right;
    private int capacity = 8;
    public ArrayDeque() {
        vals = (T[]) new Object[capacity];
        //capacity = 8;
        left = 0;
        right = 0;
    }
    public void addFirst(T item) {
        if (size() == capacity - 1) {
            resize((int) (capacity * 1.2));
        }
        left = (capacity + left - 1) % capacity;
        vals[left] = item;    //对于addFirst和addLast需要一个在当前添加，一个在变换位置后添加，这也可以最大效率利用空间。
    }
    public void addLast(T item) {
        if (size() == capacity - 1) {
            resize((int) (capacity * 1.2));
        }
        vals[right] = item;
        right = (right + 1) % capacity;
    }
    public int size() {
        return (right - left + capacity) % capacity;
    }
    public boolean isEmpty() {
        return right == left;
    }
    public void printDeque() {
        int i = left;
        while (i + 1 != right) {
            System.out.print(vals[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.print(vals[i]);
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T ans = vals[left];
        left = (left + 1) % capacity;
        if (lowRate()) {
            resize((int) (capacity * 0.5));
        }
        return ans;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        right = (right - 1 + capacity) % capacity;
        T ans = vals[right];
        if (lowRate()) {
            resize((int) (capacity * 0.5));
        }
        return ans;
    }
    public T get(int index) {
        if (index < 0 || index >= size() || isEmpty()) {
            return null;
        }
        if (right > left) {
            return vals[left + index];
        } else {
            return vals[(left + index) % capacity];
        }
    }
    private boolean lowRate() {
        if (capacity >= 16 && size() / (double) capacity < 0.25) {
            return true;
        }
        return false;
    }
    private void resize(int newsize) {
        //要按照新的size去重新赋值，如果还是按照原来的大小会出现不连续的值的情况
        T[] newvals = (T[]) new Object[newsize];

        int size = size();
        if (left < right) {
            for (int i = left, j = 0; i < right && j < size; i++, j++) {
                newvals[j] = vals[i];
            }
        } else if (left > right) {
            int j = 0;
            for (int i = left; j < capacity - left; i++, j++) {
                newvals[j] = vals[i];
            }
            for (int i = 0; j < size; i++, j++) {
                newvals[j] = vals[i];
            }
        }
        left = 0;
        right = size;
        capacity = newsize;
        vals = newvals;
    }
}
