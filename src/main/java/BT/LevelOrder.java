package BT;


import java.util.*;

/**
 * Created by km on 6/11/18.
 */
public class LevelOrder {

    public class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            Queue<Node> q = new LinkedList<Node>();
            q.offer(root);

            while (!q.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {

                    Node node = q.poll();
                    list.add(node.getId());
                    // push child node into queue
                    if (node.getLeft() != null) q.offer(node.getLeft());
                    if (node.getRight() != null) q.offer(node.getRight());

                }
                result.add(new ArrayList<>(list));
            }

            return result;
        }
    }


    public static void reverseLevelOrder(Node root){
        if(root == null) return;

        Stack<Node> s= new Stack<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            Node element = q.remove();
            s.push(element);

            if(element.getRight()!=null) {
                q.add(element.getRight());
            }

            if(element.getLeft()!=null) {
                q.add(element.getLeft());
            }
        }

        while(!s.isEmpty()){
            System.out.println(s.pop().getId());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));

        root.getLeft().setLeft(new Node(4));
        root.getRight().setLeft(new Node(5));

        reverseLevelOrder(root);
    }
}
