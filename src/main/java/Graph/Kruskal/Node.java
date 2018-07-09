package Graph.Kruskal;

/**
 * Created by km on 5/29/18.
 */
public class Node {
    private int id;
    private int rank;
    private Node root;

    public Node(int id, int rank, Node root) {
        this.id = id;
        this.rank = rank;
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
