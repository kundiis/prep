package BST;

import java.util.Comparator;
import java.util.PriorityQueue;

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
}
