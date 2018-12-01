package Array;

public class FirstOccurrenceSortedArray {

    private int firstOccurence(int[] nums, int start, int end, int target){

        int result = -1;

        while( start <= end){

            int mid = (start+end)/2;
            if(nums[mid] == target){
                result = mid;
                end = mid-1;
            } else if( target < nums[mid]){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FirstOccurrenceSortedArray array = new FirstOccurrenceSortedArray();
        int[] numbers = new int[]{1,5,5,5,7,9};
        int index = array.firstOccurence(numbers, 0, numbers.length-1, 5);
        System.out.println("Index -->" + index);
    }

}
