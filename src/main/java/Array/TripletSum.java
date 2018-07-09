package Array;

import java.util.Arrays;

public class TripletSum {

    // 1,3,4,5,7,2,8
    // 10

    // 3,4,5
    // 3,7,2, etc
    int count = 0;

    public int tripletSum(int[] data, int target){

        //sort the array
        Arrays.sort(data); // 1,2,3,4,5,7,8

        for( int i = 0; i< data.length; i++){

            int j = i+1;
            int k = data.length -1;
            while(j < k) {
                if (data[i] + data[j] + data[k] > target) {
                    count++;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {1,2,8};
        TripletSum sum = new TripletSum();
        System.out.println(sum.tripletSum(data,10));
    }
}
