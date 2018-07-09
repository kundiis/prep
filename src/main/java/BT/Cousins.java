package BT;

/**
 * Created by km on 6/13/18.
 */
public class Cousins {

    // algo both are on same level
    // both have different immediate root
    public void cousin(Node root, Node a, Node b){

        int h1 = getLevel(root, a, 0);
        int h2 = getLevel(root, a, 0);

        if(h1 != h2){
            System.out.println("not cousin");
            System.exit(1);
        }

        // check for different root
        if(checkRoots(root, a, b)){
            System.out.println("not cousin");
            System.exit(1);
        }else{
            System.out.println("cousins");
        }

    }

    private boolean checkRoots(Node root, Node a, Node b) {

        if(root == null){
            return false;
        }

        return (a == root.getLeft() && b == root.getRight()) ||
                (a == root.getRight() && b == root.getLeft()) ||
                (checkRoots(root.getLeft(), a, b)) ||
                (checkRoots(root.getRight(),a,b));

    }

    private int getLevel(Node root, Node element, int level){
        if(root == null) return 0;

        if(root == element){
            return level;
        }

        level =  getLevel(root.getLeft(), element, level+1);
        if(level!=0) return level;

        return getLevel(root.getRight(), element, level+1);
    }
}
