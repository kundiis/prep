package LinkedList;

/**
 * Created by km on 5/13/18.
 */
public class ListImpl<T extends Comparable<T>> implements ListInterface<T> {

    Node<T> head;
    int size = 0;

    public void insert(T data) {
        size++;
        if(head == null){
            head = new Node<T>(data);
        }else{
            insertAtHead(data);
        }
    }

    private void insertAtHead(T data) {
        Node temp = head;
        head = new Node<T>(data);
        head.setNext(temp);
    }

    public void delete(T data) {

        if(head == null) return;

        if(head.data.compareTo(data) == 0){
            head = head.getNext();
        } else {
            remove(data, head, head.getNext());
        }
    }

    private void remove(T data, Node<T> head, Node<T> next) {

        while(next!=null) {
            if (next.data.compareTo(data) == 0) {
                head.next = next.getNext();
                head = null;
                return;
            }
            next = next.getNext();
        }
    }

    public void search(T data) {

    }

    public int size() {
        return size;
    }
}
