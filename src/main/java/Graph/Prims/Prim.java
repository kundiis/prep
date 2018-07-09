package Graph.Prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by km on 5/30/18.
 */
public class Prim {

    // lazy implementation
    private List<Edge> mst = new ArrayList<>();
    private PriorityQueue<Edge> pq = new PriorityQueue<>();
    private List<Vertex> unVisitedList;

    public Prim() {

    }

    public void algo(List<Vertex> vertexList){
        unVisitedList = vertexList;
        Vertex start = unVisitedList.get(0);

        while(! unVisitedList.isEmpty()) {

            start.setVisited(true);

            for (Edge e : start.getEdgeList()) {
                Vertex end = e.getEnd();

                if (!end.isVisited()) {
                    pq.add(e);
                    end.setVisited(true);
                }

            }

            Edge minEdge = pq.remove();
            mst.add(minEdge);
            unVisitedList.remove(start);

        }
    }
}
