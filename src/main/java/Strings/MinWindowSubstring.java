package Strings;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow(String s, String pattern) {

        Map<Character, Integer> map = new HashMap<>();
        for(char x: pattern.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int unique = map.size();

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int startLoc=0;
        int endLoc=0;

        while( right < s.length()){
            char startChar = s.charAt(right);

            if(map.containsKey(startChar)){
                map.put(startChar, map.get(startChar)-1);
                if(map.get(startChar)==0) unique--;
            }

            // found all the character once
            while(unique == 0){

                if( min > (right - left)){
                    min = Math.min(min, right - left);
                    startLoc = left;
                    endLoc = right;
                }

                // try to move the left
                char endChar = s.charAt(left);
                if(map.containsKey(endChar)){
                    map.put(endChar, map.get(endChar)+1);
                    if(map.get(endChar)==1){
                        unique++;
                    }
                }
                left ++;
            }

            right ++;
        }
        return s.substring(startLoc, endLoc + 1);

    }

    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

}
