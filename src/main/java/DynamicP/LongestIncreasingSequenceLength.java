package DynamicP;

public class LongestIncreasingSequenceLength {

    // https://algorithms.tutorialhorizon.com/dynamic-programming-longest-increasing-subsequence/
    // solution at previous steps is applicable for next step

    public void algo(int[] array){

        int[] temp = new int[array.length];

        for( int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    temp[i]  = Math.max( temp[i], temp[j] + 1);
                }
            }
        }
    }
}
