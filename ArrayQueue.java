import java.lang.reflect.Array;

public class ArrayQueue<T> implements Queue<T> {
    int head;
    int tail;
    T[] array;
    int size;

    //Constructors
    public ArrayQueue(){
        this.head = 0;
        this.tail = 0;
        this.array = (T[]) Array.newInstance(Object.class, 10);
        this.size = 0;
    }

    /**
     * The function dequeue deletes the element in the front, which is the element
     * that was put in first. When deleting the element from the queue, must decrease
     * the size of the array also.
     * */
    @Override
    public T dequeue() throws Exception {
        size--; //decreasing the size of the array because we are removing from the queue.
        T remove = array[head];
        head = (head + 1) % array.length; //moves the head to the next element of the array
        return remove;
    }

    /**
     * The function enqueue adds the element to the array. When adding the element to the queue,
     * we must increase the size.
     *
     * @param item is getting added to the queue
     * */
    @Override
    public void enqueue(T item) {
        if((head + 1) % array.length == tail){ //Checks if the head and tail are pointing to the same element
            double_array();
        }

        size++;
        array[tail] = item;
        tail = (tail + 1) % array.length; //moves the tail to the next element in the queue
    }

    /**
     * The function empty checks if the array is empty.
     * */
    @Override
    public boolean empty() {
        return size==0;
    }

    /**
     * This function doubles the size of the array.
     * */
    private void double_array(){
        T[] temp_arr = (T[]) Array.newInstance(Object.class, array.length * 2);

        int i = 0;
        int j = 0;

        /*moves the elements from the previous array to the newly, doubled one. It also sets head to
        the front of the array and then iterates through the rest.*/
        for(i = head, j =  0; j < size; i++, j++){
            temp_arr[j] = this.array[i % array.length];
        }

        head = 0; //resetting
        tail = size; //resetting

        this.array = temp_arr;
    }
}