package TST;

/**
 * Created by km on 5/20/18.
 */
public class TernarySearchTree {

    Node root;

    public void put(String key, int value){

        int index=0;
        root = insert(root, key, value, index);

    }

    private Node insert(Node node, String key, int value, int index) {

        char c = key.charAt(index);

        if(node == null){
            node = new Node(c);
        }

        if( c < node.getCharacter()){
            node.setLeft( insert(node.getLeft(), key, value, index) );
        }else if( c > node.getCharacter()){
            node.setRight( insert(node.getRight(), key, value, index) );
        } else if( index < key.length() - 1){
            node.setMiddle( insert(node.getMiddle(), key, value, index+1) );
        }

        node.setValue(value);

        return node;
    }

    public Integer get(String key){
        int index = 0;
        Integer value = get(root, key, index);
        return value;
    }

    private Integer get(Node node, String key, int index) {

        if(node == null) return -1;

        char c = key.charAt(index);

        if( c > node.getCharacter()){
            return get(node.getRight(), key, index);
        }else if( c < node.getCharacter()){
            return get(node.getLeft(), key, index);
        }else if( index < key.length() -1){
            return get(node.getMiddle(), key, index + 1);
        }

        return node.getValue();
    }

}
