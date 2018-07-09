package StackWithArray;

/**
 * Created by km on 5/14/18.
 */
public class Stack<T> {
    private T[] data = ( T[] ) new Object[1];
    private int count = 0;

    public void push(T data){

        if(this.data.length == count){
            resize(2 * this.data.length);
        }
        this.data[count] = data;
        count++;
    }

    private void resize(int capacity) {
        T[] newStack = ( T[] ) new Object[capacity];

        for(int i = 0; i< this.data.length; i++){
            newStack[i] = data[i];
        }

        this.data = newStack;
    }

    public int size(){
        return count ==0?0:count-1;
    }

    public T pop(){

        if(count == 0) return null;

        T temp = data[count-1];
        data[count-1] = null;
        count --;
        return temp;
    }

}
