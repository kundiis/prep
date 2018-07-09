package Graph.Prims;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by km on 5/30/18.
 */
public class Vertex {

    private String name;
    private boolean isVisited = false;
    private Vertex predecessor;
    private List<Edge> edgeList;

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

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}
