package Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by km on 5/23/18.
 */

public class RadixSort {

    public void sort(int[] array){

        // create the buckets
        List<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i< 10;i++){
            buckets[i] = new ArrayList<>();
        }

        int expo = 1;
        int numberOfZeros = 0;

        while(true){
            // get last byte
            for(int item: array){
                int mod = item % expo;
                buckets[mod].add(item);
                if(mod == 0){
                    numberOfZeros++;
                }
            }

            if(numberOfZeros == array.length){
                break;
            }

            expo = expo * 10;
            int index = 0;

            for(List<Integer> bucketArray: buckets){
                for(int i = 0; i< bucketArray.size(); i++){
                    array[index++] = bucketArray.get(i);
                }
                bucketArray.clear();
            }

        }
    }
}
