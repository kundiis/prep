package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCache {

    class DLL{
        int data;
        DLL next;
        DLL previous;
        public DLL(int data){
            this.data = data;
        }
    }

    Map<Integer, DLL> lookup;
    DLL head = null;  // latest used element
    int size = 0;

    public LRUCache(int capacity) {
       lookup = new HashMap<>(capacity);
       this.size = capacity;
    }

    public int get(int key) {
        if(lookup.containsKey(key)){
            DLL temp = lookup.get(key);
            int data = temp.data;
            removeFromList(temp);
            DLL node = addOnHead(data);
            lookup.put(key, node);
            return data;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(lookup.size() == size){
            removeFromTail();
        }
        DLL newNode = addOnHead(value);
        lookup.put(key, newNode);
    }

    private DLL addOnHead(int data){

        DLL node = new DLL(data);
        node.next = head; // make new node as head

        head.previous = node;
        head = node;

        return node;
    }

    private DLL removeFromTail(){
        DLL temp = head; // abc
        while(temp.next!=null){
            temp = temp.next; // c
        }
        if(temp.previous!=null){ // b!=null
            temp.previous.next = null;
        }
        return temp;
    }

    private void removeFromList(DLL node){

        if(node.previous!=null){
            node.previous.next = node.next;
        }
        node=null;

    }

}

