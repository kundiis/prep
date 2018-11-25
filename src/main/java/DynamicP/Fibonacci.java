package DynamicP;

/**
 * Created by km on 6/2/18.
 */
public class Fibonacci {

    // plain recursive
    public static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1)+fib(n-2);
    }

    // top down - optimal problem from small sub problems
    public static int fib(int n, Integer[] cache){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(cache[n] != null){
            return cache[n];
        }
        cache[n] = fib(n-1, cache)+fib(n-2, cache);
        return cache[n];
    }

    // bottom up
    public static int fibBottom(int n){
        int[] out = new int[n+1];
        out[0] = 0;
        out[1] = 1;
        for(int i = 2; i <= n; i++){
            out[i] = out[i-1] + out[i-2];
        }
        return out[n];
    }

    public static void main(String[] args) {
        Integer[] cache = new Integer[100];
        System.out.println(fib(40, cache));
        System.out.println(fib(40));

        System.out.println(fibBottom(40));
    }
}
