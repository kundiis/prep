package Graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by km on 5/23/18.
 */
public class BFS {

    public void BFS(Vertex root){

        Queue<Vertex> q = new LinkedList<>();
        q.add(root);
        root.setVisited(true);

        while(! q.isEmpty()){

            Vertex n = q.remove();
            for(Vertex neighbors: n.getNeighbours()){
                if(!neighbors.isVisited()) {
                    neighbors.setVisited(true);
                    q.add(neighbors);
                }
            }
        }

    }
}
