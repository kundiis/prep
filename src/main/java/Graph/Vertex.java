package Graph;

import java.util.List;

/**
 * Created by km on 5/23/18.
 */
public class Vertex implements Comparable{

    private Integer data;
    private boolean isVisited;
    private boolean isBeingVisited;
    private List<Vertex> neighbours;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isBeingVisited() {
        return isBeingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        isBeingVisited = beingVisited;
    }

    @Override
    public int compareTo(Object o) {
        return this.data.compareTo(((Vertex) o).getData());
    }
}
