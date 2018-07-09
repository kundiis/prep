package DynamicP;

/**
 * Created by km on 6/2/18.
 */
//http://theoryofprogramming.com/2016/10/21/dynamic-programming-kadanes-algorithm/

/*
In simple terms, it states that,
the maximum sum sub-array ending with A[i],
is either the element A[i] itself,
or A[i] combined with the maximum sum sub-array ending with A[i – 1],
whichever is the greater one.
*/

public class MaximumSubArraySum {

    public void maxSumArray(int[] arr){

        int sumSoFar = 0;
        int sumHere = 0;
        for(int i = 0; i< arr.length; i++){
            sumHere = arr[i] > arr[i] + sumSoFar ? arr[i]: sumSoFar +  arr[i];
            sumSoFar = sumHere > sumSoFar ? sumHere: 0;
        }
    }
}
