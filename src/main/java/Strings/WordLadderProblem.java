package Strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderProblem {

    public int WordLadder( String start, String end, Set<String> dict ){

        Queue<String> q = new LinkedList<>();
        q.add(start);
        int count = 0;

        while(!q.isEmpty()){
            String word = q.remove();

            for(int i = 0; i< word.length(); i++){
                for( int j = 'a'; j<='z'; i++ ){
                    // form a new word and check in dict
                    String newWord = word.substring(0, i)+ j + word.substring(i+1, word.length());
                    if(dict.contains(newWord)){
                        q.add(newWord);
                        dict.remove(newWord);
                        count ++;
                        break;
                    }
                }
                if(q.peek().equals(end)){
                    System.out.println("");
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        WordLadderProblem problem = new WordLadderProblem();
    }

}
