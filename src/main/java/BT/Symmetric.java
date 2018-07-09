package BT;

/**
 * Created by km on 6/13/18.
 */
public class Symmetric {

    public boolean symmetric(Node root){
        return match(root.getLeft(), root.getRight());
    }

    private boolean match(Node left, Node right) {

        if(left==null && right==null) return true;
        if(left==null || right==null) return false;

        return (left.getId() == right.getId())
                && (match(left.getLeft(), right.getRight()))
                && match(left.getRight(), right.getLeft());
    }
}
