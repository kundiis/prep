package Array;

/**
 * Created by km on 6/6/18.
 */
public class ThreeWayPartition {

    // o(n) and o(1) space
    public void threeWayPartition(int[] array, int low, int high){

        int start = 0; int end = array.length-1;

        for(int i =0; i<array.length;){

            if(array[i] < low){
                //swap
                swap(i, start);
                start++;

            }else if( array[i] > high){
                //swap
                swap(i, end);
                end --;
            }else{
                i++;
            }
        }
    }

    private void swap(int i, int start) {
    }
}

// 0,10,30,15,20,5,12

