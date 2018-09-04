package BT;

/**
 * Created by km on 6/14/18.
 */
public class DistanceBetweenNodes {

    // find LCA
    // then height from LCA for each element
    // add up the height

    public void distanceBetween(Node root, Node element1, Node element2){
        Node lca = findLCA(root, element1, element2);
        int distance = level(lca, element1, 0) + level(lca, element2, 0); // calculate sum of both heights
        System.out.println(distance);
    }

    private Node findLCA(Node root, Node element1, Node element2) {

        if(root == null) return null;

        // if either of them is root
        if(root.getId() == element1.getId() || root.getId() == element2.getId()){
            return root;
        }

        Node left = findLCA(root.getLeft(), element1, element2);
        Node right = findLCA(root.getRight(), element1, element2);

        if(left!=null && right!=null){
            return root;
        }

        return left!=null? left: right;
    }

    private int level(Node root, Node element, int level){
        if(root == null) return -1;

        if(element.getId() == root.getId()){
            return level;
        }

        int left = level(root.getLeft(), element, level+1);
        if(left != -1){
            return left;
        }
        return level(root.getRight(), element, level+1);
    }
}
