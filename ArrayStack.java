import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>{
    int top;
    T[] array;

    public ArrayStack(){
        this.top = -1;
        this.array = (T[]) Array.newInstance(Object.class, 10);
    }

    /**
     * The function push is adding an item to the last element of the stack.
     * Checks if there is enough space in the array by comparing if the top is equal
     * to the last position of the array. If it is, double the size of the array.
     *
     * @param item is getting added to the end of the stack.
     * */
    @Override
    public void push(T item) {
        if(top == array.length - 1){
            double_array();
        }

        array[++top] = item;

    }

    /**
     * The function pop returns and deletes the last element from the stack.
     * */
    @Override
    public T pop() throws Exception {
        return array[top--];
    }

    /**
     * The function peek looks at the last element of the stack.
     * */
    @Override
    public T peek() throws Exception {
        return array[top];
    }

    /**
     * The function empty checks if the stack is empty.
     * */
    @Override
    public boolean empty() {
        if(top == -1){ //Checks if there are no elements in the array
            return true;
        }
        return false;
    }

    /**
     * This function doubles the size of the array.
     * */
    private void double_array(){
        this.array = Arrays.copyOfRange(this.array, 0, array.length * 2);
    }
}


