package DynamicP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by km on 6/3/18.
 */
public class SubsetSumRecursive {

    //https://livinglifetechway.com/solving-subset-sum-problem/
    // O(2^n)

    public static boolean findSumFromList(List<Integer> set, Integer sum, ArrayList<Integer> result) {

        if(sum == 0){
            return true; // found the sum
        }

        if(sum < 0) return false;

        if(set.isEmpty()) return false;

        Integer element = set.remove(0);
        List<Integer> newSet = new ArrayList<>(set);

        // include this branch
        if(findSumFromList(newSet, sum-element, result)){
            return true;
        }

        // exclude this branch
        if(findSumFromList(newSet, sum, result)){
            return true;
        }

        return false;
    }
}