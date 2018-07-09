package BST;

/**
 * Created by km on 5/15/18.
 */
public class BST<T extends Comparable<T>> {

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
    public Node<T> delete(Node<T> root, T data){

        if(root == null) return root;

        if(root.getData().compareTo(data) < 0){
            root.setRight( delete(root.getRight(),data) );
        }else if( root.getData().compareTo(data) > 0){
            root.setLeft( delete(root.getLeft(), data) );
        }

        // found the node

        // if left and right are null
        if(root.getRight() == null && root.getLeft()==null){
            root = null;
            return root;
        }

        // if either is null
        if( root.getLeft() == null){
            Node<T> temp = root.getRight();
            root = null;
            return temp;
        }else if( root.getRight() == null){
            Node<T> temp = root.getLeft();
            root = null;
            return temp;
        }

        // if left and right both are NOT null
        // Find inorder successor of the node
        Node<T> tempNode = findPredecessor(root.getLeft());
        root.setData(tempNode.getData());
        root.setLeft(delete(root.getLeft(), tempNode.getData()));

        return root;
    }

    private Node<T> findPredecessor(Node<T> root) {
        if(root != null){
            findPredecessor(root.getRight());
        }
        return root;
    }

}
