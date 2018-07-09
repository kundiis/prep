package DynamicP;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by km on 6/2/18.
 */
public class WordBreakProblem {

    public void wordBreakBruteForceTwoWords(Set<String> dict, String input){
        for(int i=0; i< dict.size(); i++){
            String prefix = input.substring(0, i);
            if( dict.contains(prefix)){
                String suffix = input.substring(i, input.length());
                if(dict.contains(suffix)){
                    System.out.println("Found "+prefix + "-- "+ suffix);
                }
            }
        }
    }

    public String wordBreakBruteForceMultiWords(Set<String> dict, String input){
        for(int i=0; i< dict.size(); i++){
            String prefix = input.substring(0, i);

            if( dict.contains(prefix)){
                String suffix = input.substring(i, input.length());
                String words = wordBreakBruteForceMultiWords(dict, suffix);
                if(words!=null){
                    System.out.println("Found "+prefix + "-- "+ words);
                    return prefix + "" + words;
                }
            }
        }
        return null;
    }

    private Map<String, String> memo = new HashMap<>();
    public String wordBreakBruteForceMultiWordsMemoized(Set<String> dict, String input){

        if(dict.contains(input))
            return input;

        if(memo.containsKey(input)){
            return memo.get(input);
        }

        for(int i=0; i< dict.size(); i++){
            String prefix = input.substring(0, i);
            if( dict.contains(prefix)){
                String suffix = input.substring(i, input.length());
                String words = wordBreakBruteForceMultiWordsMemoized(dict, suffix);
                if(words!=null){
                    memo.put(input, prefix + words);
                    System.out.println("Found "+prefix + "-- "+ words);
                    return prefix + "" + words;
                }
            }
        }

        memo.put(input, null);
        return null;
    }
}
