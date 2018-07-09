package BT;

import java.util.Comparator;

/**
 * Created by km on 6/10/18.
 */
public class Identical {

    class Node implements Comparable<Node>{
        Integer id;
        Node left;
        Node right;

        @Override
        public int compareTo(Node o) {
            return this.id.compareTo(o.id);
        }
    }

    boolean checkIdentical(Node root1, Node root2){

        if( root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null){
            return (root1.id == root2.id) && checkIdentical(root1.left,root2.left) && checkIdentical(root1.right,root2.right);
        }
        return false;
    }
}
