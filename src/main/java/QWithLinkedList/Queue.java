package QWithLinkedList;

/**
 * Created by km on 5/14/18.
 */
public class Queue<T extends Comparable<T>> {

    Node<T> first;
    Node<T> last;
    int count;

    public void enqueue(T data){

        Node<T> newN = new Node<T>(data);

        if(count == 0){
            last = newN;
            first = newN;
        }else{
            last.setNext(newN);
            last = newN;
        }
        count++;
    }

    public T dequeue(){

        if(count == 0){
            return null;
        }

        T data = first.getData();
        first = first.getNext();
        return data;
    }
}
