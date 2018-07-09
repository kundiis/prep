package Graph;

import java.util.Stack;

/**
 * Created by km on 5/27/18.
 */

// should be a DAG

public class TopologicalOrder {

    Stack<Vertex> s = new Stack<>();

    public void DFSRecursion(Vertex v){
        // recursion
        v.setVisited(true);
        System.out.println(v.getData());

        for(Vertex neighbour: v.getNeighbours()){
            if(! neighbour.isVisited())  {
                DFSRecursion(neighbour);
            }
        }

        s.push(v);
    }

}
