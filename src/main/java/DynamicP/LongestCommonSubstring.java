package DynamicP;

public class LongestCommonSubstring {

    public void algo(String s1, String s2, int x, int y){

        int[][] table = new int[x][y];

        for( int i = 0; i< s1.length(); i++){

            for( int j = 0; j < s2.length(); j++){

                if(i==0 || j==0){
                    table[i][j] = 0;
                }else if( s1.charAt(i-1) == s2.charAt(j-1)){
                    table[i][j] = 1 + table[i-1][j-1];
                }else{
                    table[i][j] = 0;
                }

            }

        }

    }
}
