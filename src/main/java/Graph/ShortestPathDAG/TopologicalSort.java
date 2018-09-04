package Graph.ShortestPathDAG;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by km on 5/28/18.
 */
public class TopologicalSort {

    private Stack<Vertex> s = new Stack();

    public void Sort(List<Vertex> vertexList){

        for(Vertex v: vertexList){
            dfs(v);
        }

    }

    private void dfs(Vertex v) {

        for(Edge neighbors: v.getEdgeList()){

            Vertex target = neighbors.getEnd();
            if(!target.isVisited()){
                target.setVisited(true);
                dfs(target);
            }
        }

        s.push(v);
    }

    public Stack<Vertex> getTopoOrder(){
         Collections.reverse(s);
         return s;
    }

}
