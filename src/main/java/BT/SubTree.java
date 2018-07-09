package BT;

/**
 * Created by km on 6/13/18.
 */
public class SubTree {

    boolean isSubTree = false;

    public boolean subTree(Node large, Node small){

        if(small == null) return true;
        if(large == null) return false;

        if(large.getId() == small.getId()){
           return matchSubTree(large, small);
        }

        return subTree(large.getLeft(), small) && subTree(large.getRight(), small);

    }

    public boolean matchSubTree(Node n1, Node n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        return (n1.getId() == n2.getId())
                && matchSubTree(n1.getLeft(), n2.getLeft())
                && matchSubTree(n1.getRight(), n2.getRight());
    }

    // O(N) -- match pre-order and post order of both
}
