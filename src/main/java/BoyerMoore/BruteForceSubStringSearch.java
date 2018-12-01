package BoyerMoore;

/**
 * Created by km on 5/20/18.
 */
public class BruteForceSubStringSearch {

    public static int search(String text, String pattern){

        int lengthOfText = text.length();
        int patternLength = pattern.length();

        for(int i = 0; i < lengthOfText - patternLength; i++){
            int j = 0;
            for( ; j<= patternLength; j++){
                if(text.charAt(i+j) != pattern.charAt(j) ){
                    break;
                }
            }
            if( j == patternLength){
                return i;
            }
        }
        return -1;
    }

}
