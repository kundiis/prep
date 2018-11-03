package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphExample {

    class Graph{
        List<Node> vertex;
    }
    class Node{
        List<Node> adjacent;
        String name;
        boolean isVisited;
    }

    private Graph reduce(Graph g){
        Graph newG = new Graph();

        for(Node n: g.vertex){
            // find the corresponding connected nodes
            List<Node> nodeList = getConnectedNodes(n);
        }
        return newG;
    }

    private List<Node> getConnectedNodes(Node start){
        List<Node> result = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(start);

        while (s.isEmpty()) {
            for (Node adj : start.adjacent) {
                if(!adj.isVisited) {
                    s.push(adj);
                    adj.isVisited=true;
                }
            }
        }
        return result;
    }
}
