package BT;

/**
 * Created by km on 6/13/18.
 */
public class Diameter {

    /*
        height of left + height of right + 1 -- passing through root
        diameter of left tree
        diameter of right tree

        find the max of all 3
     */

    // https://stackoverflow.com/questions/11897088/diameter-of-binary-tree-better-design

    public int diameter(Node root){

        int rootDiameter = 1 + height(root.getLeft()) + height(root.getRight());
        int left = diameter(root.getLeft());
        int right = diameter(root.getRight());

        return Math.max(rootDiameter, Math.max(left, right));
    }

    public int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }
}
