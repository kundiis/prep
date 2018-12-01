package Backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by km on 6/8/18.
 */
public class Permutations {

    // O(n!)
    // http://javaconceptoftheday.com/permutations-of-string-in-java-recursively/

    private static void permutations(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String current = perm + word.charAt(i);
                String remaining = word.substring(0, i) + word.substring(i + 1, word.length());
                //System.out.println(word.charAt(i) + "--->"+ current + "--->" + remaining);
                permutations(current, remaining);
            }
        }
    }

    public static void main(String[] args) {
        permutations("","abc");
    }

}
