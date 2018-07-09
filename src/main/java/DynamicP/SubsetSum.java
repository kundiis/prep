package DynamicP;

/**
 * Created by km on 6/17/18.
 */
public class SubsetSum {

    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
    /*
     * Time complexity - O(input.size * total_sum)
     * Space complexity - O(input.size*total_sum)
     */

    public static boolean subsetSum(int[] input, int total){

        boolean[][] T = new boolean[input.length][total];

        for(int i = 1; i<= input.length; i++){

            for( int j = 1; j <= total; j++){

                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j - input[i - 1]] || T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }

            }
        }
        return T[input.length][total];
    }
    public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};

        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetSum(arr1, 11));

    }

}
