package Graph;

import java.util.Stack;

/**
 * Created by km on 5/27/18.
 */
public class DFS {

    public void DFSRecursion(Vertex v){
        // recursion
        v.setVisited(true);
        System.out.println(v.getData());

        for(Vertex neighbour: v.getNeighbours()){
            if(! neighbour.isVisited())  {
                DFSRecursion(neighbour);
            }
        }
    }

    public void DFSIterative(Vertex v){

        Stack<Vertex> s = new Stack();
        System.out.println(v.getData());
        v.setVisited(true);
        s.push(v);

        while(!s.isEmpty()){
            Vertex element = s.pop();
            for(Vertex neighbour: element.getNeighbours()){
                if(! neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    s.push(neighbour);
                }
            }
        }
    }
}
