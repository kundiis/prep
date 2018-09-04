package BST;

/**
 * Created by km on 5/15/18.
 */
public class BST<T extends Comparable<T>> {

    /*
    -1 0 1

    1.compareTo(0) (return: 1)
    1.compareTo(1) (return: 0)
    0.compareTo(1) (return: -1)

     */

    Node<T> root;
    private Node<T> insert(Node<T> root, T data) {

        if(root == null){
            Node<T> newNode = new Node<T>(data);
            return newNode;
        }

       if(root.getData().compareTo(data) > 0){
            root.setLeft(insert(root.getLeft(), data));
       }else if(root.getRight()!=null){
            root.setRight(insert(root.getRight(), data));
       }
       return root;
    }

    public void rightRotate(Node<T> root){

        if(root == null) return;

        Node<T> left = root.getLeft();
        Node<T> t = left.getRight();

        left.setRight(root);
        root.setLeft(t);

    }

    public void leftRotate(Node<T> root){

        if(root == null) return;

        Node<T> right = root.getRight();
        Node<T> t = right.getLeft();

        right.setLeft(root);
        root.setRight(t);

    }

    public void inOrder(Node<T> root){
        if(root == null) return;

        inOrder(root.getLeft());
        System.out.println(root.data);
        inOrder(root.getRight());
    }

    public void preOrder(Node<T> root){
        if(root == null) return;

        System.out.println(root.data);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void postOrder(Node<T> root){
        if(root == null) return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.data);

    }

    public Node<T> find(Node<T> root, T data){
        if(root == null) return null;

        if(root.getData().compareTo(data) == 0){
            return root;
        }

        if(root.getData().compareTo(data) > 0){
            return find(root.getLeft(), data);
        }else{
            return find(root.getRight(), data);
        }
    }

    //https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
    // http://www.java2novice.com/java-interview-programs/delete-node-binary-search-tree-bst/

    public Node<T> delete(Node<T> root, T data){

        if(root == null) return root;

        if(root.getData().compareTo(data) < 0){
            root.setRight( delete(root.getRight(), data) );
        }else if( root.getData().compareTo(data) > 0){
            root.setLeft( delete(root.getLeft(), data) );
        }

        // found the node
        // if left and right are null
        if(root.getRight() == null && root.getLeft()==null){
            return null;
        }

        // if either is null
        if( root.getLeft() == null){
            return root.getRight();
        }else if( root.getRight() == null){
            return root.getLeft();
        }

        // if left and right both are NOT null
        // search for min number in right sub tree
        T minValue = minValue(root.getRight());
        root.setData(minValue);
        root.setRight(delete(root.getRight(), minValue)); // find the minimum in the right and then delete

        return root;
    }

    private T minValue(Node<T> node) {

        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.data;
    }

}
