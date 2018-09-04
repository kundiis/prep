package Graph.Dijkstra;

import java.util.PriorityQueue;

/**
 * Created by km on 5/28/18.
 */
public class Dijkstra {

    // O(V * LogV + E)

    public void algo(Vertex source){

        source.setDistance(0);
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        Q.add(source);

        while( ! Q.isEmpty() ){
             Vertex current = Q.poll();

             for( Edge edge: current.getEdgeList()){

                 Vertex v = edge.getEnd();
                 int newDistance = edge.getWeight() + source.getDistance();

                 if(  newDistance < v.getDistance()){
                    Q.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(current);
                    Q.add(v);
                 }
             }
        }
    }
}
