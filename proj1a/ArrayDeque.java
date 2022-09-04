public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque(){
        size = 0;
        items = (T[])new Object[8];
        int i=0;
        while(i<8){
            items[i]=null;
            i++;
        }
        nextFirst = 0;
        nextLast = 1;
    }
    public void addFirst(T x){
        items[nextFirst] = x;
        if(nextFirst != 0)
            nextFirst -= 1;
        else
            nextFirst = 7;
        size += 1;
    }
    public void addLast(T x){
        items[nextLast] = x;
        if(nextLast != 7)
            nextLast += 1;
        else{
            nextLast = 0;
        }
        size += 1;
    }
    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int iter;
        if(nextFirst == 7)
            iter=0;
        else
            iter=nextFirst+1;
        int count=0;
        while(count<size){
            System.out.println(items[iter]);
            System.out.println(' ');
            count++;
            if(iter==7)
                iter=0;
            else
                iter+=1;
        }

    }
    public T removeFirst(){
        if(size == 0)
            return null;
        T item;
        size-=1;
        if(nextFirst == 7)
            nextFirst=0;
        else
            nextFirst+=1;
        item=items[nextFirst];
        items[nextFirst]=null;
        return item;

    }
    public T removeLast(){
        if(size == 0)
            return null;
        T item;
        size -= 1;
        if(nextLast == 0)
            nextLast = 7;
        else
            nextLast -= 1;
        item=items[nextLast];
        items[nextLast]=null;
        return item;

    }
    public T get(int index){
        return items[index];
    }
}

