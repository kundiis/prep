package BT;


import java.util.Stack;

/**
 * Created by km on 6/11/18.
 */
public class SpiralOrder {

    // uses 2 stack
    // or get the height and run recursive at every single level
    public void SpiralOrder(Node root){

        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){

            while(!s1.isEmpty()){
                Node element = s1.pop();
                System.out.println(element.getId());

                s2.push(element.getRight());
                s2.push(element.getLeft());
            }

            while(!s2.isEmpty()){
                Node element = s2.pop();
                System.out.println(element.getId());

                s1.push(element.getLeft());
                s1.push(element.getRight());
            }
        }
    }
}
