package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by km on 6/6/18.
 */

// Sliding window maximum sum
//  https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

    /*
    arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6
     */


    // This is max sub array sum
public class MaxSubarraySumK {

    // o(n)

    int[] array = new int[100];
    public void maxSubArrayK(int[] nums,int k){

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int sum=0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum==k){
                max = Math.max(max, i+1);
            }

            int diff = sum-k;

            if(map.containsKey(diff)){
                max = Math.max(max, i-map.get(diff));
            }


            map.putIfAbsent(sum, i);

        }

        System.out.println(max);

    }
}
