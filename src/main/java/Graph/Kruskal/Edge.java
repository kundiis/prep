package Graph.Kruskal;

/**
 * Created by km on 5/29/18.
 */
public class Edge implements Comparable<Edge>{
    private int weight;
    private Vertex startEdge;
    private Vertex endEdge;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getStartEdge() {
        return startEdge;
    }

    public void setStartEdge(Vertex startEdge) {
        this.startEdge = startEdge;
    }

    public Vertex getEndEdge() {
        return endEdge;
    }

    public void setEndEdge(Vertex endEdge) {
        this.endEdge = endEdge;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.getWeight());
    }
}
