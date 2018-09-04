package Strings;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(char x: t.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int unique = map.size();

        int start = 0;
        int end = 0;

        int min = Integer.MAX_VALUE;
        int startLoc=0;
        int endLoc=0;

        while( end < s.length()){
            char startChar = s.charAt(end);

            if(map.containsKey(startChar)){
                map.put(startChar, map.get(startChar)-1);
                if(map.get(startChar)==0) unique--;
            }

            // found all the character once
            while(unique == 0){

                if( min > (end - start)){
                    min = Math.min(min, end - start);
                    startLoc = start;
                    endLoc = end;
                }

                // leaving the tail behind
                char endChar = s.charAt(start);
                if(map.containsKey(endChar)){
                    map.put(endChar, map.get(endChar)+1);
                    if(map.get(endChar)==1){
                        unique++;
                    }
                }

                start ++;
            }
            end ++;
        }
        return s.substring(startLoc, endLoc + 1);

    }

    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

}
