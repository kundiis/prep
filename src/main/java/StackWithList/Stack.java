package StackWithList;

/**
 * Created by km on 5/14/18.
 */
public class Stack<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public void push(T data){

        size ++;
        if(root == null){
            root = new Node<T>(data);
        }else{
            Node<T> temp = root;
            root = new Node<T>(data);
            root.setNext(temp);
        }
    }

    public T pop(){

        if(root == null) return null;

        Node<T> d = root;
        root = root.getNext();

        size--;

        return d.getData();
    }

    public T peek(){
        if(root == null) return null;
        return root.getData();
    }

}
