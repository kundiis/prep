package BT;

/**
 * Created by km on 6/13/18.
 */
public class Mirror {
    // https://stackoverflow.com/questions/4366251/mirror-image-of-a-binary-tree

    public void mirror(Node root){
        mirrorTree(root);
    }

    private Node mirrorTree(Node root) {

        if(root == null) return null;

        Node newRoot = new Node(root.getId());
        newRoot.setLeft(mirrorTree(root.getRight()));
        newRoot.setRight(mirrorTree(root.getLeft()));
        return newRoot;

    }
}
