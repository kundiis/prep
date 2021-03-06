package DynamicP;

/**
 * Created by km on 6/17/18.
 */
public class LongestSubSequence {

    public static int lcsDynamic(char[] c1, char[] c2){

        int[][] temp = new int[c1.length+1][c2.length+1];
        int max = 0;

        for(int i=1 ;i< c1.length; i++){
            for( int j = 1; j< c2.length; j++){

                if(c1[i-1] == c2[j-1]){
                    temp[i][j] = 1 + temp[i-1][j-1];
                }else{
                    temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
                }

                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }

        return max;
    }


    public static int lcsRecusion(String s1, String s2, int x, int y, Integer[][] temp){

        if(x==-1 || y == -1){
            return 0;
        }
        if(temp[x][y]!=null) return temp[x][y];

        if(s1.charAt(x) == s2.charAt(y) ){
            temp[x][y] = 1 + lcsRecusion(s1, s2, x-1, y-1, temp);
        }else{
            temp[x][y] = Math.max(lcsRecusion(s1, s2, x-1, y, temp), lcsRecusion(s1, s2, x, y-1, temp));
        }
        return temp[x][y];
    }

    public static void main(String args[]){
        LongestSubSequence lcs = new LongestSubSequence();
        String str1 = "abcd";
        String str2 = "abd";

        //int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        //System.out.print(result);

        System.out.println(lcsRecusion(str1,str2, str1.length()-1, str2.length()-1, new Integer[10][10]));

    }
}
