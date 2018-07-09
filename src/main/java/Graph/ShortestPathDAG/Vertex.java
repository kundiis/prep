package Graph.ShortestPathDAG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by km on 5/28/18.
 */
public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> edgeList;
    private boolean visited;
    private Vertex predecessor;
    private int distance = Integer.MAX_VALUE;

    public Vertex(String name, List<Edge> edgeList) {
        this.name = name;
        this.edgeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(distance, o.getDistance());
    }
}
