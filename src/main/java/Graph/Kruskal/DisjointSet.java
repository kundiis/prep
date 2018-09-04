package Graph.Kruskal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by km on 5/29/18.
 */
public class DisjointSet {

    private int count;
    private List<Node> nodeList; // representatives

    public DisjointSet(List<Vertex> vertexList) {
        this.nodeList = new ArrayList<>(vertexList.size());
        makeSets(vertexList);
    }

    private void makeSets(List<Vertex> vertexList) {
        for(Vertex v: vertexList){
            makeSet(v);
        }
    }

    private void makeSet(Vertex vertex) {
        Node n = new Node(nodeList.size(), 0, null);
        vertex.setNode(n);
        nodeList.add(n);
    }

    public Node findSet(Node n){
        Node root = n; // assume

        while( root.getRoot() != null){
            root = root.getRoot();
        }

        compressPath(root, n);

        return root;
    }

    private void compressPath(Node root, Node currentNode) {
        while(currentNode != root){
            Node temp = currentNode.getRoot();
            currentNode.setRoot(root);
            currentNode = temp;
        }
    }

    public void union(Node node1, Node node2){

        Node rep1 = findSet(node1);
        Node rep2 = findSet(node2);

        if(rep1.getId() == rep2.getId()) return; // same set

        if(rep1.getId() > rep2.getId() ){
            rep2.setRoot(rep1);
            rep2.setRank(rep2.getRank()+1);
        }else{
            rep1.setRoot(rep2);
            rep1.setRank(rep1.getRank()+1);
        }

    }
}
