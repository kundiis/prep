package Strings;

// aab == xxy ( a->x, b-y)
// title == paper ( t->p, i->a, l->e, e->r)
// abc == xxy ( a->x, b->x, c->y)

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t){

        if(s.length() != t.length())
            return false;

        Map<Character, Character> lookup1 = new HashMap<>();
        Map<Character, Character> lookup2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            char a = s.charAt(i);
            char b = t.charAt(i);

            if(lookup1.containsKey(a)){
                if(lookup1.get(a)!=b){
                    return false;
                }
            }else{
                lookup1.put(a,b);
            }

            if(lookup2.containsKey(b)){
                if(lookup2.get(b)!=a){
                    return false;
                }
            }else{
                lookup2.put(b,a);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings strings = new IsomorphicStrings();
        System.out.println(strings.isIsomorphic("aab", "xxy"));
        System.out.println(strings.isIsomorphic("abb", "xxy"));
        System.out.println(strings.isIsomorphic("abc", "xxy"));
        System.out.println(strings.isIsomorphic("xxy", "abc"));
        System.out.println(strings.isIsomorphic("paper", "title"));

    }

}
