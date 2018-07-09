package Array;

import java.util.Random;

/**
 * Created by km on 6/6/18.
 */
public class ShuffleArray {

    private int[] array;

    // Fisher-Yates algo

    // o(n)

    public void shuffle(){
        Random rand = new Random();
        for( int i = array.length; i > 0; i--){
            int number = rand.nextInt(i + 1);
            swap(i, number);
        }
    }

    private void swap(int i, int number) {
    }

}
