package Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStreamIntegers {

    PriorityQueue<Integer> maxHeap; //lower half
    PriorityQueue<Integer> minHeap; //higher half

    public MedianOfDataStreamIntegers(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {

        /* we don't know whether the number is smaller or bigger */
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }

}
