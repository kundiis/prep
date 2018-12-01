package BST;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by km on 6/16/18.
 */
public class KthSmallest {

    public void KthSmallest(Node root, int k){

        // traverse left to find the count or do inorder traversal in stack and pop until K is reached
        // or use min heap
        PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

    }

    private int inOrder(Node root, int k){

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr = root;

        while(curr != null){

            while (curr !=  null) {
                /* place pointer to a tree node on the stack before traversing the node's left subtree */
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.data);
            k--;
            if(k==0){
                return (int)curr.data;
            }
            curr = curr.right;

        }

        return -1;
    }
}
