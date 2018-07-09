package DynamicP;

/**
 * Created by km on 6/17/18.
 */
public class MinimumEditDistance {

    public void minimumEditDistance(char[] c1, char[] c2){

        int[][] T = new int[c1.length+1][c2.length+1];

        for(int i =0; i<= c1.length;i++){
            T[i][0] = i;
        }
        for(int i =0; i<= c2.length;i++){
            T[0][i] = i;
        }

        for(int i = 1; i< c1.length; i++){
            for (int j = 1; j< c2.length ; j++){
                if(c1[i-1] == c2[j-1]){
                    T[i][j] = T[i-1][j-1];
                }else{
                    T[i][j] = Math.min( T[i-1][j-1] ,Math.min(T[i-1][j],T[i][j-1]));  // min of the diagonal and all three
                }
            }
        }
    }
}


/*
If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings.
So we recur for lengths m-1 and n-1.
Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last character of first string,
recursively compute minimum cost for all three operations and take minimum of three values.
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1
 */
