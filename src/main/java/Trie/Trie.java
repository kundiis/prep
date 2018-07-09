package Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by km on 5/19/18.
 */
public class Trie {

    private Node root;

    // first one with empty node
    public Trie() {
        this.root = new Node("");
    }

    public void insert(String words){

        Node temp = root;

        for( int i = 0; i < words.length(); i++){
            char c = words.charAt(i);

            int value = c;
            int transformedValue = c - 'a';

            // check if value already inserted
            Node v = temp.getChild(transformedValue);
            if(v == null){
                Node newNode = new Node(String.valueOf(c));
                temp.setChild(transformedValue, newNode);

                temp = newNode;
            }else{
                temp = v;
            }
        }
        temp.setLeaf(true);

    }

    public boolean search(String words){
        Node temp = root;
        for( int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);

            int transformedValue = c - 'a';

            if(temp.getChild(transformedValue) == null){
                return false;
            }else{
                temp = temp.getChild(transformedValue);
            }

        }

        return true;
    }

    public List<String> autoComplete(String prefix){

        Node temp = root;
        for( int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            int transformedValue = c - 'a';

            if(temp.getChild(transformedValue) != null){
                temp = temp.getChild(transformedValue);
            }

        }

        List<String> strings = new ArrayList<>();
        // run dfs for the node
        dfs(temp, prefix ,strings);
        return strings;
    }

    private void dfs(Node n, String prefix, List<String> listOfWords){
         if(n == null) return;

         if(n.isLeaf()){
             listOfWords.add(prefix);
         }

        for(Node child: n.getNodes()){
            if( child == null) continue;
            String character = child.getCharacter();
            dfs(child, prefix+character, listOfWords);
        }
    }

    private String longestCommonPrefix(){

        Node temp = root;
        String lcf = "";

        while( temp.getNodes().length != 1 && !temp.isLeaf()){
            // find the set location
            for(int i=0; i< temp.getNodes().length;i++){
                if(temp.getNodes()[i] !=null){
                    lcf = lcf + temp.getNodes()[i].getCharacter();
                    temp = temp.getNodes()[i];
                    break;
                }
            }
        }
        return lcf;
    }

}
