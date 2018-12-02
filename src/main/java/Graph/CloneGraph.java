package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
      int label;
      List<Node> neighbors;
      Node(int x) { label = x; neighbors = new ArrayList<>(); }
     };

    private HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        Node clone = new Node(node.label);
        map.put(clone.label, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }

}
