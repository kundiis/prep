package Trie;

/**
 * Created by km on 5/19/18.
 */
public class Node {

    private String character;
    private Node[] nodes;
    private boolean isVisited;
    private boolean isLeaf;

    public Node(String character) {
        this.character = character;
        this.nodes = new Node[26];
    }

    public Node getChild(int k){
        return nodes[k];
    }

    public void setChild(int index, Node n ){
        nodes[index] = n;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }



    @Override
    public String toString() {
        return "Vertex{" +
                "character='" + character + '\'' +
                '}';
    }
}
