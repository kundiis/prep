package Array;

import java.util.Arrays;

/**
 * Created by km on 6/6/18.
 */
public class ThreeWayPartition {

    //https://algs4.cs.princeton.edu/23quicksort/Quick3way.java.html

    // o(n) and o(1) space
    public void threeWayPartition(int[] array, int low, int high){

        int start = 0; int end = array.length-1;

        int i = 0;
        while ( i <= end){

            if(array[i] < low){
                //swap
                swap(array, i, start);
                start++;
                i++;
            }else if( array[i] > high){
                //swap
                swap(array, i, end);
                end--;
            } else{
                i++;
            }

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ThreeWayPartition partition = new ThreeWayPartition();
        int[] data = {0,10,30,15,20,5,12};
        partition.threeWayPartition(data, 10,15);
        System.out.println(Arrays.toString(data));
    }
}
// low and high are ranges of middle element
// 0,10,30,15,20,5,12
//https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/

