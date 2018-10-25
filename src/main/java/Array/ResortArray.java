package Array;


// [1,1,2,3,4,4] -> [1,2,3,4,1,4]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResortArray {

    private void resort(int[] arr){

        List<Integer> temp = new ArrayList<>();
        int pointer = 1;

        for(int i = 1; i< arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                temp.add(arr[i - 1]);
            } else {
                arr[pointer] = arr[i];
                pointer++;
            }
        }
        for(int i = 0; i< temp.size(); i++){
            arr[pointer++] = temp.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,4,4};
        ResortArray resortArray = new ResortArray();
        resortArray.resort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
