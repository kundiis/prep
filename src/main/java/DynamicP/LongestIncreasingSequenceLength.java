package DynamicP;

import java.util.Arrays;

public class LongestIncreasingSequenceLength {

    // https://algorithms.tutorialhorizon.com/dynamic-programming-longest-increasing-subsequence/
    // solution at previous steps is applicable for next step

    // {3, 10, 2, 1, 20}

    public void algo(int[] array){

        int[] temp = new int[array.length];

        for( int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    temp[i]  = Math.max( temp[i], temp[j] + 1);
                }
            }
        }
    }

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for(int i=0; i<nums.length; i++){

            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max[i]= Math.max(max[i], max[j]+1);

                }
            }
            result = Math.max(max[i], result);

        }

        return result;
    }
}
