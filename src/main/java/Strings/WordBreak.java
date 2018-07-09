package Strings;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> cache = new HashMap<>();
        return wordBreak(s, dict, cache);
    }

    private boolean wordBreak(String s, Set<String> dict, Map<String, Boolean> cache){
        if(s.length() == 0 || s == null){
            return false;
        }
        if(dict.contains(s)){
            return true;
        }
        if(cache.containsKey(s)){
            return cache.get(s);
        }

        for(int i = 0; i< s.length(); i++){
            String prefix = s.substring(0,i);
            if(dict.contains(prefix)){
                String suffix = s.substring(i,s.length());
                //System.out.println(prefix + "-->"+ suffix);
                boolean suffixFound = wordBreak(suffix, dict, cache);
                if(!suffixFound){
                    cache.put(suffix, false);
                    continue;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaab";
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("aa");
        l.add("aaa");
        l.add("aaaa");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, l));
    }
}
