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
                    T[i][j] = 1 + Math.min( T[i-1][j-1], Math.min(T[i-1][j],T[i][j-1]) );  // min of the diagonal and all three
                }
            }
        }
    }

    static int editDistRecursive(String str1 , String str2 , int m ,int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDistRecursive(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDistRecursive(str1,  str2, m, n-1),    // Insert
                editDistRecursive(str1,  str2, m-1, n),   // Remove
                editDistRecursive(str1,  str2, m-1, n-1) // Replace
        );
    }

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
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
