package Graph.Kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by km on 5/29/18.
 */
public class Kruskal {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    private List<Edge> mst = new ArrayList<>();

    public Kruskal(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public void algo(){

        DisjointSet disjointSet = new DisjointSet(vertexList);

        Collections.sort(edgeList);

        for(Edge edge: edgeList){
            Vertex start = edge.getStartEdge();
            Vertex end = edge.getEndEdge();

            if(disjointSet.findSet(start.getNode()) == disjointSet.findSet(end.getNode())){ // both are the in the same set
                continue;
            }

            disjointSet.union(start.getNode(), end.getNode());

            mst.add(edge);
        }
    }
}
