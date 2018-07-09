package Graph.ShortestPathDAG;

/**
 * Created by km on 5/28/18.
 */
public class Edge {
    private int weight;
    private Vertex start;
    private Vertex end;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }
}
