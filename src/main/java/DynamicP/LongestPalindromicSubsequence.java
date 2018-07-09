package DynamicP;

public class LongestPalindromicSubsequence {

    // https://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
    // O(n^2)

    Integer[][] temp = new Integer[6][6];

    public int algo(int[] array, int start, int end){

        if( end - start <= 0){
            return 0;
        }

        if(array.length == 1){
            return 1;
        }
        if(temp[start][end]!=null){
            return temp[start][end];
        }

        if(array[start] == array[end]){
            temp[start][end] = 2 + algo(array, start+1, end-1);
        }else{
            temp[start][end] = Math.max( algo(array, start+1, end), algo(array, start, end-1) );
        }
        return temp[start][end];

    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int[] arr = new int[]{1,2,3,5,2,1};
        System.out.println(lps.algo(arr, 0, arr.length-1));
    }

}
