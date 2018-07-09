package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by km on 5/21/18.
 */
public class Operations {

    public String reverseAString(String text){

        int length = text.length();
        StringBuilder builder = new StringBuilder();
        for(int i =length-1; i >= 0; i--){
            builder.append(text.charAt(i));
        }

        return builder.toString();
    }

    public List<String> suffixes(String text){

        List<String> lists = new ArrayList<>();
        int length = text.length();
        for(int i = 0;i<length+1;i++){
            lists.add(text.substring(i, length));
        }

        return lists;
    }

    public String longestPrefix(String first, String second){

        int max = Math.min(first.length(), second.length());

        for(int i = 0; i < max; i++){
            if(first.charAt(i) != second.charAt(i)){
                return first.substring(0, i);
            }
        }

        return first.substring(0, max);
    }

    public String longestRepeatedSubstring(String text){

        List<String> suffixes = suffixes(text); // O(n)
        System.out.println(suffixes);
        Collections.sort(suffixes); // O(nlogn)
        System.out.println(suffixes);

        int size = suffixes.size();
        String longestPrefix = "";

        for(int i = 0; i < size - 1; i++){ // O(nlogn )
            String newLongestPrefix = longestPrefix(suffixes.get(i), suffixes.get(i+1));
            if(newLongestPrefix.length() > longestPrefix.length()){
                longestPrefix = newLongestPrefix;
            }
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        Operations o = new Operations();
        System.out.println(o.longestRepeatedSubstring("abcdcd"));
    }

}
