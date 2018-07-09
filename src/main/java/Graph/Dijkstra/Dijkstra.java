package Graph.Dijkstra;

import java.util.PriorityQueue;

/**
 * Created by km on 5/28/18.
 */
public class Dijkstra {

    public void algo(Vertex source){

        source.setDistance(0);
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        Q.add(source);

        while( ! Q.isEmpty() ){
             Vertex current = Q.poll();

             for( Edge edge: current.getEdgeList()){

                 Vertex target = edge.getEnd();
                 int newDistance = edge.getWeight() + source.getDistance();

                 if(  newDistance < target.getDistance()){
                    Q.remove(target);
                    target.setDistance(newDistance);
                    target.setPredecessor(current);
                    Q.add(target);
                 }
             }
        }
    }
}
