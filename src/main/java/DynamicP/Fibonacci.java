package DynamicP;

/**
 * Created by km on 6/2/18.
 */
public class Fibonacci {


    public static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1)+fib(n-2);
    }


    public static int fib(int n, Integer[] cache){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(cache[n] != null){
            return cache[n];
        }
        cache[n] = fib(n-1, cache)+fib(n-2, cache);
        return cache[n];
    }

    public static void main(String[] args) {
        Integer[] cache = new Integer[100];
        System.out.println(fib(40, cache));
        System.out.println(fib(40));
    }
}
