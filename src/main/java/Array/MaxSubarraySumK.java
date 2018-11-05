package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by km on 6/6/18.
 */

// This is max sub array sum
public class MaxSubarraySumK {

    // o(n)
    public static void maxSubArrayK(int[] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum=0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            map.putIfAbsent(sum, i);

            if(sum == k){
                max = Math.max(max, i+1);
            }

            int diff = sum-k;
            if(map.containsKey(diff)){
                max = Math.max(max, i-map.get(diff));
            }
        }

        System.out.println(max);

    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        maxSubArrayK(data, 10);
    }
}
