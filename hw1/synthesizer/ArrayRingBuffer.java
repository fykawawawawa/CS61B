// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first=0;
        last=0;
        fillCount=0;
        this.capacity=capacity;
        rb= (T[])new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last;
        if(fillCount>=capacity){
            throw new RuntimeException("Ring Buffer Overflow");
        }
        else{
            rb[last]=x;
            fillCount++;
            if(last!=capacity-1) {
                last++;
            }
            else{
                last=0;
            }

        }

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        T tmp;
        if(this.isEmpty()){
            throw new RuntimeException("Ring Buffer Underflow");
        }
        else{
            fillCount--;
            tmp=rb[first];
            rb[first]=null;
            if(first!=capacity-1){
                first++;
            }
            else{
                first=0;
            }
        }
        return tmp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];
        // TODO: Return the first item. None of your instance variables should change.
    }



    // TODO: When you get to part 5, implement the needed code to support iteration.

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
    //iterator() method must return an object that implements the Iterator interface.
    private class ArrayRingBufferIterator implements Iterator<T>{
        private int pos;
        private ArrayRingBufferIterator(){
            pos = first;
        }

        @Override
        public boolean hasNext() {
            if(capacity == 0){
                return false;
            }
            else if(pos+1 == last){
                return false;
            }
            else if(pos == capacity-1 && last ==0){
                return false;
            }
            else{
                return true;
            }
        }

        @Override
        public T next() {
            T tmp = rb[pos];
            if(pos == capacity-1){
                pos = 0;
            }
            else{
                pos+=1;
            }
            return tmp;
        }
    }

}
