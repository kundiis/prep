package LinkedList;
/*
    1 -> 2 -> 3 -> 4 -> null
    null <- 1 <- 2 <- 3 <- 4
*/

public class ReverseLinkedList {

    private Node reverseRootIterative(Node root){

        Node prev = null;
        Node current = root;
        Node next = null;

        while(current!=null){

            next = current.getNext();
            current.setNext(prev);

            prev = current;
            current = next;

        }

        root = prev;

        return root;
    }
}
