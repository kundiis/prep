package Sorting;

public class TopKLargest {

    private int findTopKLargest(int[] arr, int k){
        return quickSelect(arr, 0, arr.length-1, arr.length-k);
    }

    private int quickSelect(int[] arr, int left, int right, int k){
        int p = partition2(arr, left, right);
        if(p == k){
            return arr[p];
        }else if( k < p ){
            return quickSelect(arr, left, p-1 ,k);
        }else{
            return quickSelect(arr, p+1, right ,k);
        }
    }

    public int partition2(int A[], int f, int l)
    {
        int pivot = A[l];
        while (f < l)
        {
            while (A[f] < pivot) f++;
            while (A[l] > pivot) l--;
            swap(A, f, l);
        }
        return f;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void main(String[] args) {
        TopKLargest largest = new TopKLargest();
        int[] arr = {1,3,4,6,7,5};
        System.out.println(largest.findTopKLargest(arr, 3)); // 2nd largest
    }

}
