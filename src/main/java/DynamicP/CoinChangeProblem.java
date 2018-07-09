package DynamicP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by km on 6/17/18.
 */
public class CoinChangeProblem {

    public void coinChange(int[] data, int total){

        int[][] temp = new int[data.length][total];

        for(int i = 1; i< data.length; i++){
            for(int j = 1; j <= total; j++){

                if( j < data[i]){
                    temp[i][j] = temp[i-1][j];
                }else{
                    temp[i][j] = 1 + Math.min(temp[i-1][j], temp[i][j-data[i]]);
                }

            }
        }
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChangeRecursive(int[] coins, int total){

        if(total == 0){
            return 0;
        }

        if(memo.containsKey(total)){
            return memo.get(total);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){

            if(coins[i] > total){
                continue;
            }

            int value = coinChangeRecursive(coins, total - coins[i]);

            if( value < min){
                min = value;
            }
        }

        min = min == Integer.MAX_VALUE ? min: min+1;

        memo.put(total, min);
        return min;
    }
}
