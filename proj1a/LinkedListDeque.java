public class LinkedListDeque<T> {
    //循环sentinel
    private class Node {
        private  Node pre;
        private  T val;
        private  Node next;
        private  Node(LinkedListDeque<T>.Node pre, T val, LinkedListDeque<T>.Node next){
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node(null,(T) new Object(), null);
        // new Object() 是创建一个匿名变量，例如可以
        //var a = new Object(2);
        //就是将a定义为2，把2换成 's'就是把a定义为字符 's'
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;
    }
    public void addLast(T item) {
        Node newNode = new Node(sentinel, item, null);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque(){
        Node i = sentinel.next;
        while(i.next != sentinel){
            System.out.print(i.val + " ");
        }
        System.out.print(i.val);
    }
    public T removerFirst(T item){
        if (sentinel.next != sentinel){
            T val = sentinel.next.val;
            sentinel.next =sentinel.next.next;
            return val;
        }
        return null;
    }
    public T removerLast(){
        if (sentinel.pre != sentinel){
            T val = sentinel.pre.val;
            sentinel.pre =sentinel.pre.pre;
            return val;
        }
        return null;
    }
    public T get(int index){
        int num = 0;
        Node tmp = sentinel.next;
        while(num != index){
            tmp = tmp.next;
            if (tmp == sentinel) {
                return null;
            }
            num++;
        }
        return tmp.val;
    }
    public T getRecursive(int index){
        if(size < index){
            return null;
        }
        return getRecHelp(sentinel.next, index);
    }
    public T getRecHelp(LinkedListDeque<T>.Node node, int index){
        if (index == 0){
            return node.val;
        }
        return getRecHelp(node.next, index - 1);
    }
}
