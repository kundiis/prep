package DynamicP;

public class LongestCommonSubsequence {

    public static int algo(String s1, String s2){

        int[][] table = new int[s1.length()][s2.length()];
        table[0][0] = 0;
        int max = 0;

        for( int i = 0; i < s1.length(); i++){
            for( int j = 0; j < s2.length(); j++){

                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i==0 || j==0){
                        table[i][j]=1;
                    }
                    else{
                        table[i][j] = 1 + table[i - 1][j - 1];
                    }
                }else{
                    if(i==0 || j==0){
                        table[i][j]=0;
                    }else{
                        table[i][j] = 1+ Math.max(table[i - 1][j], table[i][j - 1]);
                    }
                }
                max = Math.max(table[i][j], max);

            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(algo("abc", "ac"));
    }

}
