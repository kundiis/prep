package BT;

/**
 * Created by km on 6/11/18.
 */
public class Height {

    public int height(Node root){
        if(root == null){
            return 0;
        }

        int left = height(root.getLeft());
        int right = height(root.getRight());

        return Math.max(left, right) + 1;
    }

}
