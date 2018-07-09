package Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by km on 5/18/18.
 */
public class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private static final int MAX = 10;

    private Node head;
    private Node tail;

    public int get(int k){
        if(map.containsKey(k)){
            Node foundNode = removeNode(k);
            addOnHead(foundNode.getKey(), foundNode.getValue());

            return map.get(k).getValue();
        }
        return -1;
    }

    public void put(int k, int v){
        if(map.containsKey(k)){
           // update the references and bring it forward
           Node foundNode = removeNode(k);
           addOnHead(foundNode.getKey(), foundNode.getValue());

        }else{
            // new item
            // check size
            addOnHead(k, v);
            removeFromTailAndMap();
        }
    }

    private Node removeNode(int k) {
        Node foundNode = map.get(k);
        foundNode.getPrevious().setNext(foundNode.getNext());
        foundNode.setNext(null);
        foundNode.setPrevious(null);

        return foundNode;
    }

    private void removeFromTailAndMap() {
        if(map.size() == MAX) {
            map.remove(tail.getKey());
            tail = tail.getPrevious();
            tail.setNext(null);
        }
    }

    private void addOnHead(int k, int v) {
        Node newHead = new Node(k, v);
        newHead.setNext(head);
        head.setPrevious(head);
        head = newHead;
        map.put(k, head);
    }

}
