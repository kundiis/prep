package BT;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by km on 6/11/18.
 */
public class LevelOrder {

    public static void levelOrder(Node root){

        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node element = q.remove();
            System.out.print(element.getId() + "\t");

            if(element.getLeft()!=null)
            q.add(element.getLeft());

            if(element.getRight()!=null)
            q.add(element.getRight());
        }

        System.out.println();
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
