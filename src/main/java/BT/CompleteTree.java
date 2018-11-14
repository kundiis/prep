package BT;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by km on 6/12/18.
 */
public class CompleteTree {

    // variation of level order
    // if the left element is null and there is a right node
    public static boolean completeTree(Node root){

        if(root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            Node element = q.remove();
            if(element == null){
                break;
            }
            System.out.print(element.getId() + "\t");

            q.add(element.getLeft());
            q.add(element.getRight());

        }

        while(!q.isEmpty()){
            if(q.poll()!=null){
                return false;
            }
        }

        return true;
    }
    // variation - full binary tree
    // get the height,count the nodes using bfs and use formula 2^h-1 to match

    private boolean isValidTree(Node root){
        if(root.getLeft() == null && root.getRight()==null) return true;
        if(root.getLeft() == null || root.getRight()==null) return false;

        return isValidTree(root.getLeft()) && isValidTree(root.getRight());
    }
}
