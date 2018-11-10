package Array;

public class IncreasingDecreasing {

    private static int increasingDecreasing(int[] arr){

        return findMax(arr, 0, arr.length-1);

    }

    private static int findMax(int[] arr, int start, int end) {

        while(start < end){
            int mid = (start+end)/2;

            if(mid > 0 && mid< end && arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1] ){
                return arr[mid];
            }

            if(mid < end && arr[mid] < arr[mid+1]){
                start = mid;
            }else{
                end = mid;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] x = {2,3,5,8,9,10,7,3,2};
        System.out.println(increasingDecreasing(x));
    }
}
