package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by km on 6/8/18.
 */
public class DistinctCombinations {

    // O(2^n)
    private static void combinations(int[] numbers, int pos, String s){
        System.out.println(s);

        for(int i = pos; i < numbers.length; i++){
            combinations(numbers, i+1, s + numbers[i]);
        }

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3};
        //combinations(numbers, 0, "");
        //combinations("abc".toCharArray(), 0, "");
        combinations(numbers,0, new ArrayList<>());
    }

    public static void combinations(char[] chars, int pos, String s){

        System.out.println(s);
        for(int i = pos; i< chars.length; i++){
            combinations(chars, i+1, chars[i] + s);
        }

    }

    private static void combinations(int[] numbers, int pos, List<Integer> current){
        System.out.println(current);

        for(int i = pos; i < numbers.length; i++){

            List<Integer> newList = new ArrayList<>(current);
            newList.add(numbers[i]);
            System.out.println("before-->pos -->"+ pos + "-->" + newList);
            combinations(numbers, i+1, newList);
            newList.remove( newList.size()-1);
            System.out.println("after-->pos -->"+ pos + "-->" +newList);

        }
    }

}
