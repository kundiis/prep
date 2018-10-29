package BT;

/**
 * Created by km on 6/11/18.
 */
public class BalancedOrNot {

    public int balanced(Node root){

        if(root == null) return 0;

        int left = balanced(root.getLeft());
        if(left == -1) return -1;

        int right = balanced(root.getRight());
        if(right == -1) return -1;

        if(Math.abs(left-right) > 1){
            return -1;
        }else{
            return Math.max(left,right)+1;
        }

    }

    public int balancedOrNot(Node root){

        if(root == null) return 0;

        int left = balancedOrNot(root.getLeft());
        if(left==-1) return -1;

        int right = balancedOrNot(root.getRight());
        if(right==-1) return -1;

        if(Math.abs(left-right) > 1){
            return -1;
        }else {
            return Math.max(left, right) + 1;
        }
    }
}
