package Graph.ShortestPathDAG;

import java.util.List;
import java.util.Stack;

/**
 * Created by km on 5/28/18.
 */
public class ShortestPath {

    public void ShortestPath(List<Vertex> vertexList, Vertex start, Vertex end){

        start.setDistance(0);

        TopologicalSort sort = new TopologicalSort();
        sort.Sort(vertexList);
        Stack<Vertex> s = sort.getTopoOrder();

        for( Vertex current: s){
            for(Edge e: current.getEdgeList()){

                Vertex edgeEnd = e.getEnd();
                int newDistance = current.getDistance()+e.getWeight();

                if( newDistance < edgeEnd.getDistance()){
                    edgeEnd.setDistance(newDistance);
                    edgeEnd.setPredecessor(current);
                }
            }
        }

        if(end.getDistance() == Integer.MAX_VALUE){
            System.out.println("No shortest distance found");
        }else{
            System.out.println("Shortest distance --> " + end.getDistance());
        }

    }
}
