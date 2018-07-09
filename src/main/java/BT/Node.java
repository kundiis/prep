package BT;

/**
 * Created by km on 6/11/18.
 */
public class Node implements Comparable<Node> {
    private Integer id;
    private Node left;
    private Node right;

    public Node(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return id.compareTo(o.getId());
    }

}
