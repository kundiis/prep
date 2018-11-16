package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNonRepeating {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;
        //use sliding window approach
        int left = -1; int right = 0;
        int max = 0;
        Map<Character, Integer> lookup = new HashMap<>();

        while(right < s.length()){
            char current = s.charAt(right);
            if(lookup.containsKey(current)){
                left = Math.max(left, lookup.get(current));
            }
            lookup.put(current, right);
            max = Math.max(right-left, max);
            right++;
        }

        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringNonRepeating substringNonRepeating = new LongestSubstringNonRepeating();
        substringNonRepeating.lengthOfLongestSubstring("bbbbb");
        substringNonRepeating.lengthOfLongestSubstring("pwwkew");
        substringNonRepeating.lengthOfLongestSubstring("abcdabc");
        substringNonRepeating.lengthOfLongestSubstring("abba");

    }

}
