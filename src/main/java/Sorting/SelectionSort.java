package Sorting;

import java.util.Collections;

/**
 * Created by km on 5/22/18.
 */

/*
get first element and compare with the rest, find the smallest and swap
 */

public class SelectionSort {

    public int[] data;

    public void sort(){
        for(int i =0; i< data.length; i++){
            // index
            int index = i;

            for(int j=i+1; j< data.length; j++){
                if(data[j] < data[index] ){
                    swap(j, index);
                    break;
                }
            }
        }
    }

    private void swap(int index, int i) {
        int temp = data[index];
        data[index] = data[i];
        data[i] = temp;
    }
}
