package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieMapImplementation {

    public class TrieNode{
        char alphabet;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf = false;

        public TrieNode() {
        }

        public TrieNode(char alphabet) {
            this.alphabet = alphabet;
        }
    }

    private TrieNode root;

    public TrieMapImplementation(TrieNode root) {
        this.root = new TrieNode();
    }

    public void insertWord(String word){

        Map<Character, TrieNode> children = root.children;

        for(int i = 0; i< word.length(); i++){

            char c = word.charAt(i);
            TrieNode trieNode;
            if(children.get( c ) == null){
                trieNode = new TrieNode(c);
                children.put(c, trieNode);
            }else{
                trieNode = children.get(c);
            }

            children = trieNode.children;

            if( i == word.length()-1 ){
                trieNode.isLeaf = true;
            }
        }
    }

    public boolean search(String word){
        Map<Character, TrieNode> children = root.children;

        for(char c: word.toCharArray()){

            if(children.containsKey(c)){
                TrieNode t = children.get(c);
                children = t.children;
                if(t.isLeaf){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

}
