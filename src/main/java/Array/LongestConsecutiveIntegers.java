package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by km on 6/7/18.
 */
public class LongestConsecutiveIntegers {

    int[] data = new int[20];

    public void code(){

        int max = 0;

        Set<Integer> h = new HashSet<>();
        for(int i = 0; i < data.length; i++){
            h.add(data[i]);
        }

        for(int i = 0; i < data.length; i++){

            int count = 1;
            int j = data[i];

            while(h.contains(data[j])){
                j++; // find the most consecutive numbers
                count++;
            }

            if( max < count){
                max = count;
            }
        }
    }
}
