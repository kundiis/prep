package Graph.Prims;

/**
 * Created by km on 5/30/18.
 */
public class Edge implements Comparable<Edge> {
    private int weight;
    private Vertex start;
    private Vertex end;

    public Edge(int weight, Vertex start, Vertex end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

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

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.getWeight());
    }
}
