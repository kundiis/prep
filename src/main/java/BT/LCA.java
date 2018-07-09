package BT;

/**
 * Created by km on 6/14/18.
 */
public class LCA {

    // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

    public Node LCA(Node root, int element1, int element2){

        if(root == null){
            return null;
        }

        if( root.getId() == element1 || root.getId() == element2){
            return root;
        }

        Node left_lca = LCA(root.getLeft(), element1, element2);
        Node right_lca = LCA(root.getRight(), element1, element2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if(left_lca != null && right_lca !=null){
            return root;
        }

        return (left_lca != null) ? left_lca : right_lca;
    }
}
