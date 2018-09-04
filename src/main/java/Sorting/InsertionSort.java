package Sorting;

/**
 * Created by km on 5/22/18.
 */
public class InsertionSort {

    public int[] data;

    public void sort() {

        int n = data.length;
        for(int i = 1; i < n; i++){

            int element = data[i];
            int j = i -1;

            while( j>=0 && element < data[i]){

                swap(j, i);
                j = j -1;
            }
        }
    }

    private void swap(int j, int i) {

    }
}
