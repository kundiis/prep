package Sorting;

/**
 * Created by km on 5/22/18.
 */
public class MergeSort {

    public void sort(){
        int[] data = new int[10];
        mergeSort(data, 0, data.length);
    }

    private void mergeSort(int[] data, int low, int high) {
        if( low < high){
            int mid = (low+high)/2;

            mergeSort(data, low, mid);
            mergeSort(data, mid+1, high);
            merge(data, low, mid, high);
        }
    }

    private void merge(int[] data, int low, int mid, int high) {

        int[] tempArray = new int[data.length];
        for( int i = low; i<high; i++){
            tempArray[i] = data[i];
        }

        int i = low; int j = mid+1; int k = low;
        while( i<= mid && j <= high){
            if(tempArray[i] <= tempArray[j]){
                tempArray[k] = tempArray[i];
                i++;
            }else{
                tempArray[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            tempArray[k] = tempArray[i];
            i++;
            k++;
        }
        while(j <= high){
            tempArray[k] = tempArray[j];
            j++;
            k++;
        }

    }

}
