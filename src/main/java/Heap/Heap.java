package Heap;

/**
 * Created by km on 5/17/18.
 */
public class Heap {

    private Integer[] heap;
    private int currentPosition = -1;

    public Heap(int size){
        this.heap = new Integer[size];
    }

    public void insert(int item){

        this.heap[++currentPosition] = item;
        fixUp(currentPosition);

    }

    // max - heap
    // move up the element by using (loc - 1)/2
    private void fixUp(int index) {
        int parent = (index - 1)/2;

        while( parent >=0 && heap[parent] < heap[index]){
            // swap
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;

            index = parent;
            parent = (index - 1)/2;
        }
    }

}
