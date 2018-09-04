package Sorting;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparato {

    public static void main(String[] args) {
        Integer[] arr = {3,4,5,6,7,2};
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (a,b) -> -(a.intValue()-b.intValue()));
        System.out.println(Arrays.toString(arr));
    }

}


