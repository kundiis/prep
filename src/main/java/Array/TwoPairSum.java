package Array;

import java.util.Arrays;

/**
 * Created by km on 6/6/18.
 */
public class TwoPairSum {

    int[] arr = new int[10];

    // (O nlogn) O(1) space
    public void TwoSumSort(int sum){

        Arrays.sort(arr);

        int low = 0; int high = arr.length-1;
        while(low < high){
            int tempSum = arr[low] + arr[high];
            if(tempSum == sum){
                System.out.println("found pair");
            }
            else if(tempSum < arr[low]){
                low ++;
            }else
                high --;
        }
    }

    // o(n) space and time using hashmap
}
