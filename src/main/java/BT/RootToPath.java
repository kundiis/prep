package BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by km on 6/14/18.
 */
public class RootToPath {

    static List<Integer> aList = new ArrayList<>();

    public static void rootToPath(Node root, List<Integer> list){

        if(root == null) return;

        list.add(root.getId());

        if(root.getLeft()== null && root.getRight()==null){
            System.out.println(list);
        }else {
            rootToPath(root.getLeft(), new ArrayList<>(list));
            rootToPath(root.getRight(), new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));

        root.getLeft().setLeft(new Node(4));
        root.getRight().setRight(new Node(5));

        rootToPath(root, aList);
    }
}
