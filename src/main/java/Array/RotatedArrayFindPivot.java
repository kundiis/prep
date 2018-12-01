package Array;

public class RotatedArrayFindPivot {

    private int findPivot(int[] nums, int start, int end){

        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] > nums[mid+1]){
                return nums[mid];
            }else if( nums[start] < nums[mid] ) { // array is sorted and the pivot is another half
                start = mid;
            }else{
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedArrayFindPivot array = new RotatedArrayFindPivot();
        int[] numbers = new int[]{10,20,1,3,5,7,9};
        int index = array.findPivot(numbers, 0, numbers.length-1);
        System.out.println("Index -->" + index);
    }

}
