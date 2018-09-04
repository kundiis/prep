package BoyerMoore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by km on 5/20/18.
 */

// Boyer Moore Algorithm
    // O(Pattern) + O(nP) - worst case
public class SubstringSearch {

    private Map<String, Integer> badMatch = new HashMap<>();
    private String pattern;

    public SubstringSearch(String pattern) {
        this.pattern = pattern;
        preComputeBadMatch();
    }

    private void preComputeBadMatch(){
        for(int i =0;i< pattern.length(); i++){
            char c = pattern.charAt(i);
            int position = Math.max(1, pattern.length() - i - 1);
            System.out.println( c + "-->" + position );
            badMatch.put(String.valueOf(c), position);
        }
    }

    public boolean findText(String text){
        int skip = 0;

        for(int i = 0; i < text.length(); i+=skip){
            for( int j = pattern.length() -1; j >= 0; j--){

                char toMatch = text.charAt(i+j);
                if(toMatch != pattern.charAt(j)){
                    if(badMatch.containsKey(toMatch)){
                        skip = badMatch.get(toMatch);
                    }else{
                        skip = pattern.length(); // skip maximum
                    }
                    break;
                }
            }

            if(skip ==0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SubstringSearch substringSearch = new SubstringSearch("abcd");
        System.out.println(substringSearch.findText("abcedbabcd"));

    }
}
