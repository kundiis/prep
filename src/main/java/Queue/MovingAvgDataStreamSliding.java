package Queue;


import java.util.LinkedList;
import java.util.Queue;

public class MovingAvgDataStreamSliding {

    Queue<Integer> q = new LinkedList<>();
    int size = 10;
    int sum = 0;
    public void movingAverage(int data){

        if(q.size() < size){
            sum = sum + data;
        }else{
            int previous = q.poll();
            sum = sum - previous;
            sum = sum + data;
        }
        q.add(data);
        System.out.println("avg =="+ sum/q.size());
    }

}
