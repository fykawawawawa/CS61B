public class LinkedListDeque<T> {
    public class StuffNode {
        public StuffNode next;
        public StuffNode prev;
        public T item;
        public StuffNode(T x, StuffNode n, StuffNode p){
            item = x;
            next = n;
            prev = p;
        }
        public T getRecursiveHelper(int remain){
            if (remain == 0)
                return this.item;
            else
                return this.next.getRecursiveHelper(remain-1);
        }
    }
    private int size;
    private StuffNode sentinel;
    public LinkedListDeque(){
        sentinel = new StuffNode(null, sentinel, sentinel);
        size = 0;
    }
    public void addFirst(T x){
        size += 1;
        StuffNode node = new StuffNode(x, sentinel.next, sentinel);
        sentinel.next.prev = node;
        sentinel.next = node;
    }
    public void addLast(T x){
        size += 1;
        StuffNode node = new StuffNode(x, sentinel, sentinel.prev);
        sentinel.prev.next = node;
        sentinel.prev = node;
    }
    public boolean isEmpty(){
        if (size == 0)
            return true;
        else
            return false;
    }
    public int getSize(){
        return size;
    }
    public void printDeque(){
        StuffNode p = sentinel;
        int i = 0;
        while(i<size){
            System.out.println(p.item);
            System.out.println(' ');
            i += 1;
            p = p.next;
        }
    }
    public T removeFirst(){
        if (size == 0)
            return null;
        else {
            size -= 1;
            StuffNode p = sentinel.next;
            p.next.prev = sentinel;
            sentinel.next = p.next;
            p.next = null;
            p.prev = null;
            return p.item;
        }
    }
    public T removeLast(){
        if (size == 0)
            return null;
        else{
            size -= 1;
            StuffNode p = sentinel.prev;
            p.prev.next = sentinel;
            sentinel.prev = p.prev;
            p.next = null;
            p.prev = null;
            return p.item;
        }
    }
    public T get(int index){
        if (index >= size)
            return null;
        else{
            StuffNode p = sentinel.next;
            int i=0;
            while (i < index){
                p = p.next;
                i += 1;
            }
            return p.item;
        }
    }
    public T getRecursive(int index){
        if (index >= size)
            return null;
        else{
            return sentinel.next.getRecursiveHelper(index);
        }
    }

}
