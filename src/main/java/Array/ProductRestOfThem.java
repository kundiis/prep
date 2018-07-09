package Array;

/**
 * Created by km on 6/7/18.
 */
public class ProductRestOfThem {

    int[] numbers = new int[20];

    public void productSum(){

        // 1,2,3,4

        // create an array
        // 1             ,  a[0],      a[0]*a[1], a[0]*a[1]*a[2]
        // a[1]*a[2]*a[3],  a[2]*a[3], a[3]     , 1

        int[] firstNumbers = new int[20];
        int s = 1;
        for( int i =0;i< numbers.length; i++){
            firstNumbers[i] = s;
            s *= firstNumbers[i];
        }

        int[] secondNumbers = new int[20];
        int s2 = 1;
        for( int i = numbers.length-1;i > 0; i--){
            secondNumbers[i] = s;
            s *= secondNumbers[i];
        }

        int[] product = new int[20];
        for(int i = 0; i< product.length; i++){
            product[i] = firstNumbers[i] * secondNumbers[i];
        }
    }
}
