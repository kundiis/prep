package Backtracking;

import java.util.*;

public class PhoneNumbers {

    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }
        //Init map
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        // Init 1 digits and the chars in queue
        Queue<String> queue = new LinkedList<String>();
        char current = digits.charAt(0);
        String alpha = map.get(current);
        for (int i = 0; i < alpha.length(); i++) {
            queue.offer(alpha.charAt(i) + "");
        }

        int size = 0;
        for (int i = 1; i < digits.length(); i++) {//iteratve all numbers
            current = digits.charAt(i);
            alpha = map.get(current);
            size = queue.size();
            for (int j = 0; j < size; j++) { //iteratve old queue
                String str = queue.poll();
                for (int k = 0; k < alpha.length(); k++) {//iteratve possibile chars per number key
                    queue.offer(str + alpha.charAt(k));
                }
            }
        }
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }

        return rst;
    }

    public static void main(String[] args) {
        PhoneNumbers numbers = new PhoneNumbers();
        System.out.println(numbers.letterCombinations("234"));
    }

}
